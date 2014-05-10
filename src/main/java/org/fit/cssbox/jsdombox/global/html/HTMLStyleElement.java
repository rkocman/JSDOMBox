/*
 * HTMLStyleElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLStyleElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLStyleElement extends HTMLElement
{
	public HTMLStyleElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public boolean getDisabled()
	{
		return jsaf.htmlEvent.style_getDisabled(source);
	}
	public void setDisabled(boolean disabled)
	{
		jsaf.htmlEvent.style_setDisabled(source, disabled);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getMedia()
	{
		String attr = jsaf.innerNameFormat("media");
		return source.getAttribute(attr);
	}
	public void setMedia(String media)
	{
		String attr = jsaf.innerNameFormat("media");
		source.setAttribute(attr, media);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return source.getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
