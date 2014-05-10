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
		jsaf.cssEvent.recomputeStyles(source);
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
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public void insertData(int offset, String arg)
	{
		source.insertData(offset, arg);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public void deleteData(int offset, int count)
	{
		source.deleteData(offset, count);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	public void replaceData(int offset, int count, String arg)
	{
		source.replaceData(offset, count, arg);
		jsaf.cssEvent.recomputeStyles(source);
	}
	
	
	// DOM Level 2 Implementation
	// empty
	
}
