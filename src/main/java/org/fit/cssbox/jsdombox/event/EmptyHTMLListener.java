/*
 * EmptyHTMLListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

/**
 * Empty implementation of the HTMLListener 
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
	
	public int select_getSelectedIndex(Node node) {return -1;}
	public void select_setSelectedIndex(Node node, int selectedIndex) {}
	public void select_blur(Node node) {}
	public void select_focus(Node node) {}
	
	public boolean option_getSelected(Node node) {return false;}
	public void option_setSelected(Node node, boolean selected) {}
	
}