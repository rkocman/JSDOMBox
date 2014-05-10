/*
 * HTMLAnchorElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLÄnchorElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLAnchorElement extends HTMLElement
{
	public HTMLAnchorElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
	
	public String getCharset()
	{
		String attr = jsaf.innerNameFormat("charset");
		return source.getAttribute(attr);
	}
	public void setCharset(String charset)
	{
		String attr = jsaf.innerNameFormat("charset");
		source.setAttribute(attr, charset);
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
		jsaf.cssEvent.recomputeStyles(source);
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
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getHreflang()
	{
		String attr = jsaf.innerNameFormat("hreflang");
		return source.getAttribute(attr);
	}
	public void setHreflang(String hreflang)
	{
		String attr = jsaf.innerNameFormat("hreflang");
		source.setAttribute(attr, hreflang);
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
	
	public String getRel()
	{
		String attr = jsaf.innerNameFormat("rel");
		return source.getAttribute(attr);
	}
	public void setRel(String rel)
	{
		String attr = jsaf.innerNameFormat("rel");
		source.setAttribute(attr, rel);
	}
	
	public String getRev()
	{
		String attr = jsaf.innerNameFormat("rev");
		return source.getAttribute(attr);
	}
	public void setRev(String rev)
	{
		String attr = jsaf.innerNameFormat("rev");
		source.setAttribute(attr, rev);
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
		jsaf.cssEvent.recomputeStyles(source);
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
		return getAttribute(attr);
	}
	public void setTarget(String target)
	{
		String attr = jsaf.innerNameFormat("target");
		source.setAttribute(attr, target);
	}
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
	}
	
	public void blur()
	{
		jsaf.htmlEvent.anchor_blur(source);
	}
	
	public void focus()
	{
		jsaf.htmlEvent.anchor_focus(source);
	}
	
	
	// DOM Level 2 HTML - ECMAScript Language Binding
	
	public String toString()
	{
		return getHref();
	}
	
}
