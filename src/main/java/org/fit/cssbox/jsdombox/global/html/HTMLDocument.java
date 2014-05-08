/*
 * HTMLDocument.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.core.Document;
import org.fit.cssbox.jsdombox.global.core.Node;
import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.w3c.dom.DOMException;

/**
 * DOM Interface HTMLDocument Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLDocument extends Document
{
	protected HTMLCollection body;
	protected HTMLCollection images;
	protected HTMLCollection applets;
	protected HTMLCollection links;
	protected HTMLCollection forms;
	protected HTMLCollection anchors;
	
	public HTMLDocument(org.w3c.dom.Document source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		
		String[] tags;
		String[] skippedTags;
		
		// Body HTMLCollection
		String sBody = jsaf.innerNameFormat("body");
		String frameset = jsaf.innerNameFormat("frameset");
		tags = new String[] {sBody, frameset};
		skippedTags = new String[] {};
		body = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// Images HTMLCollection
		String img = jsaf.innerNameFormat("img");
		tags = new String[] {img};
		skippedTags = new String[] {};
		images = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// Applets HTMLCollection
		String applet = jsaf.innerNameFormat("applet");
		tags = new String[] {applet};
		skippedTags = new String[] {};
		applets = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// Links HTMLCollection
		String a = jsaf.innerNameFormat("a");
		String area = jsaf.innerNameFormat("area");
		String href = jsaf.innerNameFormat("href");
		tags = new String[] {a, area};
		skippedTags = new String[] {};
		links = new HTMLCollection(source, jsaf, tags, skippedTags, href, null);
		
		// Forms HTMLCollection
		String form = jsaf.innerNameFormat("form");
		tags = new String[] {form};
		skippedTags = new String[] {};
		forms = new HTMLCollection(source, jsaf, tags, skippedTags);
		
		// Anchors HTMLCollection
		String name = jsaf.innerNameFormat("name");
		tags = new String[] {a};
		skippedTags = new String[] {};
		anchors = new HTMLCollection(source, jsaf, tags, skippedTags, name, null);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public String getTitle()
	{
		return jsaf.htmlEvent.document_getTitle(source);
	}
	public void setTitle(String title)
	{
		jsaf.htmlEvent.document_setTitle(source, title);
	}
	
	public String getReferrer()
	{
		return jsaf.htmlEvent.document_getReferrer(source);
	}
	
	public String getDomain()
	{
		return jsaf.htmlUri.getDocumentDomain();
	}
	
	public String getURL()
	{
		return jsaf.htmlUri.getDocumentURL();
	}
	
	public JSAdapter getBody()
	{
		return body.item(0);
	}
	public void setBody(JSAdapter body)
	{
		if (!(body instanceof Node)) return;
		if (
			((Node) body).getNodeName().compareToIgnoreCase("body") != 0 &&
			((Node) body).getNodeName().compareToIgnoreCase("frameset") != 0
		) return;
		
		removeChild((Node) getBody());
		appendChild((Node) body);
	}
	
	public JSAdapter getImages()
	{
		return images;
	}
	
	public JSAdapter getApplets()
	{
		return applets;
	}
	
	public JSAdapter getLinks()
	{
		return links;
	}
	
	public JSAdapter getForms()
	{
		return forms;
	}
	
	public JSAdapter getAnchors()
	{
		return anchors;
	}
	
	public String getCookie()
	{
		return jsaf.htmlEvent.document_getCookie(source);
	}
	public void setCookie(String cookie)
	{
		if (!jsaf.htmlEvent.document_setCookie(source, cookie))
			throw new DOMException(DOMException.SYNTAX_ERR, "Invalid cookie syntax");
	}
	
	public void open()
	{
		jsaf.parserEvent.document_open(source);
	}
	
	public void close()
	{
		jsaf.parserEvent.document_close(source);
	}
	
	public void write(String text)
	{
		jsaf.parserEvent.document_write(source, text);
	}
	
	public void writeln(String text)
	{
		jsaf.parserEvent.document_writeln(source, text);
	}
	
	public JSAdapter getElementsByName(String elementName)
	{
		return new HTMLCollection(source, jsaf, new String[]{}, new String[]{}, 
				null, elementName);
	}
	
}
