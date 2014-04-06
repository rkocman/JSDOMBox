/*
 * HTMLFieldSetElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLFieldSetElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLFieldSetElement extends HTMLElement
{
	public HTMLFieldSetElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
}
