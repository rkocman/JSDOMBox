/*
 * HTMLImageElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLImageElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLImageElement extends HTMLElement
{
	public HTMLImageElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
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
	
	public String getBorder()
	{
		String attr = jsaf.innerNameFormat("border");
		return source.getAttribute(attr);
	}
	public void setBorder(String border)
	{
		String attr = jsaf.innerNameFormat("border");
		source.setAttribute(attr, border);
		jsaf.recomputeStyles();
	}
	
	public int getHeight()
	{
		String attr = jsaf.innerNameFormat("height");
		return getUnsignedAttribute(attr, 0);
	}
	public void setHeight(int height)
	{
		String attr = jsaf.innerNameFormat("height");
		setIntegerAttribute(attr, height);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
	}
	
	public boolean getIsMap()
	{
		String attr = jsaf.innerNameFormat("ismap");
		return source.hasAttribute(attr);
	}
	public void setIsMap(boolean isMap)
	{
		String attr = jsaf.innerNameFormat("ismap");
		setBooleanAttribute(attr, isMap);
		jsaf.recomputeStyles();
	}
	
	public String getLongDesc()
	{
		String attr = jsaf.innerNameFormat("longdesc");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setLongDesc(String longDesc)
	{
		String attr = jsaf.innerNameFormat("longdesc");
		source.setAttribute(attr, longDesc);
	}
	
	public String getSrc()
	{
		String attr = jsaf.innerNameFormat("src");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setSrc(String src)
	{
		String attr = jsaf.innerNameFormat("src");
		source.setAttribute(attr, src);
	}
	
	public String getUseMap()
	{
		String attr = jsaf.innerNameFormat("usemap");
		return source.getAttribute(attr);
	}
	public void setUseMap(String useMap)
	{
		String attr = jsaf.innerNameFormat("usemap");
		source.setAttribute(attr, useMap);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
	}
	
	public int getWidth()
	{
		String attr = jsaf.innerNameFormat("width");
		return getUnsignedAttribute(attr, 0);
	}
	public void setWidth(int width)
	{
		String attr = jsaf.innerNameFormat("width");
		setIntegerAttribute(attr, width);
		jsaf.recomputeStyles();
	}
	
}
