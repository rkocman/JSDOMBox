/*
 * HTMLCollection.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.HTMLCollectionType;
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
	protected HTMLCollectionType type;
	protected String[] tags; // All relevant HTML tags for this collection
	protected String[] skippedTags; // All HTML tags that should be skipped
	protected String requiredAttr; // Required attribute in the tags
	protected String hasName; // Required attribute name value in the tags
	
	public HTMLCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf, 
			String[] tags, String[] skippedTags, HTMLCollectionType type,
			String requiredAttr, String hasName)
	{
		super(source, jsaf);
		this.source = source;
		this.tags = tags;
		this.skippedTags = skippedTags;
		this.type = type;
		this.requiredAttr = requiredAttr;
		this.hasName = hasName;
	}
	public HTMLCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf, 
			String[] tags, String[] skippedTags, HTMLCollectionType type)
	{
		this(source, jsaf, tags, skippedTags, type, null, null);
	}
	public HTMLCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf, 
			String[] tags, String[] skippedTags, String requiredAttr, String hasName)
	{
		this(source, jsaf, tags, skippedTags, HTMLCollectionType.NORMAL, requiredAttr, hasName);
	}
	public HTMLCollection(org.w3c.dom.Node source, JSAdapterFactory jsaf, 
			String[] tags, String[] skippedTags)
	{
		this(source, jsaf, tags, skippedTags, HTMLCollectionType.NORMAL, null, null);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public int getLength()
	{
		return HTMLTraversal.getCountOfTagsInNode(source, tags, skippedTags, 
				requiredAttr, hasName, jsaf);
	}
	
	public JSAdapter item(int index)
	{
		Object result;
		if (type == HTMLCollectionType.TABLE)
			result = HTMLTraversal.getNthTagInTable(source, tags, skippedTags, index, 
					requiredAttr, hasName, jsaf);
		else
			result = HTMLTraversal.getNthTagInNode(source, tags, skippedTags, index, 
					requiredAttr, hasName, jsaf); 
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
	public JSAdapter namedItem(String name)
	{
		Object result;
		if (type == HTMLCollectionType.TABLE)
			result = HTMLTraversal.getNamedTagInTable(source, tags, skippedTags, name, 
					requiredAttr, hasName, jsaf);
		else
			result = HTMLTraversal.getNamedTagInNode(source, tags, skippedTags, name, 
					requiredAttr, hasName, jsaf);
		return jsaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
}
