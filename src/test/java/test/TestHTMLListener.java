/*
 * TestHTMLListener.java
 * Copyright (c) Radim Kocman
 */

package test;

import org.fit.cssbox.jsdombox.event.EmptyHTMLListener;
import org.w3c.dom.Node;

/**
 * Extended empty implementation for the testing purposes  
 * 
 * @author Radim Kocman
 */
public class TestHTMLListener extends EmptyHTMLListener
{
	// Dummy cache for the selected index
	protected int select_selectedIndex = -1;
	@Override
	public int select_getSelectedIndex(Node node)
	{
		return select_selectedIndex;
	}
	@Override
	public void select_setSelectedIndex(Node node, int selectedIndex) 
	{
		select_selectedIndex = selectedIndex;
	}
	
}
