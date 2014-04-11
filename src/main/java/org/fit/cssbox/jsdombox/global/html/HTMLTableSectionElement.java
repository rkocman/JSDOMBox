/*
 * HTMLTableSectionElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Node;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.w3c.dom.DOMException;

/**
 * DOM Interface HTMLTableSectionElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTableSectionElement extends HTMLElement
{
	protected HTMLCollection rows;
	
	public HTMLTableSectionElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		// Rows HTMLCollection
		String table = jsaf.innerNameFormat("table");
		String tr = jsaf.innerNameFormat("tr");
		String[] tags = new String[] {tr};
		String[] skippedTags = new String[] {table};
		rows = new HTMLCollection(source, jsaf, tags, skippedTags);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getAlign()
	{
		String attr = jsaf.innerNameFormat("align");
		return source.getAttribute(attr);
	}
	public void setAlign(String align)
	{
		String attr = jsaf.innerNameFormat("align");
		source.setAttribute(attr, align);
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
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
		jsaf.recomputeStyles();
	}
	
	public JSAdapter getRows()
	{
		return rows;
	}
	
	public JSAdapter insertRow(int index)
	{
		int length = rows.getLength();
		if (index < -1 || index > length)
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "insertRow invalid index");
		
		String tr = jsaf.innerNameFormat("tr");
		Object result = source.getOwnerDocument().createElement(tr);
		Node newTr = (Node) jsaf.create(result, JSAdapterType.NODE);
		Node current = (Node) rows.item(index);
		return insertBefore(newTr, current);
	}
	
	public void deleteRow(int index)
	{
		int length = rows.getLength();
		if (index < -1 || index >= length)
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "deleteRow invalid index");
		
		Node row;
		if (index == -1)
			row = (Node) rows.item(length-1);
		else
			row = (Node) rows.item(index);
		removeChild(row);
	}
	
}
