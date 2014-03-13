/*
 * HTMLHeadElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLHeadElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLHeadElement extends HTMLElement 
{
	public HTMLHeadElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}

	
	// DOM Level 2 HTML Implementation
	
	public String getProfile()
	{
		String attr = jsaf.innerNameFormat("profile");
		return source.getAttribute(attr);
	}
	public void setProfile(String profile)
	{
		String attr = jsaf.innerNameFormat("profile");
		source.setAttribute(attr, profile);
	}
	
}
