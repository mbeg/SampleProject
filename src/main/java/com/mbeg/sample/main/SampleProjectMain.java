package com.mbeg.sample.main;

import javax.swing.JFrame;

import com.mbeg.sample.view.SampleProjectMainFrame;

/**
 * 
 */

/**
 * @author mbeg
 *
 */
public class SampleProjectMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		SampleProjectMainFrame frame = new SampleProjectMainFrame();
		frame.setSize(600,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}

}
