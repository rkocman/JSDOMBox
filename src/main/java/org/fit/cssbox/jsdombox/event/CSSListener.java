/*
 * CSSListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

/**
 * Common interface for receiving CSS events from the JSDOMBox
 * 
 * @author Radim Kocman
 */
public interface CSSListener
{
	/**
	 * Recompute CSS in the CSSBox
	 * @param source Source object for this event
	 */
	public void recomputeStyles(Object source);
	
}
