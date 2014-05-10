/*
 * HTMLTableCellElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;

/**
 * DOM Interface HTMLTableCellElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTableCellElement extends HTMLElement
{
	public HTMLTableCellElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public int getCellIndex()
	{
		String table = jsaf.innerNameFormat("table");
		String tr = jsaf.innerNameFormat("tr");
		String th = jsaf.innerNameFormat("th");
		String td = jsaf.innerNameFormat("td");
		String[] tags = new String[] {th, td};
		String[] parentTags = new String[] {tr};
		String[] skippedTags = new String[] {table};
		return HTMLTraversal.getIndexInParentTag(source, tags, parentTags, skippedTags);
	}
	
	public String getAbbr()
	{
		String attr = jsaf.innerNameFormat("abbr");
		return source.getAttribute(attr);
	}
	public void setAbbr(String abbr)
	{
		String attr = jsaf.innerNameFormat("abbr");
		source.setAttribute(attr, abbr);
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
	
	public String getAxis()
	{
		String attr = jsaf.innerNameFormat("axis");
		return source.getAttribute(attr);
	}
	public void setAxis(String axis)
	{
		String attr = jsaf.innerNameFormat("axis");
		source.setAttribute(attr, axis);
	}
	
	public String getBgColor()
	{
		String attr = jsaf.innerNameFormat("bgcolor");
		return source.getAttribute(attr);
	}
	public void setBgColor(String bgColor)
	{
		String attr = jsaf.innerNameFormat("bgcolor");
		source.setAttribute(attr, bgColor);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getCh()
	{
		String attr = jsaf.innerNameFormat("char");
		return source.getAttribute(attr);
	}
	public void setCh(String ch)
	{
		String attr = jsaf.innerNameFormat("char");
		source.setAttribute(attr, ch);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getChOff()
	{
		String attr = jsaf.innerNameFormat("charoff");
		return source.getAttribute(attr);
	}
	public void setChOff(String chOff)
	{
		String attr = jsaf.innerNameFormat("charoff");
		source.setAttribute(attr, chOff);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public int getColSpan()
	{
		String attr = jsaf.innerNameFormat("colspan");
		return getUnsignedAttribute(attr, 1);
	}
	public void setColSpan(int colSpan)
	{
		String attr = jsaf.innerNameFormat("colspan");
		setIntegerAttribute(attr, colSpan);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getHeaders()
	{
		String attr = jsaf.innerNameFormat("headers");
		return source.getAttribute(attr);
	}
	public void setHeaders(String headers)
	{
		String attr = jsaf.innerNameFormat("headers");
		source.setAttribute(attr, headers);
	}
	
	public String getHeight()
	{
		String attr = jsaf.innerNameFormat("height");
		return source.getAttribute(attr);
	}
	public void setHeight(String height)
	{
		String attr = jsaf.innerNameFormat("height");
		source.setAttribute(attr, height);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public boolean getNoWrap()
	{
		String attr = jsaf.innerNameFormat("nowrap");
		return source.hasAttribute(attr);
	}
	public void setNoWrap(boolean noWrap)
	{
		String attr = jsaf.innerNameFormat("nowrap");
		setBooleanAttribute(attr, noWrap);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public int getRowSpan()
	{
		String attr = jsaf.innerNameFormat("rowspan");
		return getUnsignedAttribute(attr, 1);
	}
	public void setRowSpan(int rowSpan)
	{
		String attr = jsaf.innerNameFormat("rowspan");
		setIntegerAttribute(attr, rowSpan);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getScope()
	{
		String attr = jsaf.innerNameFormat("scope");
		return source.getAttribute(attr);
	}
	public void setScope(String scope)
	{
		String attr = jsaf.innerNameFormat("scope");
		source.setAttribute(attr, scope);
	}
	
	public String getvAlign()
	{
		String attr = jsaf.innerNameFormat("valign");
		return source.getAttribute(attr);
	}
	public void setvAlign(String vAlign)
	{
		String attr = jsaf.innerNameFormat("valign");
		source.setAttribute(attr, vAlign);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public String getWidth()
	{
		String attr = jsaf.innerNameFormat("width");
		return source.getAttribute(attr);
	}
	public void setWidth(String width)
	{
		String attr = jsaf.innerNameFormat("width");
		source.setAttribute(attr, width);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
}
