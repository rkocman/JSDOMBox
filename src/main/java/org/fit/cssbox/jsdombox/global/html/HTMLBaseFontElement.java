/*
 * HTMLBaseFontElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLBaseFontElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLBaseFontElement extends HTMLElement
{
	public HTMLBaseFontElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getColor()
	{
		String attr = jsaf.innerNameFormat("color");
		return source.getAttribute(attr);
	}
	public void setColor(String color)
	{
		String attr = jsaf.innerNameFormat("color");
		source.setAttribute(attr, color);
		jsaf.recomputeStyles();
	}
	
	public String getFace()
	{
		String attr = jsaf.innerNameFormat("face");
		return source.getAttribute(attr);
	}
	public void setFace(String face)
	{
		String attr = jsaf.innerNameFormat("face");
		source.setAttribute(attr, face);
		jsaf.recomputeStyles();
	}
	
	public int getSize()
	{
		String attr = jsaf.innerNameFormat("size");
		return getIntegerAttribute(attr, 3); // Default size 3 from the IE
	}
	public void setSize(int size)
	{
		String attr = jsaf.innerNameFormat("size");
		setIntegerAttribute(attr, size);
		jsaf.recomputeStyles();
	}
	
}
