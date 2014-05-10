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
import org.fit.cssbox.jsdombox.event.CSSListener;
import org.fit.cssbox.jsdombox.event.EmptyCSSListener;
import org.fit.cssbox.jsdombox.event.EmptyParserListener;
import org.fit.cssbox.jsdombox.event.HTMLListener;
import org.fit.cssbox.jsdombox.event.ParserListener;
import org.fit.cssbox.jsdombox.event.TestHTMLListener;
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
	protected ScriptEngine engine;
	
	// Global objects
	protected Window window;
	protected Document document;
	protected PrototypeDOMException pDOMException;
	protected PrototypeNode pNode;
	
	/**
	 * Creates a new JS analyzer
	 * @param da  Initialized CSSBox analyzer 
	 * @param doc The document to be analyzed
	 */
	public JSAnalyzer(DOMAnalyzer da, org.w3c.dom.Document doc, URL basePath)
	{
		this.da = da;
		this.doc = doc;
		this.basePath = basePath;
		
		// JS Engine
		ScriptEngineManager manager = new ScriptEngineManager();
		engine = manager.getEngineByName("js");
		
		// JS Interface
		HTMLListener htmlListener = new TestHTMLListener();
		CSSListener cssListener = new EmptyCSSListener();
		ParserListener parserListener = new EmptyParserListener();
		JSAdapterFactory af = new DefaultCSSBoxFactory(doc, basePath, 
				htmlListener, cssListener, parserListener);
		window = new Window();
		document = (Document) af.create(doc, JSAdapterType.DOCUMENT);
		window.document = document;
		pDOMException = new PrototypeDOMException();
		pNode = new PrototypeNode();
	}

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
		// TODO proper algorithm required
		
		List<String> list = new ArrayList<String>();
		
		NodeList nl = doc.getElementsByTagName("script");
		for (int i = 0; i < nl.getLength(); i++) {
			list.add(nl.item(i).getTextContent());
		}
		
		return list;
	}
	
	/**
	 * Execute script with a default Java engine
	 * @param script JavaScript code
	 */
	private void execute(String script)
	{
		try {
			
			SimpleBindings bindings = new SimpleBindings();
			bindings.put("window", window);
			bindings.put("document", document);
			bindings.put("DOMException", pDOMException);
			bindings.put("Node", pNode);
			engine.setBindings(bindings, ScriptContext.ENGINE_SCOPE);
			
			// TODO security problems
			
			Object result = engine.eval(script);
			System.out.println(result);
			
		} catch (Exception e) {
			// TODO recovery is necessary
			
			System.err.println("*** JavaScript Error: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
}
