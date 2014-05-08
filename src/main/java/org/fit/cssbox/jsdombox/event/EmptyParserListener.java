/*
 * EmptyParserListener.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.event;

import org.w3c.dom.Node;

public class EmptyParserListener implements ParserListener
{
	public void document_open(Node node) {}
	public void document_close(Node node) {}
	public void document_write(Node node, String text) {}
	public void document_writeln(Node node, String text) {}

}
