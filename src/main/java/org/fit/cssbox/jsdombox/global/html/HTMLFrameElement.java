/*
 * HTMLFrameElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLFrameElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLFrameElement extends HTMLElement
{
	public HTMLFrameElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getFrameBorder()
	{
		String attr = jsaf.innerNameFormat("frameborder");
		return source.getAttribute(attr);
	}
	public void setFrameBorder(String frameBorder)
	{
		String attr = jsaf.innerNameFormat("frameborder");
		source.setAttribute(attr, frameBorder);
	}
	
	public String getLongDesc()
	{
		String attr = jsaf.innerNameFormat("longdesc");
		return source.getAttribute(attr);
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
	
	public boolean getNoResize()
	{
		String attr = jsaf.innerNameFormat("noresize");
		return source.hasAttribute(attr);
	}
	public void setNoResize(boolean noResize)
	{
		String attr = jsaf.innerNameFormat("noresize");
		setBooleanAttribute(attr, noResize);
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
	
	public JSAdapter getContentDocument()
	{
		return null;
	}
	
}
