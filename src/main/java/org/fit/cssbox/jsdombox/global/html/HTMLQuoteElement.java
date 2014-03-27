/*
 * HTMLQuoteElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLQuoteElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLQuoteElement extends HTMLElement
{
	public HTMLQuoteElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getCite()
	{
		String attr = jsaf.innerNameFormat("cite");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setCite(String cite)
	{
		String attr = jsaf.innerNameFormat("cite");
		source.setAttribute(attr, cite);
	}
	
}
