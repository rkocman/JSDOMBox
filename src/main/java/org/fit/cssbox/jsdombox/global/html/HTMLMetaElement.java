/*
 * HTMLMetaElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLMetaElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLMetaElement extends HTMLElement
{
	public HTMLMetaElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getContent()
	{
		String attr = jsaf.innerNameFormat("content");
		return source.getAttribute(attr);
	}
	public void setContent(String content)
	{
		String attr = jsaf.innerNameFormat("content");
		source.setAttribute(attr, content);
	}
	
	public String getHttpEquiv()
	{
		String attr = jsaf.innerNameFormat("http-equiv");
		return source.getAttribute(attr);
	}
	public void setHttpEquiv(String httpEquiv)
	{
		String attr = jsaf.innerNameFormat("http-equiv");
		source.setAttribute(attr, httpEquiv);
	}
	
	public String getName()
	{
		String attr = jsaf.innerNameFormat("name");
		return source.getAttribute(attr);
	}
	public void setName(String name)
	{
		String attr = jsaf.innerNameFormat("name");
		source.setAttribute(attr, name);
	}
	
	public String getScheme()
	{
		String attr = jsaf.innerNameFormat("scheme");
		return source.getAttribute(attr);
	}
	public void setScheme(String scheme)
	{
		String attr = jsaf.innerNameFormat("scheme");
		source.setAttribute(attr, scheme);
	}
	
}
