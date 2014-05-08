/*
 * ParserListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

/**
 * Common interface for receiving parser events from the JSDOMBox
 * 
 * @author Radim Kocman
 */
public interface ParserListener
{
	/**
	 * Open a document stream for writing
	 * @param node Source Node of the HTML Document
	 */
	public void document_open(Node node);
	
	/**
	 * Closes a document stream and forces rendering
	 * @param node Source Node of the HTML Document
	 */
	public void document_close(Node node);
	
	/**
	 * Write a string of text to a document stream
	 * @param node Source Node of the HTML Document
	 * @param text The string to be parsed into the document
	 */
	public void document_write(Node node, String text);
	
	/**
	 * Write a string of text followed by a newline character to a document stream
	 * @param node Source Node of the HTML Document
	 * @param text The string to be parsed into the document
	 */
	public void document_writeln(Node node, String text);
	
}
