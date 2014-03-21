/*
 * HTMLModElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLModElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLModElement extends HTMLElement 
{
	public HTMLModElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getCite()
	{
		String attr = jsaf.innerNameFormat("cite");
		return source.getAttribute(attr);
	}
	public void setCite(String cite)
	{
		String attr = jsaf.innerNameFormat("cite");
		source.setAttribute(attr, cite);
	}
	
	public String getDateTime()
	{
		String attr = jsaf.innerNameFormat("datetime");
		return source.getAttribute(attr);
	}
	public void setDateTime(String dateTime)
	{
		String attr = jsaf.innerNameFormat("datetime");
		source.setAttribute(attr, dateTime);
	}
	
}
