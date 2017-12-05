package com.leetcode.string;


/**
 * 
 * https://leetcode.com/problems/reverse-string/description/
 * 
 * @author hariniaswin
 *
 */
public class ReverseString {
	
	public static void main (String [] args) {
		
		System.out.println("Reversed String : " + reverseString("hello"));
		
	}
	
	public static String reverseString(String s) {
        
		if (s == null || s.length() == 0) {
			return s;
		}
		
		char[] reversedString = new char[s.length()];
		
		for (int i=0;i<=s.length()-1;i++) {
			
			reversedString[s.length() - 1 - i] = s.charAt(i);
			
		}
		
		return String.valueOf(reversedString);
		
    }

}
