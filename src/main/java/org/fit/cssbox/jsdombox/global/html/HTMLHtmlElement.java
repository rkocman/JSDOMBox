/*
 * HTMLHtmlElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;

/**
 * DOM Interface HTMLHtmlElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLHtmlElement extends HTMLElement
{
	public HTMLHtmlElement(org.w3c.dom.Element source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getVersion()
	{
		String attr = iaf.innerNameFormat("version");
		return source.getAttribute(attr);
	}
	public void setVersion(String version)
	{
		String attr = iaf.innerNameFormat("version");
		source.setAttribute(attr, version);
	}
	
}
