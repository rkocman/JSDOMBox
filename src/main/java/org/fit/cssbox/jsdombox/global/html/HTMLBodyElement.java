/*
 * HTMLBodyElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLBodyElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLBodyElement extends HTMLElement 
{
	public HTMLBodyElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getaLink()
	{
		String attr = jsaf.innerNameFormat("alink");
		return source.getAttribute(attr);
	}
	public void setaLink(String aLink)
	{
		String attr = jsaf.innerNameFormat("alink");
		source.setAttribute(attr, aLink);
		jsaf.recomputeStyles();
	}
	
	public String getBackground()
	{
		String attr = jsaf.innerNameFormat("background");
		return source.getAttribute(attr);
	}
	public void setBackground(String background)
	{
		String attr = jsaf.innerNameFormat("background");
		source.setAttribute(attr, background);
		jsaf.recomputeStyles();
	}
	
	public String getBgColor()
	{
		String attr = jsaf.innerNameFormat("bgcolor");
		return source.getAttribute(attr);
	}
	public void setBgColor(String bgColor)
	{
		String attr = jsaf.innerNameFormat("bgcolor");
		source.setAttribute(attr, bgColor);
		jsaf.recomputeStyles();
	}
	
	public String getLink()
	{
		String attr = jsaf.innerNameFormat("link");
		return source.getAttribute(attr);
	}
	public void setLink(String link)
	{
		String attr = jsaf.innerNameFormat("link");
		source.setAttribute(attr, link);
		jsaf.recomputeStyles();
	}
	
	public String getText()
	{
		String attr = jsaf.innerNameFormat("text");
		return source.getAttribute(attr);
	}
	public void setText(String text)
	{
		String attr = jsaf.innerNameFormat("text");
		source.setAttribute(attr, text);
		jsaf.recomputeStyles();
	}
	
	public String getvLink()
	{
		String attr = jsaf.innerNameFormat("vlink");
		return source.getAttribute(attr);
	}
	public void setvLink(String vLink)
	{
		String attr = jsaf.innerNameFormat("vlink");
		source.setAttribute(attr, vLink);
		jsaf.recomputeStyles();
	}
	
}
