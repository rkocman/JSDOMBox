/*
 * Attr.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;

/**
 * DOM Interface Attr Adapter
 * 
 * @author Radim Kocman
 */
public class Attr extends Node
{
	protected org.w3c.dom.Attr source;
	
	public Attr(org.w3c.dom.Attr source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	
	public String getName()
	{
		return source.getName().toLowerCase();
	}
	
	public boolean getSpecified()
	{
		return source.getSpecified();
	}
	
	public String getValue()
	{
		return source.getValue();
	}
	public void setValue(String value)
	{
		source.setValue(value);
		iaf.recomputeStyles();
	}
	
	
	// DOM Level 2 Implementation
	
	public JSAdapter getOwnerElement()
	{
		Object result = source.getOwnerElement();
		return iaf.create(result, JSAdapterType.ELEMENT);
	}
	
}
