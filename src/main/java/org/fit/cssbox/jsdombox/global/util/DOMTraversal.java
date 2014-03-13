/*
 * DOMTraversal.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.util;

import org.w3c.dom.*;

/**
 * Algorithms for search in DOM tree
 * 
 * @author Radim Kocman
 */
public class DOMTraversal 
{
	/**
	 * Finds DOM Node with unique attribute value
	 * @param dom DOM tree
	 * @param attr Attribute name
	 * @param value Unique value
	 * @return Node or null
	 */
	public static Node getNodeByUniqueAttrValue(Node dom, String attr, String value)
	{
		if (dom.hasAttributes()) {
			Attr attribute = (Attr) dom.getAttributes().getNamedItem(attr);
			if (attribute != null && attribute.getValue().equals(value)) 
				return dom;
		}
		
		NodeList children = dom.getChildNodes();
		for (int i = 0; i < children.getLength(); i++) {
			Node result = getNodeByUniqueAttrValue(children.item(i), attr, value);
			if (result != null) 
				return result;
		}
		
		return null;
	}
	
}
