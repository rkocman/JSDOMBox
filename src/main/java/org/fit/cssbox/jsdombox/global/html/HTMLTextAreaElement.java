/*
 * HTMLTextAreaElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLTextAreaElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTextAreaElement extends HTMLElement
{
	public HTMLTextAreaElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getDefaultValue()
	{
		return source.getTextContent();
	}
	public void setDefaultValue(String defaultValue)
	{
		source.setTextContent(defaultValue);
	}
	
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
	
	public int getCols()
	{
		String attr = jsaf.innerNameFormat("cols");
		return getUnsignedAttribute(attr, 20); // Default size 20 from the FF
	}
	public void setCols(int cols)
	{
		String attr = jsaf.innerNameFormat("cols");
		setIntegerAttribute(attr, cols);
		jsaf.cssEvent.recomputeStyles(source);
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
	
	public boolean getReadOnly()
	{
		String attr = jsaf.innerNameFormat("readonly");
		return source.hasAttribute(attr);
	}
	public void setReadOnly(boolean readOnly)
	{
		String attr = jsaf.innerNameFormat("readonly");
		setBooleanAttribute(attr, readOnly);
	}
	
	public int getRows()
	{
		String attr = jsaf.innerNameFormat("rows");
		return getUnsignedAttribute(attr, 2); // Default size 2 from the FF
	}
	public void setRows(int rows)
	{
		String attr = jsaf.innerNameFormat("rows");
		setIntegerAttribute(attr, rows);
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
	
	public String getType()
	{
		return "textarea";
	}
	
	public String getValue()
	{
		return jsaf.htmlEvent.textarea_getValue(source);
	}
	public void setValue(String value)
	{
		jsaf.htmlEvent.textarea_setValue(source, value);
	}
	
	public void blur()
	{
		jsaf.htmlEvent.textarea_blur(source);
	}
	
	public void focus()
	{
		jsaf.htmlEvent.textarea_focus(source);
	}
	
	public void select()
	{
		jsaf.htmlEvent.textarea_select(source);
	}
	
}
