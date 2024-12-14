package com.library.util;

import java.util.regex.Pattern;

public class InputValidator {
	public static boolean validateBookId(int bookId) {
		return bookId > 0;
	}
	
	public static boolean validateUserId(int user_id) {
		return user_id > 0;
	}
	
	public static boolean validateDate(String date) {
		String pattern="^\\d{4}-\\d{2}-\\d{2}$";
		return Pattern.matches(date, pattern);
	}
	
	public static boolean isNotEmpty(String input) {
		return input != null && !input.trim().isEmpty();
	}
	
	public static boolean isPositiveInteger(String input) {
		try{
			int value=Integer.parseInt(input);
			return value > 0 ;
		}catch(Exception e) {
			return false;
		}
	}
}
