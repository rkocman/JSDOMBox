/*
 * HTMLPreElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLPreElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLPreElement extends HTMLElement
{
	public HTMLPreElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public int getWidth()
	{
		String attr = jsaf.innerNameFormat("width");
		return getIntegerAttribute(attr, 0);
	}
	public void setWidth(int width) {
		String attr = jsaf.innerNameFormat("width");
		setIntegerAttribute(attr, width);
	}
	
}
