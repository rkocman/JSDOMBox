/*
 * HTMLButtonElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLButtonElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLButtonElement extends HTMLElement
{
	public HTMLButtonElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
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
	
	public boolean getDisabled()
	{
		String attr = jsaf.innerNameFormat("disabled");
		return source.hasAttribute(attr);
	}
	public void setDisabled(boolean disabled)
	{
		String attr = jsaf.innerNameFormat("disabled");
		setBooleanAttribute(attr, disabled);
		jsaf.recomputeStyles();
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
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		switch(source.getAttribute(attr).toLowerCase()) {
			default: return "submit";
			case "reset": return "reset";
			case "button": return "button";
		}
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
	
}
