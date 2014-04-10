/*
 * HTMLMapElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLMapElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLMapElement extends HTMLElement
{
	protected HTMLCollection areas;
	
	public HTMLMapElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		// Areas HTMLCollection
		String area = jsaf.innerNameFormat("area");
		String[] tags = new String[] {area};
		String[] skippedTags = new String[] {};
		areas = new HTMLCollection(source, jsaf, tags, skippedTags);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getAreas()
	{
		return areas;
	}
	
	public String getName()
	{
		String attr = jsaf.innerNameFormat("name");
		return source.getAttribute(attr);
	}
	public void setName(String name)
	{
		String attr = jsaf.innerNameFormat("name");
		source.setAttribute(attr, name);
	}
	
}
