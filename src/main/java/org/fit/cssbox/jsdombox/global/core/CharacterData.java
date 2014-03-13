/*
 * CharacterData.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.global.core;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;

/**
 * DOM Interface CharacterData Adapter
 * 
 * @author Radim Kocman
 */
public class CharacterData extends Node
{
	protected org.w3c.dom.CharacterData source;
	
	public CharacterData(org.w3c.dom.CharacterData source, JSAdapterFactory jsaf)
	{
		super(source, jsaf);
		this.source = source;
	}

	
	// DOM Level 1 Implementation
	
	public String getData()
	{
		return source.getData();
	}
	public void setData(String data)
	{
		source.setData(data);
		jsaf.recomputeStyles();
	}
	
	public int getLength()
	{
		return source.getLength();
	}
	
	public String substringData(int offset, int count)
	{
		return source.substringData(offset, count);
	}
	
	public void appendData(String arg)
	{
		source.appendData(arg);
		jsaf.recomputeStyles();
	}
	
	public void insertData(int offset, String arg)
	{
		source.insertData(offset, arg);
		jsaf.recomputeStyles();
	}
	
	public void deleteData(int offset, int count)
	{
		source.deleteData(offset, count);
		jsaf.recomputeStyles();
	}
	
	public void replaceData(int offset, int count, String arg)
	{
		source.replaceData(offset, count, arg);
		jsaf.recomputeStyles();
	}
	
	
	// DOM Level 2 Implementation
	// empty
	
}
