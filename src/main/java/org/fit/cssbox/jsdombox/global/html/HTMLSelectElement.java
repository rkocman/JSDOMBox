/*
 * HTMLSelectElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLSelectElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLSelectElement extends HTMLElement
{
	protected HTMLOptionsCollection options;
	
	public HTMLSelectElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		// Options HTMLOptionsCollection
		options = new HTMLOptionsCollection(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("multiple");
		if (source.hasAttribute(attr))
			return "select-multiple";
		else
			return "select-one";
	}
	
	public int getSelectedIndex()
	{
		return jsaf.htmlEvent.select_getSelectedIndex(source);
	}
	public void setSelectedIndex(int selectedIndex)
	{
		jsaf.htmlEvent.select_setSelectedIndex(source, selectedIndex);
	}
	
	public String getValue()
	{
		int index = getSelectedIndex();
		HTMLOptionElement option = (HTMLOptionElement) options.item(index);
		if (option == null) return "";
		return option.getValue();
	}
	public void setValue(String value)
	{
		// No effect (according to the Mozilla Firefox)
	}
	
	public int getLength()
	{
		return options.getLength();
	}
	public void setLength(int length)
	{
		options.setLength(length);
	}
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public JSAdapter getOptions()
	{
		return options;
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
	
	public boolean getMultiple()
	{
		String attr = jsaf.innerNameFormat("multiple");
		return source.hasAttribute(attr);
	}
	public void setMultiple(boolean multiple)
	{
		String attr = jsaf.innerNameFormat("multiple");
		setBooleanAttribute(attr, multiple);
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
	
	public int getSize()
	{
		String attr = jsaf.innerNameFormat("size");
		return getIntegerAttribute(attr, 0);
	}
	public void setSize(int size)
	{
		String attr = jsaf.innerNameFormat("size");
		setIntegerAttribute(attr, size);
		jsaf.recomputeStyles();
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
	
	public void add(HTMLElement element, HTMLElement before)
	{
		if (before == null)
			appendChild(element);
		else
			insertBefore(element, before);
	}
	
	public void remove(int index)
	{
		HTMLElement option = (HTMLElement) options.item(index);
		if (option == null) return;
		HTMLElement parent = (HTMLElement) option.getParentNode();
		if (parent == null) return;
		
		parent.removeChild(option);
	}
	
	public void blur()
	{
		jsaf.htmlEvent.select_blur(source);
	}
	
	public void focus()
	{
		jsaf.htmlEvent.select_focus(source);
	}
	
}
