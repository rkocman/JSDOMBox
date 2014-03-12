/*
 * NodeList.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;

/**
 * DOM Interface NodeList Adapter
 * 
 * @author Radim Kocman
 */
public class NodeList extends JSAdapter
{
	protected org.w3c.dom.NodeList source;
	
	public NodeList(org.w3c.dom.NodeList source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	
	public JSAdapter item(int index)
	{
		Object result = source.item(index);
		return iaf.create(result, JSAdapterType.NODE);
	}
	// TODO square bracket access
	
	public int getLength()
	{
		return source.getLength();
	}
	
	
	// DOM Level 2 Implementation
	// empty
	
}
