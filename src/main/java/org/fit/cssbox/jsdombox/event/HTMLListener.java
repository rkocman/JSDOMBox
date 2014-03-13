/*
 * HTMLListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

/**
 * Common interface for receiving HTML events from JSDOMBox
 * 
 * @author Radim Kocman
 */
public interface HTMLListener
{
	/**
	 * Getter for HTMLLinkElement attribute disabled
	 * @return Disabled value: true/false
	 */
	public boolean link_getDisabled();
	/**
	 * Setter for HTMLLinkElement attribute disabled
	 * @param disabled Value for attribute disabled
	 */
	public void link_setDisabled(boolean disabled);
	
}
