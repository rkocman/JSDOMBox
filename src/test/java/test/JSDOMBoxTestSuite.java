/*
 * JSDOMBoxTestSuite.java
 * Copyright (c) Radim Kocman
 */

package test;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.GridLayout;

import javax.swing.JList;
import javax.swing.JPanel;

import java.awt.FlowLayout;
import java.awt.Cursor;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;

import javax.swing.AbstractListModel;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.Timer;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.io.File;
import java.net.URL;

import javax.swing.ButtonGroup;

import org.fit.cssbox.css.CSSNorm;
import org.fit.cssbox.css.DOMAnalyzer;
import org.fit.cssbox.io.DOMSource;
import org.fit.cssbox.io.DefaultDOMSource;
import org.fit.cssbox.io.DefaultDocumentSource;
import org.fit.cssbox.io.DocumentSource;
import org.fit.cssbox.jsdombox.js.JSAnalyzer;
import org.fit.cssbox.layout.BrowserCanvas;
import org.w3c.dom.Document;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;

/**
 * Test suite application for the JSDOMBox
 * 
 * @author Radim Kocman
 */
public class JSDOMBoxTestSuite
{

	private JFrame frmJsdomboxTestSuite;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<String> testList;
	private JScrollPane browserPane;
	private JRadioButton jsdomboxButton;
	private JRadioButton cssboxButton;
	
	private DOMAnalyzer da;
	private URL url;
	
	private Timer resizeTimer;

	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JSDOMBoxTestSuite window = new JSDOMBoxTestSuite();
					window.frmJsdomboxTestSuite.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public JSDOMBoxTestSuite() {
		initialize();
		createBrowserContent();
		
		// Resize Timer initialization
		resizeTimer = new Timer(200, new ActionListener() {
		    public void actionPerformed(ActionEvent evt) {
		        renderBrowserContent();
		        frmJsdomboxTestSuite.setVisible(true);
		        renderBrowserContent();
		    }
		});
		resizeTimer.setRepeats(false);
		
		// Keyboard Listener
		KeyboardFocusManager.getCurrentKeyboardFocusManager()
			.addKeyEventDispatcher(new KeyEventDispatcher() {
			
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() != KeyEvent.KEY_PRESSED)
					return false;
				
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					jsdomboxButton.setSelected(true);
				
				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					cssboxButton.setSelected(true);
				
				return false;
			}
		});
	}
	
	/**
	 * Create the browser content
	 */
	private void createBrowserContent()
	{
		try {
			
			frmJsdomboxTestSuite.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
			
			// 0 - Document
			String document = "src/test/resources/";
			document += testList.getSelectedValue().toString().trim();
			
			// 1 - Get input document
			String basePath = new File(document).getAbsolutePath();
			DocumentSource docSource = new DefaultDocumentSource("file:///"+basePath);
			DOMSource parser = new DefaultDOMSource(docSource);
			url = docSource.getURL();
			
			// 2 - Convert to DOM
			Document doc = parser.parse();
			String encoding = parser.getCharset();
			
			// 3 - Analyze styles
			da = new DOMAnalyzer(doc, url);
			if (encoding == null)
                encoding = da.getCharacterEncoding();
			da.setDefaultEncoding(encoding);
            da.attributesToStyles();
            da.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.addStyleSheet(null, CSSNorm.formsStyleSheet(), DOMAnalyzer.Origin.AGENT);
            da.getStyleSheets();
            
            if (jsdomboxButton.isSelected()) {
            	
            	// 4 (new) - Execute JavaScript
                JSAnalyzer jsa = new JSAnalyzer(da, url);
                jsa.setHTMLListener(new TestHTMLListener());
                jsa.run();
                
                // 5 (bypass) - Recompute styles
                da = new DOMAnalyzer(doc, url);
    			if (encoding == null)
                    encoding = da.getCharacterEncoding();
    			da.setDefaultEncoding(encoding);
                da.attributesToStyles();
                da.addStyleSheet(null, CSSNorm.stdStyleSheet(), DOMAnalyzer.Origin.AGENT);
                da.addStyleSheet(null, CSSNorm.userStyleSheet(), DOMAnalyzer.Origin.AGENT);
                da.addStyleSheet(null, CSSNorm.formsStyleSheet(), DOMAnalyzer.Origin.AGENT);
                da.getStyleSheets();
            	
            }
            
            // 6 - Display result
            renderBrowserContent();
            
            //System.out.println("--OK--");
			
		} catch (Exception e) {
			System.err.println("*** Error: " + e.getMessage());
            e.printStackTrace();
		} finally {
			frmJsdomboxTestSuite.setCursor(Cursor.getDefaultCursor());
		}
	}
	
	/**
	 * Render the browser content
	 */
	public void renderBrowserContent()
	{
		JPanel browserCanvas = new BrowserCanvas(
        	da.getRoot(), 
        	da, 
        	new java.awt.Dimension(
        		browserPane.getViewport().getSize().width,
        		browserPane.getViewport().getSize().height
        	), 
        	url
        );
        browserPane.setViewportView(browserCanvas);
        //System.out.println("--OK--");
        
        // Force garbage collection
        System.gc();
	}

	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		frmJsdomboxTestSuite = new JFrame();
		frmJsdomboxTestSuite.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent arg0) {
				resizeTimer.restart();
			}
		});
		frmJsdomboxTestSuite.setMinimumSize(new Dimension(700, 500));
		frmJsdomboxTestSuite.setTitle("JSDOMBox Test Suite");
		frmJsdomboxTestSuite.setSize(1300, 800);
		frmJsdomboxTestSuite.setLocationRelativeTo(null);
		frmJsdomboxTestSuite.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJsdomboxTestSuite.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBorder(null);
		splitPane.setDividerSize(0);
		splitPane.setEnabled(false);
		frmJsdomboxTestSuite.getContentPane().add(splitPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setMinimumSize(new Dimension(250, 23));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		splitPane.setLeftComponent(scrollPane);
		
		JPanel panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		testList = new JList<String>();
		testList.setBorder(new EmptyBorder(5, 5, 5, 5));
		testList.setFixedCellHeight(20);
		testList.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		testList.setVisibleRowCount(0);
		testList.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {" dom-core1_hello-world.html", " dom-core1_basic-usage.html", " dom-core1_attribute-style.html", " dom-core1_document-structure.html", " dom-core2_constants.html", " dom-core2_table-structure.html", " dom-html2_name-size.html", " dom-html2_htmldocument.html", " dom-html2_htmlelement.html", " dom-html2_uri-format.html", " dom-html2_global-htmlelements.html", " dom-html2_list-htmlelements.html", " dom-html2_frame-htmlelements.html", " dom-html2_form-htmlelements.html", " dom-html2_table-htmlelements.html", " dom-html2_content-htmlelements.html", " dom-html2_content2-htmlelements.html", " dom-html2_speed-test.html", " dom-core2_square-bracket-notation.html"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		testList.setSelectedIndex(0);
		testList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting() == false)
					createBrowserContent();
			}
		});
		panel.add(testList);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerSize(0);
		splitPane_1.setEnabled(false);
		splitPane_1.setBorder(null);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		browserPane = new JScrollPane();
		browserPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		browserPane.getVerticalScrollBar().setUnitIncrement(16);
		splitPane_1.setRightComponent(browserPane);
		
		JPanel browserCanvas = new JPanel();
		browserPane.setViewportView(browserCanvas);
		
		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		splitPane_1.setLeftComponent(panel_2);
		
		JLabel lblBrowser = new JLabel("  Browser:");
		panel_2.add(lblBrowser);
		
		jsdomboxButton = new JRadioButton("JSDOMBox (Rhino)");
		jsdomboxButton.setFocusable(false);
		jsdomboxButton.setFocusPainted(false);
		buttonGroup.add(jsdomboxButton);
		jsdomboxButton.setSelected(true);
		jsdomboxButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED)
					createBrowserContent();
			}
		});
		panel_2.add(jsdomboxButton);
		
		cssboxButton = new JRadioButton("CSSBox (Without JS)");
		cssboxButton.setFocusable(false);
		cssboxButton.setFocusPainted(false);
		buttonGroup.add(cssboxButton);
		cssboxButton.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if (arg0.getStateChange() == ItemEvent.SELECTED)
					createBrowserContent();
			}
		});
		panel_2.add(cssboxButton);
		
		frmJsdomboxTestSuite.setVisible(true);
	}
	
}
