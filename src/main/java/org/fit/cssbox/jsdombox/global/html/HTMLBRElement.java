/*
 * HTMLBRElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLBRElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLBRElement extends HTMLElement
{
	public HTMLBRElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getClear()
	{
		String attr = jsaf.innerNameFormat("clear");
		return source.getAttribute(attr);
	}
	public void setClear(String clear)
	{
		String attr = jsaf.innerNameFormat("clear");
		source.setAttribute(attr, clear);
		jsaf.recomputeStyles();
	}
	
}
