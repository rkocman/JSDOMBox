/*
 * HTMLTableElement.java
 * Copyright (c) Radim Kocman
 */
package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Node;
import org.fit.cssbox.jsdombox.global.misc.HTMLCollectionType;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.w3c.dom.DOMException;

/**
 * DOM Interface HTMLTableElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLTableElement extends HTMLElement
{
	protected HTMLCollection captions;
	protected HTMLCollection tHeads;
	protected HTMLCollection tFoots;
	protected HTMLCollection rows;
	protected HTMLCollection tBodies;
	
	public HTMLTableElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		String table = jsaf.innerNameFormat("table");
		String thead = jsaf.innerNameFormat("thead");
		String tbody = jsaf.innerNameFormat("tbody");
		String tfoot = jsaf.innerNameFormat("tfoot");
		String tr = jsaf.innerNameFormat("tr");
		String caption = jsaf.innerNameFormat("caption");
		String[] tags;
		String[] skippedTags;
		
		// Captions HTMLCollection
		tags = new String[] {caption};
		skippedTags = new String[] {table};
		captions = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// THeads HTMLCollection
		tags = new String[] {thead};
		skippedTags = new String[] {table};
		tHeads = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// TFoots HTMlCollection
		tags = new String[] {tfoot};
		skippedTags = new String[] {table};
		tFoots = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// Rows HTMLCollection
		tags = new String[] {tr};
		skippedTags = new String[] {table};
		rows = new HTMLCollection(source, jsaf, tags, skippedTags, 
				HTMLCollectionType.TABLE);
		
		// TBodies HTMLCollection
		tags = new String[] {tbody};
		skippedTags = new String[] {table};
		tBodies = new HTMLCollection(source, jsaf, tags, skippedTags);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getCaption()
	{
		return captions.item(0);
	}
	public void setCaption(JSAdapter caption)
	{
		if (!(caption instanceof Node) || 
				((Node) caption).getNodeName().compareToIgnoreCase("caption") != 0) 
			throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, "Invalid <caption> element");
		
		deleteCaption();
		
		appendChild((Node) caption);
	}
	
	public JSAdapter gettHead()
	{
		return tHeads.item(0);
	}
	public void settHead(JSAdapter tHead)
	{
		if (!(tHead instanceof Node) || 
				((Node) tHead).getNodeName().compareToIgnoreCase("thead") != 0) 
			throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, "Invalid <thead> element");
		
		deleteTHead();
		
		insertBefore((Node) tHead, (Node) getFirstChild());
	}
	
	public JSAdapter gettFoot()
	{
		return tFoots.item(0);
	}
	public void settFoot(JSAdapter tFoot)
	{
		if (!(tFoot instanceof Node) || 
				((Node) tFoot).getNodeName().compareToIgnoreCase("tfoot") != 0) 
			throw new DOMException(DOMException.HIERARCHY_REQUEST_ERR, "Invalid <tfoot> element");
		
		deleteTFoot();
		
		appendChild((Node) tFoot);
	}
	
	public JSAdapter getRows()
	{
		return rows;
	}
	
	public JSAdapter gettBodies()
	{
		return tBodies;
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
	
	public String getBorder()
	{
		String attr = jsaf.innerNameFormat("border");
		return source.getAttribute(attr);
	}
	public void setBorder(String border)
	{
		String attr = jsaf.innerNameFormat("border");
		source.setAttribute(attr, border);
		jsaf.recomputeStyles();
	}
	
	public String getCellPadding()
	{
		String attr = jsaf.innerNameFormat("cellpadding");
		return source.getAttribute(attr);
	}
	public void setCellPadding(String cellPadding)
	{
		String attr = jsaf.innerNameFormat("cellpadding");
		source.setAttribute(attr, cellPadding);
		jsaf.recomputeStyles();
	}
	
	public String getCellSpacing()
	{
		String attr = jsaf.innerNameFormat("cellspacing");
		return source.getAttribute(attr);
	}
	public void setCellSpacing(String cellPadding)
	{
		String attr = jsaf.innerNameFormat("cellspacing");
		source.setAttribute(attr, cellPadding);
		jsaf.recomputeStyles();
	}
	
	public String getFrame()
	{
		String attr = jsaf.innerNameFormat("frame");
		return source.getAttribute(attr);
	}
	public void setFrame(String frame)
	{
		String attr = jsaf.innerNameFormat("frame");
		source.setAttribute(attr, frame);
		jsaf.recomputeStyles();
	}
	
	public String getRules()
	{
		String attr = jsaf.innerNameFormat("rules");
		return source.getAttribute(attr);
	}
	public void setRules(String rules)
	{
		String attr = jsaf.innerNameFormat("rules");
		source.setAttribute(attr, rules);
		jsaf.recomputeStyles();
	}
	
	public String getSummary()
	{
		String attr = jsaf.innerNameFormat("summary");
		return source.getAttribute(attr);
	}
	public void setSummary(String summary)
	{
		String attr = jsaf.innerNameFormat("summary");
		source.setAttribute(attr, summary);
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
		jsaf.recomputeStyles();
	}
	
	public JSAdapter createTHead()
	{
		if (gettHead() != null)
			return gettHead();
		
		String thead = jsaf.innerNameFormat("thead");
		Object result = source.getOwnerDocument().createElement(thead);
		Node newtHead = (Node) jsaf.create(result, JSAdapterType.NODE);
		insertBefore(newtHead, (Node) getFirstChild());
		return newtHead;
	}
	
	public void deleteTHead()
	{
		Node current = (Node) gettHead();
		if (current != null) removeChild(current);
	}
	
	public JSAdapter createTFoot()
	{
		if (gettFoot() != null)
			return gettFoot();
		
		String tfoot = jsaf.innerNameFormat("tfoot");
		Object result = source.getOwnerDocument().createElement(tfoot);
		Node newtFoot = (Node) jsaf.create(result, JSAdapterType.NODE);
		appendChild(newtFoot);
		return newtFoot;
	}
	
	public void deleteTFoot()
	{
		Node current = (Node) gettFoot();
		if (current != null) removeChild(current);
	}
	
	public JSAdapter createCaption()
	{
		if (getCaption() != null)
			return getCaption();
		
		String caption = jsaf.innerNameFormat("caption");
		Object result = source.getOwnerDocument().createElement(caption);
		Node newCaption = (Node) jsaf.create(result, JSAdapterType.NODE);
		appendChild(newCaption);
		return newCaption;
	}
	
	public void deleteCaption()
	{
		Node current = (Node) getCaption();
		if (current != null) removeChild(current);
	}
	
	public JSAdapter insertRow(int index)
	{
		int length = rows.getLength();
		if (index < -1 || index > length)
			throw new DOMException(DOMException.INDEX_SIZE_ERR, "insertRow invalid index");
		
		String tr = jsaf.innerNameFormat("tr");
		Object result = source.getOwnerDocument().createElement(tr);
		Node newTr = (Node) jsaf.create(result, JSAdapterType.NODE);
		
		// Handle an empty table
		if (length == 0) {
			
			Node tBody;
			if (tBodies.getLength() != 0)
				tBody = (Node) tBodies.item(tBodies.getLength()-1);
			else {
				String tbody = jsaf.innerNameFormat("tbody");
				Object result2 = source.getOwnerDocument().createElement(tbody);
				tBody = (Node) jsaf.create(result2, JSAdapterType.NODE);
				appendChild(tBody);
			}
			
			tBody.appendChild(newTr);
			return newTr;
		}
		
		// Handle insert at the end
		if (index == -1 || index == length) {
			Node current = (Node) rows.item(length-1);
			Node parent = (Node) current.getParentNode();
			parent.appendChild(newTr);
			return newTr;
		}
		
		// Handle insert before the index
		Node current = (Node) rows.item(index);
		Node parent = (Node) current.getParentNode();
		parent.insertBefore(newTr, current);
		return newTr;
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
		Node parent = (Node) row.getParentNode();
		parent.removeChild(row);
	}
	
}
