/*
 * HTMLFrameSetElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLFrameSetElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLFrameSetElement extends HTMLElement
{
	public HTMLFrameSetElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getCols()
	{
		String attr = jsaf.innerNameFormat("cols");
		return source.getAttribute(attr);
	}
	public void setCols(String cols)
	{
		String attr = jsaf.innerNameFormat("cols");
		source.setAttribute(attr, cols);
	}
	
	public String getRows()
	{
		String attr = jsaf.innerNameFormat("rows");
		return source.getAttribute(attr);
	}
	public void setRows(String rows)
	{
		String attr = jsaf.innerNameFormat("rows");
		source.setAttribute(attr, rows);
	}
	
}
