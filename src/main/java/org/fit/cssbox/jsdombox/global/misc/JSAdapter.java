/*
 * JSAdapter.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

/**
 * Base JS Adapter Class
 * @author Radim Kocman
 */
public class JSAdapter 
{	
	protected Object source;
	protected IJSAdapterFactory iaf;
	
	public JSAdapter(Object source, IJSAdapterFactory iaf)
	{
		this.source = source;
		this.iaf = iaf;
	}
	
}
