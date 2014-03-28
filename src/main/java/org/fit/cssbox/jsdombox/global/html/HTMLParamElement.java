/*
 * HTMLParamElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLParamElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLParamElement extends HTMLElement
{
	public HTMLParamElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
	
	public String getValue()
	{
		String attr = jsaf.innerNameFormat("value");
		return source.getAttribute(attr);
	}
	public void setValue(String value)
	{
		String attr = jsaf.innerNameFormat("value");
		source.setAttribute(attr, value);
	}
	
	public String getValueType()
	{
		String attr = jsaf.innerNameFormat("valuetype");
		return source.getAttribute(attr);
	}
	public void setValueType(String valueType)
	{
		String attr = jsaf.innerNameFormat("valuetype");
		source.setAttribute(attr, valueType);
	}
	
}
