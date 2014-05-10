/*
 * HTMLDListElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLDListElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLDListElement extends HTMLElement
{
	public HTMLDListElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public boolean getCompact()
	{
		String attr = jsaf.innerNameFormat("compact");
		return source.hasAttribute(attr);
	}
	public void setCompact(boolean compact)
	{
		String attr = jsaf.innerNameFormat("compact");
		setBooleanAttribute(attr, compact);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
