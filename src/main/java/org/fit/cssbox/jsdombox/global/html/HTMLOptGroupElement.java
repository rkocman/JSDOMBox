/*
 * HTMLOptGroupElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLOptGroupElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLOptGroupElement extends HTMLElement
{
	public HTMLOptGroupElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public boolean getDisabled()
	{
		String attr = jsaf.innerNameFormat("disabled");
		return source.hasAttribute(attr);
	}
	public void setDisabled(boolean disabled)
	{
		String attr = jsaf.innerNameFormat("disabled");
		setBooleanAttribute(attr, disabled);
		jsaf.recomputeStyles();
	}
	
	public String getLabel()
	{
		String attr = jsaf.innerNameFormat("label");
		return source.getAttribute(attr);
	}
	public void setLabel(String label)
	{
		String attr = jsaf.innerNameFormat("label");
		source.setAttribute(attr, label);
	}
	
}
