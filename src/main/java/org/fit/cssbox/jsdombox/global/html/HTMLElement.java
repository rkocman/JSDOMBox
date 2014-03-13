/*
 * HTMLElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Element;
import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;

/**
 * DOM Interface HTMLElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLElement extends Element
{
	public HTMLElement(org.w3c.dom.Element source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getId()
	{
		String attr = iaf.innerNameFormat("id");
		return source.getAttribute(attr);
	}
	public void setId(String id)
	{
		String attr = iaf.innerNameFormat("id");
		source.setAttribute(attr, id);
		iaf.recomputeStyles();
	}
	
	public String getTitle()
	{
		String attr = iaf.innerNameFormat("title");
		return source.getAttribute(attr);
	}
	public void setTitle(String title)
	{
		String attr = iaf.innerNameFormat("title");
		source.setAttribute(attr, title);
	}
	
	public String getLang()
	{
		String attr = iaf.innerNameFormat("lang");
		return source.getAttribute(attr);
	}
	public void setLang(String lang)
	{
		String attr = iaf.innerNameFormat("lang");
		source.setAttribute(attr, lang);
	}
	
	public String getDir()
	{
		String attr = iaf.innerNameFormat("dir");
		return source.getAttribute(attr).toLowerCase();
	}
	public void setDir(String dir)
	{
		String attr = iaf.innerNameFormat("dir");
		source.setAttribute(attr, dir);
		iaf.recomputeStyles();
	}
	
	public String getClassName()
	{
		String attr = iaf.innerNameFormat("class");
		return source.getAttribute(attr);
	}
	public void setClassName(String className)
	{
		String attr = iaf.innerNameFormat("class");
		source.setAttribute(attr, className);
		iaf.recomputeStyles();
	}
	
}
