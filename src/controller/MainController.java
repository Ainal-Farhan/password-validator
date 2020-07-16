package controller;

/**
 * @author Mohd Ainal Farhan Mohamad Johari
 * 
 * Project : Password Validator
 * Date    : Jul 16, 2020
 * 
 */

public class MainController {
	public static void main(String[] args) {
		PasswordValidatorController controller = new PasswordValidatorController();
		controller.setGUIContent();
		controller.displayGUI();
	}
}
