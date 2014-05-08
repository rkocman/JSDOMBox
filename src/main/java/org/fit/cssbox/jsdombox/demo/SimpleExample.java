/*
 * SimpleExample.java
 * Copyright (c) Radim Kocman
 */

package org.fit.cssbox.jsdombox.demo;

import java.io.File;
import java.net.URL;

import javax.swing.JFrame;

import org.fit.cssbox.css.CSSNorm;
import org.fit.cssbox.css.DOMAnalyzer;
import org.fit.cssbox.io.DOMSource;
import org.fit.cssbox.io.DefaultDOMSource;
import org.fit.cssbox.io.DefaultDocumentSource;
import org.fit.cssbox.io.DocumentSource;
import org.fit.cssbox.jsdombox.js.JSAnalyzer;
import org.fit.cssbox.layout.BrowserCanvas;
import org.w3c.dom.Document;

/**
 * An example of using JSDOMBox for the HTML page rendering and display.
 * 
 * @author Radim Kocman
 */
public class SimpleExample extends javax.swing.JFrame 
{

	private static final long serialVersionUID = -5041712150308470665L;
	
	private DOMAnalyzer da;
	private URL url;
	private javax.swing.JScrollPane documentScroll;
	private javax.swing.JPanel browserCanvas;
	
	public SimpleExample(DOMAnalyzer da, URL url)
	{
		this.da = da;
		this.url = url;
		initComponents();
	}
	
	/**
	 * Creates and initializes the GUI components
	 */
	private void initComponents()
	{
		documentScroll = new javax.swing.JScrollPane();
		browserCanvas = new BrowserCanvas(da.getRoot(), da, new java.awt.Dimension(1000, 750), url);
		getContentPane().setLayout(new java.awt.GridLayout(1, 0));
		
		setTitle("JSDOMBox Browser");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		documentScroll.setViewportView(browserCanvas);
		getContentPane().add(documentScroll);
		pack();
	}

	/**
     * @param args the command line arguments
     */
	public static void main(String[] args)
	{
		try {

			String document = "src/test/resources/";
			
			// 0 - Document
			//document += "dom-core1_basic-usage.html";
			//document += "dom-core1_attribute-style.html";
			//document += "dom-core1_document-structure.html";
			//document += "dom-core2_constants.html";
			//document += "dom-core2_table-structure.html";
			//document += "dom-core2_square-bracket-notation.html"; // (not working)
			//document += "dom-html2_name-size.html";
			//document += "dom-html2_htmlelement.html";
			//document += "dom-html2_global-htmlelements.html";
			//document += "dom-html2_list-htmlelements.html";
			//document += "dom-html2_content-htmlelements.html";
			//document += "dom-html2_uri-format.html";
			//document += "dom-html2_content2-htmlelements.html";
			//document += "dom-html2_frame-htmlelements.html";
			//document += "dom-html2_form-htmlelements.html";
			//document += "dom-html2_table-htmlelements.html";
			document += "dom-html2_htmldocument.html";
			
			// 1 - Get input document
			String basePath = new File(document).getAbsolutePath();
			DocumentSource docSource = new DefaultDocumentSource("file:///"+basePath);
			DOMSource parser = new DefaultDOMSource(docSource);
			
			// 2 - Convert to DOM
			Document doc = parser.parse();
			String encoding = parser.getCharset();
			
			// 3 - Analyze styles
			DOMAnalyzer da = new DOMAnalyzer(doc, docSource.getURL());
			if (encoding == null)
                encoding = da.getCharacterEncoding();
			da.setDefaultEncoding(encoding);
            da.attributesToStyles();
            da.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.formsStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.getStyleSheets();
			
			// 4 (new) - Execute JavaScript
            JSAnalyzer jsa = new JSAnalyzer(da, doc, docSource.getURL());
            jsa.run();
            
            // 3 (bypass) - Recompute styles
            da = new DOMAnalyzer(doc, docSource.getURL());
			if (encoding == null)
                encoding = da.getCharacterEncoding();
			da.setDefaultEncoding(encoding);
            da.attributesToStyles();
            da.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.formsStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.getStyleSheets();
			
			// 5 - Display result
            SimpleExample test = new SimpleExample(da, docSource.getURL());
            test.setSize(1020, 800);
            test.setLocationRelativeTo(null);
            test.setVisible(true);
			
			System.out.println("--OK--");
			
		} catch (Exception e) {
			System.err.println("*** Error: " + e.getMessage());
            e.printStackTrace();
		}
	}
	
}
