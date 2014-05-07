package org.fit.cssbox.jsdombox.global.util;

import org.fit.cssbox.jsdombox.global.misc.JSAdapterFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Node;

/**
 * Algorithms for search in HTML DOM tree
 * 
 * @author Radim Kocman
 */
public class HTMLTraversal
{
	/** current position for the getNthTagIn(Node|Table) */
	protected static int position;
	
	/** current index for the getIndexInParentTag */
	protected static int index;
	
	
	/**
	 * Checks if this is a searched tag
	 * @param node Tested Node
	 * @param tags Array of relevant HTML tags
	 * @return true|false
	 */
	protected static boolean isSearchedTag(Node node, String[] tags)
	{
		for (String tag : tags) {
			if (node.getNodeName().compareTo(tag) == 0) {
				return true;
			}
		}
		
		return false;
	}
	
	
	/**
	 * Counts specified tags in the DOM Node
	 * @param dom DOM tree
	 * @param tags Array of relevant HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @return Count of tags
	 */
	public static int getCountOfTagsInNode(Node dom, String[] tags, String[] skippedTags)
	{
		int count = 0;
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			count += getCountOfTags(node, tags, skippedTags);
		}
		
		return count;
	}
	protected static int getCountOfTags(Node dom, String[] tags, String[] skippedTags)
	{
		int count = 0;
		
		if (isSearchedTag(dom, skippedTags))
			return count;
		
		if (isSearchedTag(dom, tags))
			count++;
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			count += getCountOfTags(node, tags, skippedTags);
		}
		
		return count;
	}
	
	
	/**
	 * Gets the n-th specified tag in the DOM Node
	 * @param dom DOM tree
	 * @param tags Array of relevant HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @param n Index of the tag (zero-based)
	 * @return Node or null
	 */
	public static Node getNthTagInNode(Node dom, String[] tags, String[] skippedTags, int n)
	{
		if (n < 0) return null;
		position = 0;
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			Node result = getNthTag(node, tags, skippedTags, n);
			if (result != null)
				return result;
		}
		
		return null;
	}
	protected static Node getNthTag(Node dom, String[] tags, String[] skippedTags, int n) 
	{
		if (isSearchedTag(dom, skippedTags))
			return null;
		
		if (isSearchedTag(dom, tags)) {
			if (position == n)
				return dom;
			position++;
		}
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			Node result = getNthTag(node, tags, skippedTags, n);
			if (result != null)
				return result;
		}
		
		return null;
	}
	/**
	 * Gets the n-th specified tag in the table
	 * @param dom DOM tree
	 * @param tags Array of relevant HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @param n Index of the tag (zero-based)
	 * @param jsaf JSAdapterFactory for the name format
	 * @return Node or null
	 */
	public static Node getNthTagInTable(Node dom, String[] tags, String[] skippedTags, int n,
			JSAdapterFactory jsaf)
	{
		String thead = jsaf.innerNameFormat("thead");
		String tbody = jsaf.innerNameFormat("tbody");
		String tfoot = jsaf.innerNameFormat("tfoot");
		String[] theadArray = new String[] {thead};
		String[] tbodyArray = new String[] {tbody};
		String[] tfootArray = new String[] {tfoot};
		
		if (n < 0) return null;
		position = 0;
		
		// All thead sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, theadArray)) continue;
			Node result = getNthTag(node, tags, skippedTags, n);
			if (result != null) return result;
		}
		
		// All tbody sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tbodyArray)) continue;
			Node result = getNthTag(node, tags, skippedTags, n);
			if (result != null) return result;
		}
		
		// All tfoot sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tfootArray)) continue;
			Node result = getNthTag(node, tags, skippedTags, n);
			if (result != null) return result;
		}
		
		return null;
	}
	
	
	/**
	 * Gets the specified named tag in the Node
	 * @param dom DOM tree
	 * @param tags Array of relevant HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @param name Name of the tag
	 * @param jsaf JSAdapterFactory for the name format
	 * @return Node or null
	 */
	public static Node getNamedTagInNode(Node dom, String[] tags, String[] skippedTags, 
			String name, JSAdapterFactory jsaf)
	{
		// Search for the attribute id
		String attrid = jsaf.innerNameFormat("id");
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			Node result = getNamedTag(node, tags, skippedTags, name, attrid);
			if (result != null)
				return result;
		}
		
		// Search for the attribute name
		String attrname = jsaf.innerNameFormat("name");
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			Node result = getNamedTag(node, tags, skippedTags, name, attrname);
			if (result != null)
				return result;
		}
		
		return null;
	}
	protected static Node getNamedTag(Node dom, String[] tags, String[] skippedTags,
			String name, String attr)
	{
		if (isSearchedTag(dom, skippedTags))
			return null;
		
		if (isSearchedTag(dom, tags) && dom.hasAttributes()) {
			Attr attribute = (Attr) dom.getAttributes().getNamedItem(attr);
			if (attribute != null && attribute.getValue().equals(name)) 
				return dom;
		}
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			Node result = getNamedTag(node, tags, skippedTags, name, attr);
			if (result != null)
				return result;
		}
		
		return null;
	}
	/**
	 * Gets the specified named tag in the table
	 * @param dom DOM tree
	 * @param tags Array of relevant HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @param name Name of the tag
	 * @param jsaf JSAdapterFactory for the name format
	 * @return Node or null
	 */
	public static Node getNamedTagInTable(Node dom, String[] tags, String[] skippedTags, 
			String name, JSAdapterFactory jsaf)
	{
		String thead = jsaf.innerNameFormat("thead");
		String tbody = jsaf.innerNameFormat("tbody");
		String tfoot = jsaf.innerNameFormat("tfoot");
		String[] theadArray = new String[] {thead};
		String[] tbodyArray = new String[] {tbody};
		String[] tfootArray = new String[] {tfoot};
		
		// Search for the attribute id
		String attrid = jsaf.innerNameFormat("id");
		
		// All thead sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, theadArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrid);
			if (result != null) return result;
		}
		
		// All tbody sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tbodyArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrid);
			if (result != null) return result;
		}
		
		// All tfoot sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tfootArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrid);
			if (result != null) return result;
		}
		
		// Search for the attribute name
		String attrname = jsaf.innerNameFormat("name");
		
		// All thead sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, theadArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrname);
			if (result != null) return result;
		}
		
		// All tbody sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tbodyArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrname);
			if (result != null) return result;
		}
		
		// All tfoot sections
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (!isSearchedTag(node, tfootArray)) continue;
			Node result = getNamedTag(node, tags, skippedTags, name, attrname);
			if (result != null) return result;
		}
		
		return null;
	}
	
	
	/**
	 * Gets the parent tag of the Node
	 * @param dom Source Node
	 * @param tags Array of relevant HTML tags
	 * @return Node or null
	 */
	public static Node getParentTag(Node dom, String[] tags)
	{
		Node node = dom.getParentNode();
		
		while (node != null) {
			if (isSearchedTag(node, tags))
				return node;
			
			node = node.getParentNode();
		}
		
		return null;
	}
	
	
	/**
	 * Gets the index of the Node in the parent tag
	 * @param dom Source Node
	 * @param tags Array of relevant HTML tags
	 * @param parentTags Array of relevant parent HTML tags
	 * @param skippedTags Array of HTML tags that should be skipped
	 * @return Ordinal index (zero-based) or -1
	 */
	public static int getIndexInParentTag(Node dom, String[] tags, 
			String[] parentTags, String[] skippedTags)
	{
		Node parent = getParentTag(dom, parentTags);
		if (parent == null) return -1;
		
		index = 0;
		
		for (int i = 0; i < parent.getChildNodes().getLength(); i++) {
			Node node = parent.getChildNodes().item(i);
			if (getIndex(dom, node, tags, skippedTags))
				return index;
		}
		
		return -1;
	}
	protected static boolean getIndex(Node source, Node dom, String[] tags, 
			String[] skippedTags)
	{
		if (isSearchedTag(dom, skippedTags))
			return false;
		
		if (isSearchedTag(dom, tags)) {
			if (dom.isSameNode(source))
				return true;
			index++;
		}
		
		for (int i = 0; i < dom.getChildNodes().getLength(); i++) {
			Node node = dom.getChildNodes().item(i);
			if (getIndex(source, node, tags, skippedTags))
				return true;
		}
		
		return false;
	}
	
	/**
	 * Gets the index of the row in the table
	 * @param dom Source Node (row)
	 * @param jsaf JSAdapterFactory for the name format
	 * @return Table index (zero-based) or -1
	 */
	public static int getIndexOfTableRow(Node dom, JSAdapterFactory jsaf)
	{
		String table = jsaf.innerNameFormat("table");
		String thead = jsaf.innerNameFormat("thead");
		String tbody = jsaf.innerNameFormat("tbody");
		String tfoot = jsaf.innerNameFormat("tfoot");
		String tr = jsaf.innerNameFormat("tr");
		String[] tableArray = new String[] {table};
		String[] theadArray = new String[] {thead};
		String[] tbodyArray = new String[] {tbody};
		String[] tfootArray = new String[] {tfoot};
		String[] trArray = new String[] {tr};
		
		Node parent = getParentTag(dom, tableArray);
		if (parent == null) return -1;
		
		index = 0;
		
		// All thead sections
		for (int i = 0; i < parent.getChildNodes().getLength(); i++) {
			Node node = parent.getChildNodes().item(i);
			if (!isSearchedTag(node, theadArray))
				continue;
			if (getIndex(dom, node, trArray, tableArray))
				return index;
		}
		
		// All tbody sections
		for (int i = 0; i < parent.getChildNodes().getLength(); i++) {
			Node node = parent.getChildNodes().item(i);
			if (!isSearchedTag(node, tbodyArray))
				continue;
			if (getIndex(dom, node, trArray, tableArray))
				return index;
		}
		
		// All tfoot sections
		for (int i = 0; i < parent.getChildNodes().getLength(); i++) {
			Node node = parent.getChildNodes().item(i);
			if (!isSearchedTag(node, tfootArray))
				continue;
			if (getIndex(dom, node, trArray, tableArray))
				return index;
		}
		
		return -1;
	}
	
}
