/*
 * Document.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.IJSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;
import org.w3c.dom.DOMException;

/**
 * DOM Interface Document Adapter
 * 
 * @author Radim Kocman
 */
public class Document extends Node 
{
	public org.w3c.dom.Document source;
	
	public Document(org.w3c.dom.Document source, IJSAdapterFactory iaf) {
		super(source, iaf);
		this.source = source;
	}
	
	
	// DOM Level 1 Implementation
	
	public JSAdapter getDoctype()
	{
		// DocumentType is not supported
		return null;
	}
	
	public JSAdapter getImplementation()
	{
		Object result = source.getImplementation();
		return iaf.create(result, JSAdapterType.DOM_IMPLEMENTATION);
	}	
	
	public JSAdapter getDocumentElement()
	{
		Object result = source.getDocumentElement();
		return iaf.create(result, JSAdapterType.ELEMENT);
	}
	
	public JSAdapter createElement(String tagName)
	{
		String convName = iaf.innerNameFormat(tagName);
		Object result = source.createElement(convName);
		return iaf.create(result, JSAdapterType.ELEMENT);
	}
	
	public JSAdapter createDocumentFragment()
	{
		Object result = source.createDocumentFragment();
		return iaf.create(result, JSAdapterType.DOCUMENT_FRAGMENT);
	}
	
	public JSAdapter createTextNode(String data)
	{
		Object result = source.createTextNode(data);
		return iaf.create(result, JSAdapterType.TEXT);
	}
	
	public JSAdapter createComment(String data)
	{
		Object result = source.createComment(data);
		return iaf.create(result, JSAdapterType.COMMENT);
	}
	
	public JSAdapter createCDATASection(String data)
	{
		// CDATASection is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "CDATASection is not supported");
	}
	
	public JSAdapter createProcessingInstruction(String target, String data)
	{
		// ProcessingInstruction is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "ProcessingInstruction is not supported");
	}
	
	public JSAdapter createAttribute(String name)
	{
		String convName = iaf.innerNameFormat(name);
		Object result = source.createAttribute(convName);
		return iaf.create(result, JSAdapterType.ATTR);
	}
	
	public JSAdapter createEntityReference(String name)
	{
		// EntityReference is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "EntityReference is not supported");
	}
	
	public JSAdapter getElementsByTagName(String tagname)
	{
		String convName = iaf.innerNameFormat(tagname);
		Object result = source.getElementsByTagName(convName);
		return iaf.create(result, JSAdapterType.NODE_LIST);
	}
	
	
	// DOM Level 2 Implementation
	
	public JSAdapter importNode(Node importedNode, boolean deep)
	{
		Object result = source.importNode(importedNode.source, deep);
		return iaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter createElementNS(String namespaceURI, String qualifiedName)
	{
		// createElementNS is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "createElementNS is not supported");
	}
	
	public JSAdapter createAttributeNS(String namespaceURI, String qualifiedName)
	{
		// createAttributeNS is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "createAttributeNS is not supported");
	}
	
	public JSAdapter getElementsByTagNameNS(String namespaceURI, String localName)
	{
		String convName = iaf.innerNameFormat(localName);
		Object result = source.getElementsByTagNameNS(namespaceURI, convName);
		return iaf.create(result, JSAdapterType.NODE_LIST);
	}
	
	public JSAdapter getElementById(String elementId)
	{
		Object result = source.getElementById(elementId);
		return iaf.create(result, JSAdapterType.ELEMENT);
	}
	
}
