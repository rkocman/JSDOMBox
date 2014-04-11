/*
 * HTMLTableRowElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Node;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;
import org.w3c.dom.DOMException;

/**
 * DOM Interface HTMLTableRowElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTableRowElement extends HTMLElement
{
	protected HTMLCollection cells;
	
	public HTMLTableRowElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		// Cells HTMLCollection
		String table = jsaf.innerNameFormat("table");
		String th = jsaf.innerNameFormat("th");
		String td = jsaf.innerNameFormat("td");
		String[] tags = new String[] {th, td};
		String[] skippedTags = new String[] {table};
		cells = new HTMLCollection(source, jsaf, tags, skippedTags);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public int getRowIndex()
	{
		return HTMLTraversal.getIndexOfTableRow(source, jsaf);
	}
	
	public int getSectionRowIndex()
	{
		String table = jsaf.innerNameFormat("table");
		String thead = jsaf.innerNameFormat("thead");
		String tbody = jsaf.innerNameFormat("tbody");
		String tfoot = jsaf.innerNameFormat("tfoot");
		String tr = jsaf.innerNameFormat("tr");
		String[] tags = new String[] {tr};
		String[] parentTags = new String[] {table, thead, tbody, tfoot};
		String[] skippedTags = new String[] {table};
		return HTMLTraversal.getIndexInParentTag(source, tags, parentTags, skippedTags);
	}
	
	public JSAdapter getCells()
	{
		return cells;
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
		jsaf.recomputeStyles();
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
	
	public JSAdapter insertCell(int index)
	{
		int length = cells.getLength();
		if (index < -1 || index > length)
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "insertCell invalid index");
		
		String td = jsaf.innerNameFormat("td");
		Object result = source.getOwnerDocument().createElement(td);
		Node newTd = (Node) jsaf.create(result, JSAdapterType.NODE);		
		Node current = (Node) cells.item(index);
		return insertBefore(newTd, current);
	}
	
	public void deleteCell(int index)
	{
		int length = cells.getLength();
		if (index < -1 || index >= length)
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "deleteCell invalid index");
		
		Node cell;
		if (index == -1)
			cell = (Node) cells.item(length-1);
		else
			cell = (Node) cells.item(index);
		removeChild(cell);
	}
	
}
