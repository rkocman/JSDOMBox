/*
 * DOMImplementation.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.w3c.dom.DOMException;

/**
 * DOM Interface DOMImplementation Adapter
 * 
 * @author Radim Kocman
 */
public class DOMImplementation extends JSAdapter
{
	protected org.w3c.dom.DOMImplementation source;
	
	public DOMImplementation(org.w3c.dom.DOMImplementation source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		this.source = source;
	}

	
	// DOM Level 1 Implementation
	// modified: public boolean hasFuture(String feature, String version);
	
	
	// DOM Level 2 Implementation
	
	public boolean hasFuture(String feature, String version)
	{
		// XML 1.0 (not supported)
		// HTML 1.0 (not supported)
		
		// Core 2.0
		if (feature.compareToIgnoreCase("Core") == 0) {
			if (version == null || version.isEmpty() || 
		        version.compareToIgnoreCase("2.0") == 0)
				return true;
		}
		
		// HTML 2.0
		if (feature.compareToIgnoreCase("HTML") == 0) {
			if (version == null || version.isEmpty() || 
		        version.compareToIgnoreCase("2.0") == 0)
				return true;
		}
		
		// XML 2.0 (not supported)
		// XHTML 2.0 (not supported)
		
		return false;
	}
	
	public JSAdapter createDocumentType(String qualifiedName, String publicId, String systemId)
	{
		// createDocumentType is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "createDocumentType is not supported");
	}
	
	public JSAdapter createDocument(String namespaceURI, String qualifiedName, JSAdapter doctype)
	{
		// createDocument is not supported
		throw new DOMException(DOMException.NOT_SUPPORTED_ERR, "createDocument is not supported");
	}
	
}
