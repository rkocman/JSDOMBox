/*
 * HTMLLinkElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLLinkElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLLinkElement extends HTMLElement
{
	public HTMLLinkElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public boolean getDisabled()
	{
		return jsaf.htmlEvent.link_getDisabled(source);
	}
	public void setDisabled(boolean disabled)
	{
		jsaf.htmlEvent.link_setDisabled(source, disabled);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
	
	public String getMedia()
	{
		String attr = jsaf.innerNameFormat("media");
		return source.getAttribute(attr);
	}
	public void setMedia(String media)
	{
		String attr = jsaf.innerNameFormat("media");
		source.setAttribute(attr, media);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
	}
	
}
