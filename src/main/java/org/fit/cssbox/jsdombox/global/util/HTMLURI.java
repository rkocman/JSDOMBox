/*
 * HTMLURI.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.util;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.w3c.dom.Element;

/**
 * Class for manipulation with the HTML URIs
 * 
 * @author Radim Kocman
 */
public class HTMLURI
{
	private JSAdapterFactory jsaf;
	private org.w3c.dom.Document doc; // DOM of the parsed document
	private URL documentBasePath; // Base path of the parsed document
	private URL htmlBasePath; // HTML base path with the tag <base>
	
	public HTMLURI(JSAdapterFactory jsaf, org.w3c.dom.Document doc, URL basePath)
	{
		this.jsaf = jsaf;
		this.doc = doc;
		documentBasePath = basePath;
		recomputeHtmlBasePath();
	}
	
	/**
	 * Recomputes the HTML base path with the current DOM 
	 */
	public void recomputeHtmlBasePath()
	{
		String tagHead = jsaf.innerNameFormat("head");
		String tagBase = jsaf.innerNameFormat("base");
		String attrHref = jsaf.innerNameFormat("href");
		htmlBasePath = documentBasePath;
		
		Element head = (Element) doc.getElementsByTagName(tagHead).item(0);
		if (head == null) return;
		Element base = (Element) head.getElementsByTagName(tagBase).item(0);
		if (base == null) return;
		String htmlbase = base.getAttribute(attrHref);
		
		try {
            htmlBasePath = new URL(documentBasePath, htmlbase);
        } catch (MalformedURLException e) {}
	}
	
	/**
	 * Gets the absolute path for the URI attribute
	 * @param path Text of the URI attribute
	 * @return Converted absolute path
	 */
	public String getAbsolutePath(String path)
	{
		return getAbsolutePath(path, true);
	}
	
	/**
	 * Gets the absolute path for the URI attribute
	 * @param path Text of the URI attribute
	 * @param html Should be used the HTML base path? 
	 * @return Converted absolute path
	 */
	public String getAbsolutePath(String path, boolean html)
	{
		try {
			path = URLDecoder.decode(path, "UTF-8");
			URL absolute;
			if (html)
				absolute = new URL(htmlBasePath, path);
			else
				absolute = new URL(documentBasePath, path);
			return encodeUrl(absolute);
		} catch (MalformedURLException | UnsupportedEncodingException e) {
			return path;
		}
	}
	
	/**
	 * Gets the absolute path for the URI attribute
	 * @param path Text of the URI attribute
	 * @param html Should be used the HTML base path?
	 * @param keepEmpty Do not expand an empty path?
	 * @return Converted absolute path
	 */
	public String getAbsolutePath(String path, boolean html, boolean keepEmpty)
	{
		if (keepEmpty && path.isEmpty()) return path;
		return getAbsolutePath(path, html);
	}
	
	/**
	 * Encodes passed URL
	 * @param url Prepared URL
	 */
	protected String encodeUrl(URL url)
	{
		try {
	        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), 
	        		url.getPort(), url.getPath(), url.getQuery(), url.getRef()); 
	        return uri.toASCIIString(); 
		} catch (URISyntaxException e) {
			return url.toString();
		}
	}
	
	/**
	 * Gets the server domain name of the document
	 * @return Domain name 
	 */
	public String getDocumentDomain()
	{
		try {
			URI uri = documentBasePath.toURI();
			return (uri.getHost() != null)? uri.getHost() : ""; 
		} catch (URISyntaxException e) {
			return null;
		} 
	}
	
	/**
	 * Gets the URL of the document
	 * @return URL 
	 */
	public String getDocumentURL()
	{
		return encodeUrl(documentBasePath);
	}
	
}
