package gui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import features.Validator;

/**
 * @author Mohd Ainal Farhan Mohamad Johari
 * 
 * Project : Password Validator
 * Date    : Jul 16, 2020
 * 
 */

public class PasswordValidatorGUI extends GUI{
	private Validator validator;
	
	private JTextField password;
	private JTextField passwordLength;
	
	private final JLabel passLabel = new JLabel("Password : ");
	private final JLabel passLengthLabel = new JLabel("Max Length (int) : ");
	private final JLabel conditionLabel = new JLabel("Condition (may choose may than 1) : ");
	private final JLabel passwordStatus = new JLabel("Status : ");
	
	private JLabel passwordEntered;
	private JLabel errorLabel;
	
	private JCheckBox[] selection = {
			new JCheckBox("Number", false),
			new JCheckBox("Special Character", false),
			new JCheckBox("Alphabet", false)
		};
	
	private final JButton exitButton = new JButton("Exit");
	private final JButton validateButton = new JButton("Validate");
	
	private GridBagConstraints constraints;
	
	protected PasswordValidatorGUI() {
		validator = new Validator();
		password = new JTextField(20);
		passwordLength = new JTextField(5);
		passwordEntered = new JLabel("Password : NONE");
		errorLabel = new JLabel("NONE");
	}
	
	protected int addJTextField(int y, int x) {
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridwidth = 2;
		
		//Set passLabel format
		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Adding password into mainFrame
		mainFrame.add(passLabel, constraints);
		
		//Set password format
		constraints.fill = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 0, 70);
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Adding password into mainFrame
		mainFrame.add(password, constraints);
		
		//Set passLengthLabel format
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Adding passLengthLabel into mainFrame
		mainFrame.add(passLengthLabel, constraints);
		
		//set passwordLength format
		constraints.fill = GridBagConstraints.WEST;
		constraints.insets = new Insets(5, 0, 0, 220);
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Adding passwordLength into mainFrame
		mainFrame.add(passwordLength, constraints);
		
		return y;
	}
	
	protected int addCheckbox(int y, int x) {
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(10, 0, 0, 0);
		constraints.gridwidth = 2;
		
		//set conditionLabel format
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Adding conditionLabel into mainFrame
		mainFrame.add(conditionLabel, constraints);
		
		//Set and add selection format into mainFrame
		constraints.insets = new Insets(5, 0, 0, 0);
		constraints.gridx = x;
		for(int i = 0; i < selection.length; i++) {
			selection[i].setFocusable(false);
			constraints.gridy = y++;
			mainFrame.add(selection[i], constraints);
		}
		
		return y;
	}
	
	protected int addJButton(int y, int x) {
		validateButton.setFocusPainted(false);
		exitButton.setFocusPainted(false);
		
		constraints = new GridBagConstraints();
		constraints.gridwidth = 2;
		constraints.fill = GridBagConstraints.CENTER;
		constraints.insets = new Insets(5, 0, 5, 0);
		
		//Set validate format
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Add validate into mainFrame
		mainFrame.add(validateButton, constraints);
			
		//Set exitButton format
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Add exitButton into mainFrame
		mainFrame.add(exitButton, constraints);
		
		return y;
	}
	
	protected int addStatusLabel(int y, int x) {
		constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(5, 0, 5, 0);
		
		//Set passwordStatus format
		constraints.gridx = x++;
		constraints.gridy = y++;
		
		//Add passwordStatus into mainFrame
		mainFrame.add(passwordStatus, constraints);
		
		//Set errorLabel format
		constraints.gridx = x;
		
		//Add exitButton into mainFrame
		mainFrame.add(errorLabel, constraints);
		
		//Set passwordEntered format
		x = 0;
		constraints.gridwidth = 2;
		constraints.gridx = x;
		constraints.gridy = y++;
		
		//Add passwordEntered into mainFrame
		mainFrame.add(passwordEntered, constraints);
		
		return y;
	}
	
	protected void setErrorLabel(String errorMessage) {
		
		if(errorMessage.equalsIgnoreCase("")) {
			errorMessage = "none".toUpperCase();
			errorLabel.setForeground(Color.black);
		}
		else if(errorMessage.equalsIgnoreCase("valid")) {
			errorMessage = "valid".toUpperCase();
			errorLabel.setForeground(Color.green);
		}
		else
			errorLabel.setForeground(Color.red);
		
		errorLabel.setText(errorMessage);
	}
	
	protected void setpasswordLabel(String pass) {
		if(pass.equalsIgnoreCase(""))
			pass = "none".toUpperCase();
		passwordEntered.setText(passwordEntered.getText().substring(0, 11) + pass);			
	}
	
	protected void setButtonEvent() {
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("Opening Window Closing Dialog");
				
				int option = JOptionPane.showConfirmDialog(null, 
						"Exiting the Password Validator?", "Exit!", 
						JOptionPane.YES_NO_OPTION);
				
				if(option == JOptionPane.YES_OPTION) {
					System.out.println("Closing Window Closing Dialog");
					closeGUI();
				}
				
				else System.out.println("Closing Window Closing Dialog");
				
			}
			
		});
		
		validateButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				validator.reset();
				String error = "";
				setpasswordLabel(password.getText());
				
				if(password.getText().equalsIgnoreCase("")) {
					error = "Error! Please entered a password!";
					System.out.println(error);
				}
				
				else if(passwordLength.getText().equalsIgnoreCase("")) {
					error = "Error! Please entered the maximum length of the password!";
					System.out.println(error);
				}
				
				else if(!passwordLength.getText().matches("[0-9]+")) {
					error = "Error! Invalid input for Max Length";
					System.out.println(error);
				}
				
				if(!error.equalsIgnoreCase("")) {
					setErrorLabel(error);
					return;
				}
				
				String[] optionSelected = new String[selection.length];
				int selectionCount = 0;
				for(int i = 0; i < selection.length; i++) {
					if(selection[i].isSelected()) {
						optionSelected[i] = selection[i].getText();
						selectionCount++;
						continue;
					}
					
					optionSelected[i] = "";
				}
				
				if(selectionCount == 0) {
					System.out.println("Plase choose at least 1 requirement!");
					return;
				}
				
				validator.setInfo(password.getText(), optionSelected, Integer.parseInt(passwordLength.getText()));
				validator.validate();
				
				if(validator.passwordIsValid()) {
					setErrorLabel(validator.getInvalidMessage());
				}
				else {
					setErrorLabel(validator.getInvalidMessage());
				}
			}
			
		});
	}

	@Override
	protected void displayGUI() {
		System.out.println("Opening PasswordValidatorGUI");
		mainFrame.setVisible(true);
	}
	
	@Override
	protected void closeGUI() {
		System.out.println("Closing PasswordValidatorGUI");
		mainFrame.dispose();
		System.exit(0);
	}

	@Override
	protected void setFrame() {
		mainFrame.setTitle("Password Validator");
		mainFrame.setLayout(new GridBagLayout());
		mainFrame.setSize(500, 500);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setResizable(true);
		mainFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}

}
