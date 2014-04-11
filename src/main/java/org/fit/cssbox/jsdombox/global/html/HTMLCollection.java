/*
 * HTMLCollection.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.fit.cssbox.jsdombox.global.util.HTMLTraversal;

/**
 * DOM Interface HTMLCollection
 * 
 * @author Radim Kocman
 */
public class HTMLCollection extends JSAdapter
{
	protected org.w3c.dom.Node source;
	protected String[] tags; // All relevant HTML tags for this collection
	protected String[] skippedTags; // All HTML tags that should be skipped
	
	public HTMLCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf, 
			String[] tags, String[] skippedTags)
	{
		super(source, jsaf);
		this.source = source;
		this.tags = tags;
		this.skippedTags = skippedTags;
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public int getLength()
	{
		return HTMLTraversal.getCountOfTagsInNode(source, tags, skippedTags);
	}
	
	public JSAdapter item(int index)
	{
		Object result = HTMLTraversal.getNthTagInNode(source, tags, skippedTags, index); 
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
	public JSAdapter namedItem(String name)
	{
		Object result = HTMLTraversal.getNamedTagInNode(source, tags, skippedTags, name, jsaf);
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
}
