/*
 * Comment.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;

/**
 * DOM Interface Comment Adapter
 * 
 * @author Radim Kocman
 */
public class Comment extends CharacterData
{
	protected org.w3c.dom.Comment source;
	
	public Comment(org.w3c.dom.Comment source, IJSAdapterFactory iaf)
	{
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	// empty
	
	
	// DOM Level 2 Implementation
	// empty
	
}
