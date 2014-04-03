/*
 * HTMLScriptElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLScriptElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLScriptElement extends HTMLElement
{
	public HTMLScriptElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getText()
	{
		return source.getTextContent();
	}
	public void setText(String text)
	{
		source.setTextContent(text);
	}
	
	public String getHtmlFor()
	{
		String attr = jsaf.innerNameFormat("for");
		return source.getAttribute(attr);
	}
	public void setHtmlFor(String htmlFor)
	{
		String attr = jsaf.innerNameFormat("for");
		source.setAttribute(attr, htmlFor);
	}
	
	public String getEvent()
	{
		String attr = jsaf.innerNameFormat("event");
		return source.getAttribute(attr);
	}
	public void setEvent(String event)
	{
		String attr = jsaf.innerNameFormat("event");
		source.setAttribute(attr, event);
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
	
	public boolean getDefer()
	{
		String attr = jsaf.innerNameFormat("defer");
		return source.hasAttribute(attr);
	}
	public void setDefer(boolean defer)
	{
		String attr = jsaf.innerNameFormat("defer");
		setBooleanAttribute(attr, defer);
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
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return source.getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
	}
	
}
