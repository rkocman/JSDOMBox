/*
 * Text.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;

/**
 * DOM Interface Text Adapter
 * 
 * @author Radim Kocman
 */
public class Text extends CharacterData
{
	protected org.w3c.dom.Text source;
	
	public Text(org.w3c.dom.Text source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	
	public JSAdapter splitText(int offset)
	{
		Object result = source.splitText(offset);
		jsaf.cssEvent.recomputeStyles(source);
		return jsaf.create(result, JSAdapterType.TEXT);
	}
	
	
	// DOM Level 2 Implementation
	// empty
	
}
