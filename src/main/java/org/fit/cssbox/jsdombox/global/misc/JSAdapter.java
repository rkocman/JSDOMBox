/*
 * JSAdapter.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

/**
 * Base JS Adapter Class
 * 
 * @author Radim Kocman
 */
public class JSAdapter 
{	
	protected Object source;
	protected JSAdapterFactory jsaf;
	
	public JSAdapter(Object source, JSAdapterFactory jsaf)
	{
		this.source = source;
		this.jsaf = jsaf;
	}
	
}
