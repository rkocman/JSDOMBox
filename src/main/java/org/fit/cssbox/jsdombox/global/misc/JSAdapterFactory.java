/*
 * JSAdapterFactory.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

import org.fit.cssbox.jsdombox.global.core.*;
import org.fit.cssbox.jsdombox.js.JSAnalyzer;

/**
 * Default implementation of the JS Adapter Factory
 * 
 * @author Radim Kocman
 */
public class JSAdapterFactory implements IJSAdapterFactory
{
	protected JSAnalyzer jsa;
	
	public JSAdapterFactory(JSAnalyzer jsa)
	{
		this.jsa = jsa;
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
		
		// Interface Element
		if (source instanceof org.w3c.dom.Element)
			return new Element((org.w3c.dom.Element) source, this);
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
