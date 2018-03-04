package com.leetcode.string;



/**
 * 
 * https://leetcode.com/problems/reverse-words-in-a-string/description/
 * 
 * @author agiridhar
 *
 */
public class ReverseWords {
	
	public static void main (String [] args) {
		
		System.out.println("Reversed Words : " + reverseWords("   a   b "));
		
	}
	
	public static String reverseWords(String s) {
        
		if (s == null || s.length() == 0) {
			return s;
		}
		
		String[] wordArray = s.trim().split("\\s+");
		
		String[] reversedWordArray = new String[wordArray.length];
		
		for (int i=0; i< wordArray.length; i++) {
			
			reversedWordArray[wordArray.length - 1 - i] = wordArray[i];
			
		}
		
		return String.join(" ", reversedWordArray).trim();
		
    }

}
