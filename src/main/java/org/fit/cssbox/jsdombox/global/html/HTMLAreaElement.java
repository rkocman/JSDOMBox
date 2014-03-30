/*
 * HTMAreaLElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLAreaElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLAreaElement extends HTMLElement
{
	public HTMLAreaElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getAccessKey()
	{
		String attr = jsaf.innerNameFormat("accesskey");
		return source.getAttribute(attr);
	}
	public void setAccessKey(String accessKey)
	{
		String attr = jsaf.innerNameFormat("accesskey");
		source.setAttribute(attr, accessKey);
	}
	
	public String getAlt()
	{
		String attr = jsaf.innerNameFormat("alt");
		return source.getAttribute(attr);
	}
	public void setAlt(String alt)
	{
		String attr = jsaf.innerNameFormat("alt");
		source.setAttribute(attr, alt);
	}
	
	public String getCoords()
	{
		String attr = jsaf.innerNameFormat("coords");
		return source.getAttribute(attr);
	}
	public void setCoords(String coords)
	{
		String attr = jsaf.innerNameFormat("coords");
		source.setAttribute(attr, coords);
		jsaf.recomputeStyles();
	}
	
	public String getHref()
	{
		String attr = jsaf.innerNameFormat("href");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setHref(String href)
	{
		String attr = jsaf.innerNameFormat("href");
		source.setAttribute(attr, href);
	}
	
	public boolean getNoHref()
	{
		String attr = jsaf.innerNameFormat("nohref");
		return source.hasAttribute(attr);
	}
	public void setNoHref(boolean noHref)
	{
		String attr = jsaf.innerNameFormat("nohref");
		setBooleanAttribute(attr, noHref);
	}
	
	public String getShape()
	{
		String attr = jsaf.innerNameFormat("shape");
		return source.getAttribute(attr);
	}
	public void setShape(String shape)
	{
		String attr = jsaf.innerNameFormat("shape");
		source.setAttribute(attr, shape);
		jsaf.recomputeStyles();
	}
	
	public int getTabIndex()
	{
		String attr = jsaf.innerNameFormat("tabindex");
		return getIntegerAttribute(attr, 0);
	}
	public void setTabIndex(int tabIndex)
	{
		String attr = jsaf.innerNameFormat("tabindex");
		setIntegerAttribute(attr, tabIndex);
	}
	
	public String getTarget()
	{
		String attr = jsaf.innerNameFormat("target");
		return source.getAttribute(attr);
	}
	public void setTarget(String target)
	{
		String attr = jsaf.innerNameFormat("target");
		source.setAttribute(attr, target);
	}
	
}
