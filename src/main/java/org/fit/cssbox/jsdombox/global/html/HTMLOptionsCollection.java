/*
 * HTMLOptionsCollection.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;
import org.w3c.dom.DOMException;

/**
 * DOM Interface HTMLOptionsCollection
 * 
 * @author Radim Kocman
 */
public class HTMLOptionsCollection extends JSAdapter
{
	protected org.w3c.dom.Node source;
	protected String[] tags; // All relevant HTML tags for this collection
	protected String[] skippedTags; // All HTML tags that should be skipped
	
	public HTMLOptionsCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		this.source = source;
		
		String option = jsaf.innerNameFormat("option");
		this.tags = new String[] {option};
		this.skippedTags = new String[] {};
	}
	
	// DOM Level 2 HTML Implementation
	
	public int getLength()
	{
		return HTMLTraversal.getCountOfTagsInNode(source, tags, skippedTags, null, null, jsaf);
	}
	public void setLength(int length)
	{
		// setLength is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "setLength is not supported");
	}
	
	public JSAdapter item(int index)
	{
		Object result = HTMLTraversal.getNthTagInNode(source, tags, skippedTags, index, null, null, jsaf); 
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
	public JSAdapter namedItem(String name)
	{
		Object result = HTMLTraversal.getNamedTagInNode(source, tags, skippedTags, name, null, null, jsaf);
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
}
