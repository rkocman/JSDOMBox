/*
 * HTMLFontElement.java
 * Copyright (c) Radim Kocman
 */


package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLFontElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLFontElement extends HTMLElement
{
	public HTMLFontElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
		jsaf.cssEvent.recomputeStyles(source);
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
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getSize()
	{
		String attr = jsaf.innerNameFormat("size");
		return source.getAttribute(attr);
	}
	public void setSize(String size)
	{
		String attr = jsaf.innerNameFormat("size");
		source.setAttribute(attr, size);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
