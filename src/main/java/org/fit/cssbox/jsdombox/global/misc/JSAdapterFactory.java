/*
 * JSAdapterFactory.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

import org.fit.cssbox.jsdombox.event.HTMLListener;

/**
 * Basic abstract class for the JS Adapter Factories 
 * 
 * @author Radim Kocman
 */
public abstract class JSAdapterFactory 
{
	/**
	 * Interface for the HTML events
	 */
	public HTMLListener htmlEvent;
	
	/**
	 * Creates appropriate JS adapter for the Java DOM object
	 * @param source Java DOM object
	 * @param type JSAdapter type
	 * @return Initialized JS adapter
	 */
	public abstract JSAdapter create(Object source, JSAdapterType type);
	
	/**
	 * Recomputes CSS in the CSSBox
	 */
	public abstract void recomputeStyles();
	
	/**
	 * Converts names into the inner DOM format
	 */
	public abstract String innerNameFormat(String name);
	
}
