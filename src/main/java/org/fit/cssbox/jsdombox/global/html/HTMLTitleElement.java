/*
 * HTMLTitleElement.java
 * Copyright (c) Radim Kocman
 */


package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLTitleElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTitleElement extends HTMLElement
{
	public HTMLTitleElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getText()
	{
		return source.getTextContent();
	}
	public void setText(String text)
	{
		source.setTextContent(text);
	}
	
}
