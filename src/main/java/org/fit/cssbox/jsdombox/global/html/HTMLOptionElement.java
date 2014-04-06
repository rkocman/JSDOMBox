/*
 * HTMLOptionElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;

/**
 * DOM Interface HTMLOptionElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLOptionElement extends HTMLElement
{
	public HTMLOptionElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public boolean getDefaultSelected()
	{
		String attr = jsaf.innerNameFormat("selected");
		return source.hasAttribute(attr);
	}
	public void setDefaultSelected(boolean selected)
	{
		String attr = jsaf.innerNameFormat("selected");
		setBooleanAttribute(attr, selected);
	}
	
	public String getText()
	{
		return source.getTextContent();
	}
	
	public int getIndex()
	{
		String select = jsaf.innerNameFormat("select");
		String option = jsaf.innerNameFormat("option");
		String[] tags = new String[] {option};
		String[] parentTags = new String[] {select};
		return HTMLTraversal.getIndexInParentTag(source, tags, parentTags);
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
	
	public String getLabel()
	{
		String attr = jsaf.innerNameFormat("label");
		return source.getAttribute(attr);
	}
	public void setLabel(String label)
	{
		String attr = jsaf.innerNameFormat("label");
		source.setAttribute(attr, label);
	}
	
	public boolean getSelected()
	{
		return jsaf.htmlEvent.option_getSelected(source);
	}
	public void setSelected(boolean selected)
	{
		jsaf.htmlEvent.option_setSelected(source, selected);
	}
	
	public String getValue()
	{
		String attr = jsaf.innerNameFormat("value");
		if (source.hasAttribute(attr))
			return source.getAttribute(attr);
		else
			return source.getTextContent();
	}
	public void setValue(String value)
	{
		String attr = jsaf.innerNameFormat("value");
		source.setAttribute(attr, value);
	}
	
}
