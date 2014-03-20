/*
 * HTMLOListElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLOListElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLOListElement extends HTMLElement
{
	public HTMLOListElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public boolean getCompact()
	{
		String attr = jsaf.innerNameFormat("compact");
		return source.hasAttribute(attr);
	}
	public void setCompact(boolean compact)
	{
		String attr = jsaf.innerNameFormat("compact");
		setBooleanAttribute(attr, compact);
		jsaf.recomputeStyles();
	}
	
	public int getStart()
	{
		String attr = jsaf.innerNameFormat("start");
		return getIntegerAttribute(attr, 1);
	}
	public void setStart(int start)
	{
		String attr = jsaf.innerNameFormat("start");
		setIntegerAttribute(attr, start);
		jsaf.recomputeStyles();
	}
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return source.getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
		jsaf.recomputeStyles();
	}
	
}
