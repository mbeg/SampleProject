/**
 * 
 */
package com.mbeg.sample.view;

import java.awt.BorderLayout;
import java.util.Locale;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mbeg.sample.tool.BundleAccessor;
import com.mbeg.sample.tool.ResourceAccessor;

/**
 * @author mbeg
 * 
 */
public class SampleProjectMainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7795214309070627986L;
	
	private JPanel contentContainer = new JPanel();

	/**
	 * 
	 */
	public SampleProjectMainFrame() {
		try {
			initUI();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void initUI() {

		contentContainer.setLayout(new BorderLayout());
		
		JLabel lblWithText = new JLabel(ResourceAccessor.getInstance().loadImage("icons/apply32.png"));
		
		Properties props = ResourceAccessor.getInstance().getProperties("Project.properties");
		String text = props.getProperty("ApplicationName");
		lblWithText.setText(text);
		
		Locale.setDefault(new Locale("en"));
		
		String monat = BundleAccessor.getInstance().getResourceString("Month1");
		System.out.println(monat);
		
		
		contentContainer.add(lblWithText, BorderLayout.CENTER);
		
		add(contentContainer);
		
	}

}
