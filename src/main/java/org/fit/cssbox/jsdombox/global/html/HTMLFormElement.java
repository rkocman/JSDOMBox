/*
 * HTMLFormElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLFormElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLFormElement extends HTMLElement
{
	protected HTMLCollection elements;
	
	public HTMLFormElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		// Elements HTMLCollection
		String button = jsaf.innerNameFormat("button");
		String input = jsaf.innerNameFormat("input");
		String select = jsaf.innerNameFormat("select");
		String textarea = jsaf.innerNameFormat("textarea");
		String object = jsaf.innerNameFormat("object");
		String fieldset = jsaf.innerNameFormat("fieldset");
		String[] tags = new String[] {
			button, input, select, textarea, object, fieldset
		};
		String[] skippedTags = new String[] {};
		elements = new HTMLCollection(source, jsaf, tags, skippedTags);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getElements()
	{
		return elements;
	}
	
	public int getLength()
	{
		return elements.getLength();
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
	
	public String getAcceptCharset()
	{
		String attr = jsaf.innerNameFormat("accept-charset");
		return source.getAttribute(attr);
	}
	public void setAcceptCharset(String acceptCharset)
	{
		String attr = jsaf.innerNameFormat("accept-charset");
		source.setAttribute(attr, acceptCharset);
	}
	
	public String getAction()
	{
		String attr = jsaf.innerNameFormat("action");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path, true, true);
	}
	public void setAction(String action)
	{
		String attr = jsaf.innerNameFormat("action");
		source.setAttribute(attr, action);
	}
	
	public String getEnctype()
	{
		String attr = jsaf.innerNameFormat("enctype");
		switch (source.getAttribute(attr).toLowerCase()) {
			default: return "application/x-www-form-urlencoded";
			case "multipart/form-data": return "multipart/form-data";
			case "text/plain" : return "text/plain";
		}
	}
	public void setEnctype(String enctype)
	{
		String attr = jsaf.innerNameFormat("enctype");
		source.setAttribute(attr, enctype);
	}
	
	public String getMethod()
	{
		String attr = jsaf.innerNameFormat("method");
		switch (source.getAttribute(attr).toLowerCase()) {
			default: return "get";
			case "post": return "post";
		}
	}
	public void setMethod(String method)
	{
		String attr = jsaf.innerNameFormat("method");
		source.setAttribute(attr, method);
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
	
	public void submit()
	{
		jsaf.htmlEvent.form_submit(source);
	}
	
	public void reset()
	{
		jsaf.htmlEvent.form_reset(source);
	}
	
}
