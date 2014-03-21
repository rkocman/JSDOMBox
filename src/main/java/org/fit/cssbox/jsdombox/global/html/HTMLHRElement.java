/*
 * HTMLHRElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLHRElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLHRElement extends HTMLElement
{
	public HTMLHRElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
		jsaf.recomputeStyles();
	}
	
	public boolean getNoShade()
	{
		String attr = jsaf.innerNameFormat("noshade");
		return source.hasAttribute(attr);
	}
	public void setNoShade(boolean noShade)
	{
		String attr = jsaf.innerNameFormat("noshade");
		setBooleanAttribute(attr, noShade);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
	}
	
}
