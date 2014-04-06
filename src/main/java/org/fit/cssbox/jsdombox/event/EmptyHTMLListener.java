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
	
	public boolean input_getChecked(Node node) {return false;}
	public void input_setChecked(Node node, boolean checked) {}
	public String input_getValue(Node node) {return "";}
	public void input_setValue(Node node, String value) {}
	public void input_blur(Node node) {}
	public void input_focus(Node node) {}
	public void input_select(Node node) {}
	public void input_click(Node node) {}
	
}