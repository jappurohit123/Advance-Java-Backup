package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationClass {
	// request.getParameter("")
	@SuppressWarnings("null")
	public static boolean textValidation(String input) {
		// blank " a   " 
		// null
		if(input==null || input.trim().length()==0) {
	//		System.out.println("Return true");
			return true;
		}
		//System.out.println("Return false");
		return false;
	}
	public static  int numberIntValidation(String input) {
		// input -> character
		// number
		// blank
		// "abc"
		// if (num==-1)
		// 
		int num=-1;
		try {
			// Integer.parseInt -> String to Int
			num = Integer.parseInt(input);	
		}
		catch(Exception e) {
			
		}
		return num;
	}
	public static float numberFloatValidation(String input) {
		float num = -1.0f;
		// Float.parseFloat -> String to Float
		// User negative
		try {
			num = Float.parseFloat(input);
			if(num<0) {
				num = -2;
			}
		}catch(Exception e) {
			
		}
		return num;
	}
	public static boolean passwordValidation(String input) {
		if(!ValidationClass.textValidation(input)) {
			// length [8]
			// 1 upper case
			// 1 lower case
			// 1 special character
			// 1 number 	
			String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$+&]).{8,20}$";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(input);
			return m.matches();
		}
		else {
			return false;
		}
	}
	public static void main(String[] args) {
		//System.out.println(Float.parseFloat("-1.2"));
		//Float.parseFloat("")
		//Regex -> 
		System.out.println(passwordValidation("     "));
		System.out.println(passwordValidation("A"));
		System.out.println(passwordValidation("AcFEGHI"));
		System.out.println(passwordValidation("abcE@1fghi"));
	}
}
