/*
 * HTMLIsIndexElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLIsIndexElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLIsIndexElement extends HTMLElement
{
	public HTMLIsIndexElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public String getPrompt()
	{
		String attr = jsaf.innerNameFormat("prompt");
		return source.getAttribute(attr);
	}
	public void setPrompt(String prompt)
	{
		String attr = jsaf.innerNameFormat("prompt");
		source.setAttribute(attr, prompt);
	}
	
}
