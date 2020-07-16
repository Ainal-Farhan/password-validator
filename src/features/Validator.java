package features;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Mohd Ainal Farhan Mohamad Johari
 * 
 * Project : Password Validator
 * Date    : Jul 16, 2020
 * 
 */

public class Validator {
	private String password;
	private ArrayList<String> requirement;
	private int length;
	private boolean passwordIsValid;
	private String invalidMessage;
	
	public Validator() {
		password = "";
		requirement = new ArrayList<String>();
		length = 0;
		passwordIsValid = false;
		invalidMessage = "";
	}
	
	public void reset() {
		password = "";
		requirement = new ArrayList<String>();
		length = 0;
		passwordIsValid = false;
		invalidMessage = "";
	}
	
	public boolean passwordIsEmpty() {
		if(password.equalsIgnoreCase("")) return true;
		else return false;
	}
	
	public void setInfo(String password, String[] requirement, int length) {
		this.password = password;
		for(int i = 0; i < requirement.length; i++) {
			if(requirement[i].equalsIgnoreCase("")) continue;
			
			this.requirement.add(requirement[i]);
		}
		this.length = length;
	}
	
	public void validate() {
		if(password.length() > length) {
			invalidMessage = "The password entered is more than " + length;
			passwordIsValid = false;
			return;
		}
		
		if(passwordIsEmpty()) {
			invalidMessage = "There is no password entered";
			passwordIsValid = false;
			return;
		}
		
		boolean isValid = false;
		
		for(int i = 0; i < requirement.size(); i++) {
			if(requirement.get(i).equalsIgnoreCase("Number"))
				isValid = validateNumber();
			else if(requirement.get(i).equalsIgnoreCase("Special Character"))
				isValid = validateSpecialCharacter();
			else if(requirement.get(i).equalsIgnoreCase("Alphabet"))
				isValid = validateAlphabet();
			else {
				System.out.println(requirement.get(i)+ " >> " + i + " >> invalid");
				break;
			}
			
			if(!isValid)
				break;
		}
		
		passwordIsValid = isValid;
	}
	
	public boolean passwordIsValid() {
		if(passwordIsEmpty()) {
			System.out.println("There is no password entered yet!");
			return false;
		}
		
		return passwordIsValid;
			
	}
	
	public String getInvalidMessage() {
		if(passwordIsValid)	return "Valid";
		
		return invalidMessage;
	}
	
	private boolean validateNumber() {
		if(password.matches(".*\\d.*")) {
			return true;
		}
		
		invalidMessage = "There is no number entered";
		return false;
	}
	
	private boolean validateSpecialCharacter() {
		Pattern pattern = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(password);
		
		if(matcher.find()) {
			return true;
		}
		
		invalidMessage = "There is no special character entered";
		return false;
	}
	
	private boolean validateAlphabet() {
		if(password.matches(".*[a-zA-Z]+.*")) { return true;
		}
		
		invalidMessage = "There is no alphabet entered";
		
		return false;
	}
}
