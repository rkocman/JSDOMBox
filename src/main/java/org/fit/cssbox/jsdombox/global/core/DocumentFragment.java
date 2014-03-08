/*
 * DocumentFragment.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;

/**
 * DOM Interface DocumentFragment Adapter
 * 
 * @author Radim Kocman
 */
public class DocumentFragment extends Node
{
	protected org.w3c.dom.DocumentFragment source;
	
	public DocumentFragment(org.w3c.dom.DocumentFragment source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	// empty
	
	
	// DOM Level 2 Implementation
	// empty

}
