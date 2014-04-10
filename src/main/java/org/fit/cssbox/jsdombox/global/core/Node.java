/*
 * Node.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterType;

/**
 * DOM Interface Node Adapter
 * 
 * @author Radim Kocman
 */
public class Node extends JSAdapter
{
	protected org.w3c.dom.Node source;
	
	public Node(org.w3c.dom.Node source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		this.source = source;
	}
	
	/**
	 * Gets the source Node from the Node Adapter
	 * @return Source Node
	 */
	protected org.w3c.dom.Node getSource(Node node)
	{
		if (node == null)
			return null;
		return node.source;
	}
	
	
	// DOM Level 1 Implementation
	
	public static final short ELEMENT_NODE       		 	= 1;      
	public static final short ATTRIBUTE_NODE     		 	= 2;
	public static final short TEXT_NODE          		 	= 3;
	public static final short CDATA_SECTION_NODE 		 	= 4;
	public static final short ENTITY_REFERENCE_NODE 		= 5;
	public static final short ENTITY_NODE        			= 6;
	public static final short PROCESSING_INSTRUCTION_NODE 	= 7;
	public static final short COMMENT_NODE       		 	= 8;
	public static final short DOCUMENT_NODE      		 	= 9;
	public static final short DOCUMENT_TYPE_NODE 		 	= 10;
	public static final short DOCUMENT_FRAGMENT_NODE 	 	= 11;
	public static final short NOTATION_NODE      		 	= 12;
	
	public String getNodeName() 
	{
		if (this instanceof Element)
			return source.getNodeName().toUpperCase();
		if (this instanceof Attr)
			return source.getLocalName().toLowerCase();
		
		return source.getNodeName();
	}
	
	public String getNodeValue()
	{
		return source.getNodeValue();
	}
	public void setNodeValue(String nodeValue)
	{
		source.setNodeValue(nodeValue);
	}
	
	public short getNodeType() 
	{
		return source.getNodeType();
	}
	
	public JSAdapter getParentNode()
	{
		Object result = source.getParentNode();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter getChildNodes()
	{
		Object result = source.getChildNodes();
		return jsaf.create(result, JSAdapterType.NODE_LIST);
	}
	
	public JSAdapter getFirstChild()
	{
		Object result = source.getFirstChild();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter getLastChild()
	{
		Object result = source.getLastChild();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter getPreviousSibling()
	{
		Object result = source.getPreviousSibling();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter getNextSibling()
	{
		Object result = source.getNextSibling();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter getAttributes()
	{
		Object result = source.getAttributes();
		return jsaf.create(result, JSAdapterType.NAMED_NODE_MAP);
	}
	
	// modified: public JSAdapter getOwnerDocument()
	
	public JSAdapter insertBefore(Node newChild, Node refChild)
	{
		Object result = source.insertBefore(getSource(newChild), getSource(refChild));
		jsaf.recomputeStyles();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter replaceChild(Node newChild, Node oldChild)
	{
		Object result = source.replaceChild(getSource(newChild), getSource(oldChild));
		jsaf.recomputeStyles();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter removeChild(Node oldChild)
	{
		Object result = source.removeChild(getSource(oldChild));
		jsaf.recomputeStyles();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public JSAdapter appendChild(Node newChild)
	{
		Object result = source.appendChild(getSource(newChild));
		jsaf.recomputeStyles();
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	public boolean hasChildNodes()
	{
		return source.hasChildNodes();
	}
	
	public JSAdapter cloneNode(boolean deep)
	{
		Object result = source.cloneNode(deep);
		return jsaf.create(result, JSAdapterType.NODE);
	}
	
	
	// DOM Level 2 Implementation
	
	public JSAdapter getOwnerDocument()
	{
		Object result = source.getOwnerDocument();
		return jsaf.create(result, JSAdapterType.DOCUMENT);
	}
	
	public void normalize()
	{
		source.normalize();
	}
	
	public boolean isSupported(String feature, String version)
	{
		DOMImplementation domi = new DOMImplementation(null, jsaf);
		return domi.hasFuture(feature, version);
	}
	
	public String getNamespaceURI()
	{
		return source.getNamespaceURI();
	}
	
	public String getPrefix()
	{
		return source.getPrefix();
	}
	public void setPrefix(String prefix)
	{
		source.setPrefix(prefix);
	}
	
	public String getLocalName()
	{
		return source.getLocalName();
	}
	
	public boolean hasAttributes()
	{
		return source.hasAttributes();
	}
	
}
