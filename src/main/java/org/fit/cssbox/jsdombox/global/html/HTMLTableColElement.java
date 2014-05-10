/*
 * HTMLTableColElement.java
 * Copyright (c) Radim Kocman
 */


package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLTableColElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTableColElement extends HTMLElement
{
	public HTMLTableColElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getAlign()
	{
		String attr = jsaf.innerNameFormat("align");
		return source.getAttribute(attr);
	}
	public void setAlign(String align)
	{
		String attr = jsaf.innerNameFormat("align");
		source.setAttribute(attr, align);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getCh()
	{
		String attr = jsaf.innerNameFormat("char");
		return source.getAttribute(attr);
	}
	public void setCh(String ch)
	{
		String attr = jsaf.innerNameFormat("char");
		source.setAttribute(attr, ch);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getChOff()
	{
		String attr = jsaf.innerNameFormat("charoff");
		return source.getAttribute(attr);
	}
	public void setChOff(String chOff)
	{
		String attr = jsaf.innerNameFormat("charoff");
		source.setAttribute(attr, chOff);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public int getSpan()
	{
		String attr = jsaf.innerNameFormat("span");
		return getUnsignedAttribute(attr, 1);
	}
	public void setSpan(int span)
	{
		String attr = jsaf.innerNameFormat("span");
		setIntegerAttribute(attr, span);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getvAlign()
	{
		String attr = jsaf.innerNameFormat("valign");
		return source.getAttribute(attr);
	}
	public void setvAlign(String vAlign)
	{
		String attr = jsaf.innerNameFormat("valign");
		source.setAttribute(attr, vAlign);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getWidth()
	{
		String attr = jsaf.innerNameFormat("width");
		return source.getAttribute(attr);
	}
	public void setWidth(String width)
	{
		String attr = jsaf.innerNameFormat("width");
		source.setAttribute(attr, width);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
