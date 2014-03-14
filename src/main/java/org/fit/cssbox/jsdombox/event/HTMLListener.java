/*
 * HTMLListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

/**
 * Common interface for receiving HTML events from JSDOMBox
 * 
 * @author Radim Kocman
 */
public interface HTMLListener
{
	/**
	 * Getter for HTMLLinkElement attribute disabled
	 * @param node Source Node of HTML Link Element
	 * @return Disabled value: true/false
	 */
	public boolean link_getDisabled(Node node);
	/**
	 * Setter for HTMLLinkElement attribute disabled
	 * @param node Source Node of HTML Link Element
	 * @param disabled New value for attribute disabled
	 */
	public void link_setDisabled(Node node, boolean disabled);
	
	
	/**
	 * Getter for HTMLStyleElement attribute disabled
	 * @param node Source Node of HTML Style Element
	 * @return Disabled value: true/false
	 */
	public boolean style_getDisabled(Node node);
	/**
	 * Setter for HTMLStyleElement attribute disabled
	 * @param node Source Node of HTML Style Element
	 * @param disabled New value for attribute disabled
	 */
	public void style_setDisabled(Node node, boolean disabled);
	
}
