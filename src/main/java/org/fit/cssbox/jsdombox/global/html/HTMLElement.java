/*
 * HTMLElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Element;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;

/**
 * DOM Interface HTMLElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLElement extends Element
{
	public HTMLElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	/**
	 * Gets the parsed integer value from the attribute 
	 * @param attr Attribute name
	 * @param defaultInt Default value for the attribute
	 * @return Parsed integer value
	 */
	protected int getIntegerAttribute(String attr, int defaultInt)
	{
		int result = defaultInt;
		
		try {
			String value = source.getAttribute(attr);
			result = Integer.parseInt(value.trim());
		} catch (NumberFormatException e) {}
		
		return result;
	}
	
	/**
	 * Gets the parsed unsigned integer value form the attribute
	 * @param attr Attribute name
	 * @param defaultInt Default value for the attribute
	 * @return Parsed unsigned integer value
	 */
	protected int getUnsignedAttribute(String attr, int defaultInt)
	{
		int result = getIntegerAttribute(attr, defaultInt);
		return (result < 0)? defaultInt : result; 
	}
	
	/**
	 * Sets the integer attribute
	 * @param attr Attribute name
	 * @param value Attribute value
	 */
	protected void setIntegerAttribute(String attr, int value)
	{
		source.setAttribute(attr, String.valueOf(value));
	}
	
	/**
	 * Sets the boolean attribute
	 * @param attr Attribute name
	 * @param value Attribute value
	 */
	protected void setBooleanAttribute(String attr, boolean value)
	{
		if (value)
			source.setAttribute(attr, "");
		else
			source.removeAttribute(attr);
	}
	
	/**
	 * Gets the parent Form of the Node
	 * @return JSAdapter or null
	 */
	protected JSAdapter getParentForm()
	{
		String attr = jsaf.innerNameFormat("form");
		Object result = HTMLTraversal.getParentTag(source, new String[] {attr}); 
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getId()
	{
		String attr = jsaf.innerNameFormat("id");
		return source.getAttribute(attr);
	}
	public void setId(String id)
	{
		String attr = jsaf.innerNameFormat("id");
		source.setAttribute(attr, id);
		jsaf.recomputeStyles();
	}
	
	public String getTitle()
	{
		String attr = jsaf.innerNameFormat("title");
		return source.getAttribute(attr);
	}
	public void setTitle(String title)
	{
		String attr = jsaf.innerNameFormat("title");
		source.setAttribute(attr, title);
	}
	
	public String getLang()
	{
		String attr = jsaf.innerNameFormat("lang");
		return source.getAttribute(attr);
	}
	public void setLang(String lang)
	{
		String attr = jsaf.innerNameFormat("lang");
		source.setAttribute(attr, lang);
	}
	
	public String getDir()
	{
		String attr = jsaf.innerNameFormat("dir");
		switch (source.getAttribute(attr).toLowerCase()) {
			default: return "";
			case "ltr": return "ltr";
			case "rtl": return "rtl";
		}
	}
	public void setDir(String dir)
	{
		String attr = jsaf.innerNameFormat("dir");
		source.setAttribute(attr, dir);
		jsaf.recomputeStyles();
	}
	
	public String getClassName()
	{
		String attr = jsaf.innerNameFormat("class");
		return source.getAttribute(attr);
	}
	public void setClassName(String className)
	{
		String attr = jsaf.innerNameFormat("class");
		source.setAttribute(attr, className);
		jsaf.recomputeStyles();
	}
	
}
