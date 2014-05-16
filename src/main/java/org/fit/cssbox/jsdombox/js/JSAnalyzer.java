/*
 * JSAnalyzer.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.js;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.SimpleBindings;

import org.fit.cssbox.css.DOMAnalyzer;
import org.fit.cssbox.jsdombox.event.*;
import org.fit.cssbox.jsdombox.global.core.Document;
import org.fit.cssbox.jsdombox.global.misc.*;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * This class implements methods for the JS analysis 
 * 
 * @author Radim Kocman
 */
public class JSAnalyzer 
{
	protected DOMAnalyzer da;
	protected org.w3c.dom.Document doc;
	protected URL basePath;
	
	// JavaScript
	protected ScriptEngineManager manager;
	protected ScriptEngine engine;
	
	// Global objects
	protected JSAdapterFactory jsaf;
	protected Document document;
	protected Window window;
	protected PrototypeDOMException pDOMException;
	protected PrototypeNode pNode;
	
	
	//////////////
	// Settings //
	//////////////
	
	/**
	 * Creates a new JS analyzer
	 * @param da Initialized CSSBox analyzer 
	 * @param basePath The URL of the document
	 */
	public JSAnalyzer(DOMAnalyzer da, URL basePath)
	{
		this.da = da;
		this.doc = da.getRoot().getOwnerDocument();
		this.basePath = basePath;
		
		// JavaScript
		manager = new ScriptEngineManager();
		engine = manager.getEngineByName("rhino");
		
		// Global objects
		HTMLListener htmlListener = new EmptyHTMLListener();
		CSSListener cssListener = new EmptyCSSListener();
		ParserListener parserListener = new EmptyParserListener();
		jsaf = new DefaultCSSBoxFactory(doc, basePath, 
				htmlListener, cssListener, parserListener);
		document = (Document) jsaf.create(doc, JSAdapterType.DOCUMENT);
		window = new Window();
		window.document = document;
		pDOMException = new PrototypeDOMException();
		pNode = new PrototypeNode();
	}
	
	/**
	 * Sets a new HTMLListener
	 */
	public void setHTMLListener(HTMLListener htmlListener)
	{
		jsaf.htmlEvent = htmlListener;
	}
	
	/**
	 * Sets a new CSSListener
	 */
	public void setCSSListener(CSSListener cssListener)
	{
		jsaf.cssEvent = cssListener;
	}
	
	/**
	 * Sets a new ParserListener
	 */
	public void setParserListener(ParserListener parserListener)
	{
		jsaf.parserEvent = parserListener;
	}
	
	/**
	 * Sets a new JavaScript engine
	 * @param engineName Engine name used in the ScriptEngineManager
	 */
	public void setJSEngine(String engineName)
	{
		engine = manager.getEngineByName(engineName);
	}
	
	/**
	 * Sets a new JSAdapterFactory 
	 * (this also overrides the current listeners)
	 */
	public void setJSAdapterFactory(JSAdapterFactory jsaf)
	{
		this.jsaf = jsaf;
		document = (Document) jsaf.create(doc, JSAdapterType.DOCUMENT);
		window.document = document;
	}

	
	////////////////
	// JavaScript //
	////////////////
	
	/**
	 * Run all JS scripts in the document
	 */
	public void run()
	{
		Element doc = da.getRoot();
		List<String> scripts = getScripts(doc);
		for (String script : scripts) {
			execute(script);
		}
	}
	
	/**
	 * Get all eligible scripts from the document
	 * @param doc The document to be analyzed
	 * @return List of scripts
	 */
	private List<String> getScripts(Element doc)
	{
		/*
		 * This is just a basic algorithm
		 * All <script> tags are considered to be JS
		 */
		List<String> list = new ArrayList<String>();
		
		NodeList nl = doc.getElementsByTagName("script");
		for (int i = 0; i < nl.getLength(); i++) {
			list.add(nl.item(i).getTextContent());
		}
		
		return list;
	}
	
	/**
	 * Execute the script
	 * @param script JavaScript code
	 */
	private void execute(String script)
	{
		try {
			
			SimpleBindings bindings = new SimpleBindings();
			bindings.put("document", document);
			bindings.put("window", window);
			bindings.put("DOMException", pDOMException);
			bindings.put("Node", pNode);
			engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
			
			Object result = engine.eval(script);
			System.out.println(result);
			
		} catch (Exception e) {
			System.err.println("*** JavaScript Error: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
}
