/*
 * HTMLBaseElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLBaseElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLBaseElement extends HTMLElement
{
	public HTMLBaseElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getHref()
	{
		String attr = jsaf.innerNameFormat("href");
		return source.getAttribute(attr);
	}
	public void setHref(String href)
	{
		String attr = jsaf.innerNameFormat("href");
		source.setAttribute(attr, href);
	}
	
	public String getTarget()
	{
		String attr = jsaf.innerNameFormat("target");
		return source.getAttribute(attr);
	}
	public void setTarget(String target)
	{
		String attr = jsaf.innerNameFormat("target");
		source.setAttribute(attr, target);
	}
	
}
