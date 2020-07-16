package controller;

import gui.PasswordValidatorGUI;

/**
 * @author Mohd Ainal Farhan Mohamad Johari
 * 
 * Project : Password Validator
 * Date    : Jul 16, 2020
 * 
 */

public class PasswordValidatorController extends PasswordValidatorGUI{
	public PasswordValidatorController() {
		super();
	}
	
	public void setGUIContent() {
		super.setFrame();
		super.setButtonEvent();
		
		int y = 0;
		
		y = super.addStatusLabel(y, 0);
		y = super.addJTextField(y, 0);
		y = super.addCheckbox(y, 0);
		y = super.addJButton(y, 0);
	}
	
	public void displayGUI() {
		super.displayGUI();
	}
}
