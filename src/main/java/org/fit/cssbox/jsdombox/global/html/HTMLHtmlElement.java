/*
 * HTMLHtmlElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLHtmlElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLHtmlElement extends HTMLElement
{
	public HTMLHtmlElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getVersion()
	{
		String attr = jsaf.innerNameFormat("version");
		return source.getAttribute(attr);
	}
	public void setVersion(String version)
	{
		String attr = jsaf.innerNameFormat("version");
		source.setAttribute(attr, version);
	}
	
}
