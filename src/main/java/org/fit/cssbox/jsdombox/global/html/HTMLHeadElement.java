/*
 * HTMLHeadElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;

/**
 * DOM Interface HTMLHeadElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLHeadElement extends HTMLElement 
{
	public HTMLHeadElement(org.w3c.dom.Element source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
	}

	
	// DOM Level 2 HTML Implementation
	
	public String getProfile()
	{
		String attr = iaf.innerNameFormat("profile");
		return source.getAttribute(attr);
	}
	public void setProfile(String profile)
	{
		String attr = iaf.innerNameFormat("profile");
		source.setAttribute(attr, profile);
	}
	
}
