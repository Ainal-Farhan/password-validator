package gui;

import javax.swing.JFrame;

/**
 * @author Mohd Ainal Farhan Mohamad Johari
 * 
 * Project : Password Validator
 * Date    : Jul 16, 2020
 * 
 */

public abstract class GUI {
	protected static JFrame mainFrame;
	
	public GUI() {
		mainFrame = new JFrame();
	}
	
	protected void disposeMainFrame() {
		mainFrame.dispose();
	}
	
	protected abstract void displayGUI();
	protected abstract void setFrame();
	protected abstract void closeGUI();
}
