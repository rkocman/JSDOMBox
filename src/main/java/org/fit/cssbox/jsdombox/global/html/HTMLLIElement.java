/*
 * HTMLLIElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLLIElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLLIElement extends HTMLElement
{
	public HTMLLIElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return source.getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public int getValue()
	{
		String attr = jsaf.innerNameFormat("value");
		return getIntegerAttribute(attr, 0);
	}
	public void setValue(int value)
	{
		String attr = jsaf.innerNameFormat("value");
		setIntegerAttribute(attr, value);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
