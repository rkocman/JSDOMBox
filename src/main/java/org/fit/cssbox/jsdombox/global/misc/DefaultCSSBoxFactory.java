/*
 * DefaultCSSBoxFactory.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.misc;

import java.net.URL;

import org.fit.cssbox.jsdombox.event.HTMLListener;
import org.fit.cssbox.jsdombox.global.core.*;
import org.fit.cssbox.jsdombox.global.html.*;
import org.fit.cssbox.jsdombox.global.util.HTMLURI;
import org.fit.cssbox.jsdombox.js.JSAnalyzer;

/**
 * Default JS Adapter Factory for the CSSBox DOM
 * 
 * @author Radim Kocman
 */
public class DefaultCSSBoxFactory extends JSAdapterFactory
{
	protected JSAnalyzer jsa;
	
	public DefaultCSSBoxFactory(
			JSAnalyzer jsa, org.w3c.dom.Document doc, URL basePath,
			HTMLListener htmlListener
	) {
		this.jsa = jsa;
		this.htmlEvent = htmlListener;
		this.htmlUri = new HTMLURI(this, doc, basePath);
	}

	/**
	 * Creates appropriate JS adapter for the Java DOM object
	 * @param source Java DOM object
	 * @param type JSAdapter type
	 * @return Initialized JS adapter
	 */
	public JSAdapter create(Object source, JSAdapterType type)
	{
		// Null is null
		if (source == null)
			return null;
		
		
		// Prior handlers
		
		// Interface NodeList
		if (type == JSAdapterType.NODE_LIST)
			return new NodeList((org.w3c.dom.NodeList) source, this);	
		// Interface NamedNodeMap
		if (type == JSAdapterType.NAMED_NODE_MAP)
			return new NamedNodeMap((org.w3c.dom.NamedNodeMap) source, this);
		
		
		
		// HTML Interfaces
		
		if (source instanceof org.w3c.dom.Element) {
			switch (((org.w3c.dom.Element) source).getTagName()) {		
			// Interface HTMLHtmlElement
			case "html":
				return new HTMLHtmlElement((org.w3c.dom.Element) source, this);
			// Interface HTMLHeadElement
			case "head":
				return new HTMLHeadElement((org.w3c.dom.Element) source, this);
			// Interface HTMLLinkElement
			case "link":
				return new HTMLLinkElement((org.w3c.dom.Element) source, this);
			// Interface HTMLTitleElement
			case "title":
				return new HTMLTitleElement((org.w3c.dom.Element) source, this);
			// Interface HTMLMetaElement
			case "meta":
				return new HTMLMetaElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBaseElement
			case "base":
				return new HTMLBaseElement((org.w3c.dom.Element) source, this);
			// Interface HTMLStyleElement
			case "style":
				return new HTMLStyleElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBodyElement
			case "body":
				return new HTMLBodyElement((org.w3c.dom.Element) source, this);
			// Interface HTMLFormElement
			case "form":
				return new HTMLFormElement((org.w3c.dom.Element) source, this);
			// Interface HTMLSelectElement
			case "select":
				return new HTMLSelectElement((org.w3c.dom.Element) source, this);
			// Interface HTMLOptGroupElement
			case "optgroup":
				return new HTMLOptGroupElement((org.w3c.dom.Element) source, this);
			// Interface HTMLOptionElement
			case "option":
				return new HTMLOptionElement((org.w3c.dom.Element) source, this);
			// Interface HTMLInputElement
			case "input":
				return new HTMLInputElement((org.w3c.dom.Element) source, this);
			// Interface HTMLTextAreaElement
			case "textarea":
				return new HTMLTextAreaElement((org.w3c.dom.Element) source, this);
			// Interface HTMLButtonElement
			case "button":
				return new HTMLButtonElement((org.w3c.dom.Element) source, this);
			// Interface HTMLLabelElement
			case "label":
				return new HTMLLabelElement((org.w3c.dom.Element) source, this);
			// Interface HTMLFieldSetElement
			case "fieldset":
				return new HTMLFieldSetElement((org.w3c.dom.Element) source, this);
			// Interface HTMLUListElement
			case "ul":
				return new HTMLUListElement((org.w3c.dom.Element) source, this);
			// Interface HTMLOListElement
			case "ol":
				return new HTMLOListElement((org.w3c.dom.Element) source, this);
			// Interface HTMLDListElement
			case "dl":
				return new HTMLDListElement((org.w3c.dom.Element) source, this);
			// Interface HTMLDirectoryElement
			case "dir":
				return new HTMLDirectoryElement((org.w3c.dom.Element) source, this);
			// Interface HTMLMenuElement
			case "menu":
				return new HTMLMenuElement((org.w3c.dom.Element) source, this);
			// Interface HTMLLIElement
			case "li":
				return new HTMLLIElement((org.w3c.dom.Element) source, this);
			// Interface HTMLDivElement
			case "div":
				return new HTMLDivElement((org.w3c.dom.Element) source, this);
			// Interface HTMLParagraphElement
			case "p":
				return new HTMLParagraphElement((org.w3c.dom.Element) source, this);
			// Interface HTMLHeadingElement
			case "h1": case "h2": case "h3":
			case "h4": case "h5": case "h6":
				return new HTMLHeadingElement((org.w3c.dom.Element) source, this);
			// Interface HTMLQuoteElement
			case "q": case "blockquote":
				return new HTMLQuoteElement((org.w3c.dom.Element) source, this);
			// Interface HTMLPreElement
			case "pre":
				return new HTMLPreElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBRElement
			case "br":
				return new HTMLBRElement((org.w3c.dom.Element) source, this);
			// Interface HTMLBaseFontElement
			case "basefont":
				return new HTMLBaseFontElement((org.w3c.dom.Element) source, this);
			// Interface HTMLFontElement
			case "font":
				return new HTMLFontElement((org.w3c.dom.Element) source, this);
			// Interface HTMLHRElement
			case "hr":
				return new HTMLHRElement((org.w3c.dom.Element) source, this);
			// Interface HTMLModElement
			case "ins": case "del":
				return new HTMLModElement((org.w3c.dom.Element) source, this);
			// Interface HTMLAnchorElement
			case "a":
				return new HTMLAnchorElement((org.w3c.dom.Element) source, this);
			// Interface HTMLImageElement
			case "img":
				return new HTMLImageElement((org.w3c.dom.Element) source, this);
			// Interface HTMLObjectElement
			case "object":
				return new HTMLObjectElement((org.w3c.dom.Element) source, this);
			// Interface HTMLParamElement
			case "param":
				return new HTMLParamElement((org.w3c.dom.Element) source, this);
			// Interface HTMLAppletElement
			case "applet":
				return new HTMLAppletElement((org.w3c.dom.Element) source, this);
			// Interface HTMLMapElement
			case "map":
				return new HTMLMapElement((org.w3c.dom.Element) source, this);
			// Interface HTMLAreaElement
			case "area":
				return new HTMLAreaElement((org.w3c.dom.Element) source, this);
			// Interface HTMLScriptElement
			case "script":
				return new HTMLScriptElement((org.w3c.dom.Element) source, this);
			// Interface HTMLFrameSetElement
			case "frameset":
				return new HTMLFrameSetElement((org.w3c.dom.Element) source, this);
			// Interface HTMLFrameElement
			case "frame":
				return new HTMLFrameElement((org.w3c.dom.Element) source, this);
			// Interface HTMLIFrameElement
			case "iframe":
				return new HTMLIFrameElement((org.w3c.dom.Element) source, this);
			
			// Interface HTMLElement
			default:
				return new HTMLElement((org.w3c.dom.Element) source, this);
			}
		}
		
		
		
		// Core interfaces
		
		// Interface DOMImplementation
		if (source instanceof org.w3c.dom.DOMImplementation)
			return new DOMImplementation((org.w3c.dom.DOMImplementation) source, this);
		// Interface Document
		if (source instanceof org.w3c.dom.Document)
			return new Document((org.w3c.dom.Document) source, this);
		// Interface DocumentFragment
		if (source instanceof org.w3c.dom.DocumentFragment)
			return new DocumentFragment((org.w3c.dom.DocumentFragment) source, this);
		
		// Interface Attr
		if (source instanceof org.w3c.dom.Attr)
			return new Attr((org.w3c.dom.Attr) source, this);
		
		// Interface Comment
		if (source instanceof org.w3c.dom.Comment)
			return new Comment((org.w3c.dom.Comment) source, this);
		// Interface Text
		if (source instanceof org.w3c.dom.Text)
			return new Text((org.w3c.dom.Text) source, this);
		
		// Interface Node
		if (source instanceof org.w3c.dom.Node)
			return new Node((org.w3c.dom.Node) source, this);
		
		
		
		// Fall-back to the Base Adapter
		System.err.println("*** JavaScript Adapter Factory fall-back");
		return new JSAdapter(source, this);
	}
	
	/**
	 * Converts names into the inner DOM format (lowercase)
	 */
	public String innerNameFormat(String name)
	{
		return name.toLowerCase();
	}
	

	/**
	 * Recomputes CSS in the CSSBox
	 */
	public void recomputeStyles()
	{
		jsa.recomputeStyles();
	}

}
