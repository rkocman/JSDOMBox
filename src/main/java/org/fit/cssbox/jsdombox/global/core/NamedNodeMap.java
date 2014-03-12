/*
 * NamedNodeMap.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.w3c.dom.DOMException;

/**
 * DOM Interface NamedNodeMap Adapter
 * 
 * @author Radim Kocman
 */
public class NamedNodeMap extends JSAdapter
{
	protected org.w3c.dom.NamedNodeMap source;
	
	public NamedNodeMap(org.w3c.dom.NamedNodeMap source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	
	public JSAdapter getNamedItem(String name)
	{
		String convName = iaf.innerNameFormat(name);
		Object result = source.getNamedItem(convName);
		return iaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter setNamedItem(Node arg)
	{
		Object result = source.setNamedItem(arg.source);
		iaf.recomputeStyles();
		return iaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter removeNamedItem(String name)
	{
		String convName = iaf.innerNameFormat(name);
		Object result = source.removeNamedItem(convName);
		iaf.recomputeStyles();
		return iaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter item(int index)
	{
		Object result = source.item(index);
		return iaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
	public int getLength()
	{
		return source.getLength();
	}
	
	
	// DOM Level 2 Implementation
	
	public JSAdapter getNamedItemNS(String namespaceURI, String localName)
	{
		// getNamedItemNS is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "getNamedItemNS is not supported");
	}
	
	public JSAdapter setNamedItemNS(Node arg)
	{
		// setNamedItemNS is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "setNamedItemNS is not supported");
	}
	
	public JSAdapter removeNamedItemNS(String namespaceURI, String localName)
	{
		// removeNamedItemNS is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "removeNamedItemNS is not supported");
	}
	
}
