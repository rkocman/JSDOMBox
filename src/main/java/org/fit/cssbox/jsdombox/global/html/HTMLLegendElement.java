/*
 * HTMLLegendElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLLegendElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLLegendElement extends HTMLElement
{
	public HTMLLegendElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
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
	
}
