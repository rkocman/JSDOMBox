/*
 * HTMLAppletElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLAppletElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLAppletElement extends HTMLElement
{
	public HTMLAppletElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
	
	public String getArchive()
	{
		String attr = jsaf.innerNameFormat("archive");
		return source.getAttribute(attr);
	}
	public void setArchive(String archive)
	{
		String attr = jsaf.innerNameFormat("archive");
		source.setAttribute(attr, archive);
	}
	
	public String getCode()
	{
		String attr = jsaf.innerNameFormat("code");
		return source.getAttribute(attr);
	}
	public void setCode(String code)
	{
		String attr = jsaf.innerNameFormat("code");
		source.setAttribute(attr, code);
	}
	
	public String getCodeBase()
	{
		String attr = jsaf.innerNameFormat("codebase");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setCodeBase(String codeBase)
	{
		String attr = jsaf.innerNameFormat("codebase");
		source.setAttribute(attr, codeBase);
	}
	
	public String getHeight()
	{
		String attr = jsaf.innerNameFormat("height");
		return source.getAttribute(attr);
	}
	public void setHeight(String height)
	{
		String attr = jsaf.innerNameFormat("height");
		source.setAttribute(attr, height);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public int getHspace()
	{
		String attr = jsaf.innerNameFormat("hspace");
		return getUnsignedAttribute(attr, 0);
	}
	public void setHspace(int hspace)
	{
		String attr = jsaf.innerNameFormat("hspace");
		setIntegerAttribute(attr, hspace);
		jsaf.cssEvent.recomputeStyles(source);
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
	
	public String getObject()
	{
		String attr = jsaf.innerNameFormat("object");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setObject(String object)
	{
		String attr = jsaf.innerNameFormat("object");
		source.setAttribute(attr, object);
	}
	
	public int getVspace()
	{
		String attr = jsaf.innerNameFormat("vspace");
		return getUnsignedAttribute(attr, 0);
	}
	public void setVspace(int vspace)
	{
		String attr = jsaf.innerNameFormat("vspace");
		setIntegerAttribute(attr, vspace);
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
