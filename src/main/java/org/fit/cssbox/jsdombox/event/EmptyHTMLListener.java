/*
 * EmptyHTMLListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

/**
 * Empty placeholder implementation of the HTMLListener 
 * 
 * @author Radim Kocman
 */
public class EmptyHTMLListener implements HTMLListener
{
	public boolean link_getDisabled(Node node) {return false;}
	public void link_setDisabled(Node node, boolean disabled) {}
	
	public boolean style_getDisabled(Node node) {return false;}
	public void style_setDisabled(Node node, boolean disabled) {}
	
	public void anchor_blur(Node node) {}
	public void anchor_focus(Node node) {}
	
	public void form_submit(Node node) {}
	public void form_reset(Node node) {}
	
}