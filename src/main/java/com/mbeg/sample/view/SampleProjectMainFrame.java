/**
 * 
 */
package com.mbeg.sample.view;

import java.awt.BorderLayout;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.mbeg.sample.tool.ResourceAccessor;

/**
 * @author mbeg
 * 
 */
public class SampleProjectMainFrame extends JFrame {

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
		
		contentContainer.add(lblWithText, BorderLayout.CENTER);
		
		add(contentContainer);
		
	}

}
