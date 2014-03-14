/*
 * DefaultCSSBoxFactory.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

import org.fit.cssbox.jsdombox.event.HTMLListener;
import org.fit.cssbox.jsdombox.global.core.*;
import org.fit.cssbox.jsdombox.global.html.*;
import org.fit.cssbox.jsdombox.js.JSAnalyzer;

/**
 * Default JS Adapter Factory for CSSBox DOM
 * 
 * @author Radim Kocman
 */
public class DefaultCSSBoxFactory extends JSAdapterFactory
{
	protected JSAnalyzer jsa;
	
	public DefaultCSSBoxFactory(JSAnalyzer jsa, HTMLListener htmlListener)
	{
		this.jsa = jsa;
		this.htmlEvent = htmlListener;
	}

	/**
	 * Creates appropriate JS adapter for the Java DOM object
	 * @param source Java DOM object
	 * @param type JSAdapter type
	 * @return Initialized JS adapter
	 */
	public JSAdapter create(Object source, JSAdapterType type)
	{
		// Null is null
		if (source == null)
			return null;
		
		
		// Prior handlers
		
		// Interface NodeList
		if (type == JSAdapterType.NODE_LIST)
			return new NodeList((org.w3c.dom.NodeList) source, this);	
		// Interface NamedNodeMap
		if (type == JSAdapterType.NAMED_NODE_MAP)
			return new NamedNodeMap((org.w3c.dom.NamedNodeMap) source, this);
		
		
		
		// HTML Interfaces
		
		if (source instanceof org.w3c.dom.Element) {
			switch (((org.w3c.dom.Element) source).getTagName()) {		
			// Interface HTMLHtmlElement
			case "html":
				return new HTMLHtmlElement((org.w3c.dom.Element) source, this);
			// Interface HTMLHeadElement
			case "head":
				return new HTMLHeadElement((org.w3c.dom.Element) source, this);
			// Interface HTMLLinkElement
			case "link":
				return new HTMLLinkElement((org.w3c.dom.Element) source, this);
			// Interface HTMLTitleElement
			case "title":
				return new HTMLTitleElement((org.w3c.dom.Element) source, this);
			// Interface HTMLMetaElement
			case "meta":
				return new HTMLMetaElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBaseElement
			case "base":
				return new HTMLBaseElement((org.w3c.dom.Element) source, this);
			// Interface HTMLStyleElement
			case "style":
				return new HTMLStyleElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBodyElement
			case "body":
				return new HTMLBodyElement((org.w3c.dom.Element) source, this);
			
			// Interface HTMLElement
			default:
				return new HTMLElement((org.w3c.dom.Element) source, this);
			}
		}
		
		
		
		// Core interfaces
		
		// Interface DOMImplementation
		if (source instanceof org.w3c.dom.DOMImplementation)
			return new DOMImplementation((org.w3c.dom.DOMImplementation) source, this);
		// Interface Document
		if (source instanceof org.w3c.dom.Document)
			return new Document((org.w3c.dom.Document) source, this);
		// Interface DocumentFragment
		if (source instanceof org.w3c.dom.DocumentFragment)
			return new DocumentFragment((org.w3c.dom.DocumentFragment) source, this);
		
		// Interface Attr
		if (source instanceof org.w3c.dom.Attr)
			return new Attr((org.w3c.dom.Attr) source, this);
		
		// Interface Comment
		if (source instanceof org.w3c.dom.Comment)
			return new Comment((org.w3c.dom.Comment) source, this);
		// Interface Text
		if (source instanceof org.w3c.dom.Text)
			return new Text((org.w3c.dom.Text) source, this);
		
		// Interface Node
		if (source instanceof org.w3c.dom.Node)
			return new Node((org.w3c.dom.Node) source, this);
		
		
		
		// Fall-back to Base Adapter
		System.err.println("*** JavaScript Adapter Factory fall-back");
		return new JSAdapter(source, this);
	}
	
	/**
	 * Recomputes CSS in CSSBox
	 */
	public void recomputeStyles()
	{
		jsa.recomputeStyles();
	}
	
	/**
	 * Converts names into inner DOM format (lowercase)
	 */
	public String innerNameFormat(String name)
	{
		return name.toLowerCase();
	}
	
}
