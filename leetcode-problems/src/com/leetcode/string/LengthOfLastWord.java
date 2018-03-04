package com.leetcode.string;

/**
 * 
 * Problem : https://leetcode.com/problems/length-of-last-word/description/
 * 
 * @author agiridhar
 *
 */
public class LengthOfLastWord {
	
	public static void main(String[] args) {

		System.out.println("Length of Last word : " + lengthOfLastWord("Hello World"));

	}
	
	public static int lengthOfLastWord(String s) {
        s = s.trim();
		if (s == null || s.length() == 0) {
			return 0;
		}
		
		int lastWordLength = 0;
		
		String[] strArray = s.split(" ");
		
		lastWordLength = strArray[strArray.length - 1].toCharArray().length;
		
		return lastWordLength;
    }

}
