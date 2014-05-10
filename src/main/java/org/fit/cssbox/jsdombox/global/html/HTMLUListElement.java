/*
 * HTMLUListElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLUListElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLUListElement extends HTMLElement
{
	public HTMLUListElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
		jsaf.cssEvent.recomputeStyles(source);
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
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
