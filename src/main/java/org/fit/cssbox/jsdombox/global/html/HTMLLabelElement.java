/*
 * HTMLLabelElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLLabelElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLLabelElement extends HTMLElement
{
	public HTMLLabelElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public String getAccessKey()
	{
		String attr = jsaf.innerNameFormat("accesskey");
		return source.getAttribute(attr);
	}
	public void setAccessKey(String accessKey)
	{
		String attr = jsaf.innerNameFormat("accesskey");
		source.setAttribute(attr, accessKey);
	}
	
	public String getHtmlFor()
	{
		String attr = jsaf.innerNameFormat("for");
		return source.getAttribute(attr);
	}
	public void setHtmlFor(String htmlFor)
	{
		String attr = jsaf.innerNameFormat("for");
		source.setAttribute(attr, htmlFor);
	}
	
}
