/*
 * HTMLInputElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLInputElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLInputElement extends HTMLElement
{
	public HTMLInputElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getDefaultValue()
	{
		String attr = jsaf.innerNameFormat("value");
		return source.getAttribute(attr);
	}
	public void setDefaultValue(String defaultValue)
	{
		String attr = jsaf.innerNameFormat("value");
		source.setAttribute(attr, defaultValue);
	}
	
	public boolean getDefaultChecked()
	{
		String attr = jsaf.innerNameFormat("checked");
		return source.hasAttribute(attr);
	}
	public void setDefaultChecked(boolean defaultChecked)
	{
		String attr = jsaf.innerNameFormat("checked");
		setBooleanAttribute(attr, defaultChecked);
	}
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public String getAccept()
	{
		String attr = jsaf.innerNameFormat("accept");
		return source.getAttribute(attr);
	}
	public void setAccept(String accept)
	{
		String attr = jsaf.innerNameFormat("accept");
		source.setAttribute(attr, accept);
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
	
	public String getAlt()
	{
		String attr = jsaf.innerNameFormat("alt");
		return source.getAttribute(attr);
	}
	public void setAlt(String alt)
	{
		String attr = jsaf.innerNameFormat("alt");
		source.setAttribute(attr, alt);
	}
	
	public boolean getChecked()
	{
		return jsaf.htmlEvent.input_getChecked(source);
	}
	public void setChecked(boolean checked)
	{
		jsaf.htmlEvent.input_setChecked(source, checked);
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
	
	public int getMaxLength()
	{
		String attr = jsaf.innerNameFormat("maxlength");
		return getIntegerAttribute(attr, -1);
	}
	public void setMaxLength(int maxLength)
	{
		String attr = jsaf.innerNameFormat("maxlength");
		setIntegerAttribute(attr, maxLength);
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
	
	public int getSize()
	{
		String attr = jsaf.innerNameFormat("size");
		return getUnsignedAttribute(attr, 20); // Default size 20 from the FF
	}
	public void setSize(int size)
	{
		String attr = jsaf.innerNameFormat("size");
		setIntegerAttribute(attr, size);
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
		switch (source.getAttribute(attr).toLowerCase()) {
			default: return "text";
			case "password": return "password";
			case "checkbox": return "checkbox";
			case "radio": return "radio";
			case "submit": return "submit";
			case "reset": return "reset";
			case "file": return "file";
			case "hidden": return "hidden";
			case "image": return "image";
			case "button": return "button";
		}
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getUseMap()
	{
		String attr = jsaf.innerNameFormat("usemap");
		return source.getAttribute(attr);
	}
	public void setUseMap(String useMap)
	{
		String attr = jsaf.innerNameFormat("usemap");
		source.setAttribute(attr, useMap);
	}
	
	public String getValue()
	{
		switch (getType()) {
			default:
				return getDefaultValue();
			case "text": case "file": case "password":
				return jsaf.htmlEvent.input_getValue(source);
		}
	}
	public void setValue(String value)
	{
		switch (getType()) {
			default:
				setDefaultValue(value);
			case "text": case "file": case "password":
				jsaf.htmlEvent.input_setValue(source, value);
		}
	}
	
	public void blur()
	{
		jsaf.htmlEvent.input_blur(source);
	}
	
	public void focus()
	{
		jsaf.htmlEvent.input_focus(source);
	}
	
	public void select()
	{
		jsaf.htmlEvent.input_select(source);
	}
	
	public void click()
	{
		jsaf.htmlEvent.input_click(source);
	}
	
}
