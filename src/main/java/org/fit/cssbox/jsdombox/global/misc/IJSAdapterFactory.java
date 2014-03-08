/*
 * IJSAdapterFactory.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

/**
 * Common interface for the JS Adapter Factories 
 * 
 * @author Radim Kocman
 */
public interface IJSAdapterFactory 
{
	/**
	 * Creates appropriate JS adapter for Java DOM object
	 * @param source Java DOM object
	 * @param type JSAdapter type
	 * @return Initialized JS adapter
	 */
	public JSAdapter create(Object source, JSAdapterType type);
	
	/**
	 * Recomputes CSS in CSSBox
	 */
	public void recomputeStyles();
	
	/**
	 * Converts names into inner DOM format
	 */
	public String innerNameFormat(String name);
	
}
