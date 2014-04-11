/*
 * HTMLObjectElement.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.html;

import org.fit.cssbox.jsdombox.global.misc.JSAdapter;
import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface HTMLObjectElement Adapter
 * 
 * @author Radim Kocman
 */
public class HTMLObjectElement extends HTMLElement 
{
	public HTMLObjectElement(org.w3c.dom.Element source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
	}
	
	
	// DOM Level 2 HTML Implementation
	
	public JSAdapter getForm()
	{
		return getParentForm();
	}
	
	public String getCode()
	{
		String attr = jsaf.innerNameFormat("code");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setCode(String code)
	{
		String attr = jsaf.innerNameFormat("code");
		source.setAttribute(attr, code);
	}
	
	public String getAlign()
	{
		String attr = jsaf.innerNameFormat("align");
		return source.getAttribute(attr);
	}
	public void setAlign(String align)
	{
		String attr = jsaf.innerNameFormat("align");
		source.setAttribute(attr, align);
		jsaf.recomputeStyles();
	}
	
	public String getArchive()
	{
		String attr = jsaf.innerNameFormat("archive");
		return source.getAttribute(attr);
	}
	public void setArchive(String archive)
	{
		String attr = jsaf.innerNameFormat("archive");
		source.setAttribute(attr, archive);
	}
	
	public String getBorder()
	{
		String attr = jsaf.innerNameFormat("border");
		return source.getAttribute(attr);
	}
	public void setBorder(String border)
	{
		String attr = jsaf.innerNameFormat("border");
		source.setAttribute(attr, border);
		jsaf.recomputeStyles();
	}
	
	public String getCodeBase()
	{
		String attr = jsaf.innerNameFormat("codebase");
		String path = source.getAttribute(attr); 
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setCodeBase(String codeBase)
	{
		String attr = jsaf.innerNameFormat("codebase");
		source.setAttribute(attr, codeBase);
	}
	
	public String getCodeType()
	{
		String attr = jsaf.innerNameFormat("codetype");
		return source.getAttribute(attr);
	}
	public void setCodeType(String codeType)
	{
		String attr = jsaf.innerNameFormat("codetype");
		source.setAttribute(attr, codeType);
	}
	
	public String getData()
	{
		String attr = jsaf.innerNameFormat("data");
		String path = source.getAttribute(attr);
		return jsaf.htmlUri.getAbsolutePath(path);
	}
	public void setData(String data)
	{
		String attr = jsaf.innerNameFormat("data");
		source.setAttribute(attr, data);
	}
	
	public boolean getDeclare()
	{
		String attr = jsaf.innerNameFormat("declare");
		return source.hasAttribute(attr);
	}
	public void setDeclare(boolean decare)
	{
		String attr = jsaf.innerNameFormat("declare");
		setBooleanAttribute(attr, decare);
	}
	
	public String getHeight()
	{
		String attr = jsaf.innerNameFormat("height");
		return source.getAttribute(attr);
	}
	public void setHeight(String height)
	{
		String attr = jsaf.innerNameFormat("height");
		source.setAttribute(attr, height);
		jsaf.recomputeStyles();
	}
	
	public int getHspace()
	{
		String attr = jsaf.innerNameFormat("hspace");
		return getUnsignedAttribute(attr, 0);
	}
	public void setHspace(int hspace)
	{
		String attr = jsaf.innerNameFormat("hspace");
		setIntegerAttribute(attr, hspace);
		jsaf.recomputeStyles();
	}
	
	public String getName()
	{
		String attr = jsaf.innerNameFormat("name");
		return source.getAttribute(attr);
	}
	public void setName(String name)
	{
		String attr = jsaf.innerNameFormat("name");
		source.setAttribute(attr, name);
	}
	
	public String getStandby()
	{
		String attr = jsaf.innerNameFormat("standby");
		return source.getAttribute(attr);
	}
	public void setStandby(String standby)
	{
		String attr = jsaf.innerNameFormat("standby");
		source.setAttribute(attr, standby);
	}
	
	public int getTabIndex()
	{
		String attr = jsaf.innerNameFormat("tabindex");
		return getIntegerAttribute(attr, 0);
	}
	public void setTabIndex(int tabIndex)
	{
		String attr = jsaf.innerNameFormat("tabindex");
		setIntegerAttribute(attr, tabIndex);
	}
	
	public String getType()
	{
		String attr = jsaf.innerNameFormat("type");
		return source.getAttribute(attr);
	}
	public void setType(String type)
	{
		String attr = jsaf.innerNameFormat("type");
		source.setAttribute(attr, type);
	}
	
	public String getUseMap()
	{
		String attr = jsaf.innerNameFormat("usemap");
		return source.getAttribute(attr);
	}
	public void setUseMap(String useMap)
	{
		String attr = jsaf.innerNameFormat("usemap");
		source.setAttribute(attr, useMap);
	}
	
	public int getVspace()
	{
		String attr = jsaf.innerNameFormat("vspace");
		return getUnsignedAttribute(attr, 0);
	}
	public void setVspace(int vspace)
	{
		String attr = jsaf.innerNameFormat("vspace");
		setIntegerAttribute(attr, vspace);
		jsaf.recomputeStyles();
	}
	
	public String getWidth()
	{
		String attr = jsaf.innerNameFormat("width");
		return source.getAttribute(attr);
	}
	public void setWidth(String width)
	{
		String attr = jsaf.innerNameFormat("width");
		source.setAttribute(attr, width);
	}
	
	public JSAdapter getContentDocument()
	{
		return null;
	}
	
}
