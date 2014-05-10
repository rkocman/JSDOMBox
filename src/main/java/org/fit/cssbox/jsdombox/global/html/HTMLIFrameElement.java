/*
 * HTMLIFrameElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLIFrameElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLIFrameElement extends HTMLElement
{
	public HTMLIFrameElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
	
	public String getFrameBorder()
	{
		String attr = jsaf.innerNameFormat("frameborder");
		return source.getAttribute(attr);
	}
	public void setFrameBorder(String frameBorder)
	{
		String attr = jsaf.innerNameFormat("frameborder");
		source.setAttribute(attr, frameBorder);
		jsaf.cssEvent.recomputeStyles(source);
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
	
	public String getMarginHeight()
	{
		String attr = jsaf.innerNameFormat("marginheight");
		return source.getAttribute(attr);
	}
	public void setMarginHeight(String marginHeight)
	{
		String attr = jsaf.innerNameFormat("marginheight");
		source.setAttribute(attr, marginHeight);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getMarginWidth()
	{
		String attr = jsaf.innerNameFormat("marginwidth");
		return source.getAttribute(attr);
	}
	public void setMarginWidth(String marginWidth)
	{
		String attr = jsaf.innerNameFormat("marginwidth");
		source.setAttribute(attr, marginWidth);
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
	
	public String getScrolling()
	{
		String attr = jsaf.innerNameFormat("scrolling");
		return source.getAttribute(attr);
	}
	public void setScrolling(String scrolling)
	{
		String attr = jsaf.innerNameFormat("scrolling");
		source.setAttribute(attr, scrolling);
		jsaf.cssEvent.recomputeStyles(source);
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
	
	public JSAdapter getContentDocument()
	{
		return null;
	}
	
}
