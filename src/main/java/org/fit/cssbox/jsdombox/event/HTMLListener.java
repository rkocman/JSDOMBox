/*
 * HTMLListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

/**
 * Common interface for receiving HTML events from the JSDOMBox
 * 
 * @author Radim Kocman
 */
public interface HTMLListener
{
	/**
	 * Getter for the HTMLLinkElement attribute disabled
	 * @param node Source Node of the HTML Link Element
	 * @return Disabled value: true/false
	 */
	public boolean link_getDisabled(Node node);
	/**
	 * Setter for the HTMLLinkElement attribute disabled
	 * @param node Source Node of the HTML Link Element
	 * @param disabled New value for the attribute disabled
	 */
	public void link_setDisabled(Node node, boolean disabled);
	
	
	/**
	 * Getter for the HTMLStyleElement attribute disabled
	 * @param node Source Node of the HTML Style Element
	 * @return Disabled value: true/false
	 */
	public boolean style_getDisabled(Node node);
	/**
	 * Setter for the HTMLStyleElement attribute disabled
	 * @param node Source Node of the HTML Style Element
	 * @param disabled New value for the attribute disabled
	 */
	public void style_setDisabled(Node node, boolean disabled);
	
	
	/**
	 * Removes keyboard focus from the HTMLAnchorElement
	 * @param node Source Node of the HTML Anchor Element
	 */
	public void anchor_blur(Node node);
	/**
	 * Gives keyboard focus to the HTMLAnchorElement
	 * @param node Source Node of the HTML Anchor Element
	 */
	public void anchor_focus(Node node);
	
	
	/**
	 * Submits the HTMLFormElement
	 * @param node Source Node of the HTML Form Element
	 */
	public void form_submit(Node node);
	/**
	 * Resets the HTMLFormElement
	 * @param node Source Node of the HTML Form Element
	 */
	public void form_reset(Node node);
	
	
	/**
	 * Gets the index of the selected option in the HTMLSelectElement
	 * @param node Source Node of the HTML Select Element
	 * @return Ordinal index (zero-based) or -1
	 */
	public int select_getSelectedIndex(Node node);
	/**
	 * Sets the index of the selected option in the HTMLSelectElement
	 * @param node Source Node of the HTML Select Element
	 * @param selectedIndex Ordinal index (zero-based) or -1
	 */
	public void select_setSelectedIndex(Node node, int selectedIndex);
	/**
	 * Removes keyboard focus from the HTMLSelectElement
	 * @param node Source Node of the HTML Select Element
	 */
	public void select_blur(Node node);
	/**
	 * Gives keyboard focus to the HTMLSelectElement
	 * @param node Source Node of the HTML Select Element
	 */
	public void select_focus(Node node);
	
	
	/**
	 * Gets the selection state of the HTMLOptionElement
	 * @param node Source Node of the HTML Option Element
	 * @return true/false
	 */
	public boolean option_getSelected(Node node);
	/**
	 * Sets the selection state of the HTMLOptionElement
	 * @param node Source Node of the HTML Option Element
	 * @param selected true/false
	 */
	public void option_setSelected(Node node, boolean selected);
	
}
