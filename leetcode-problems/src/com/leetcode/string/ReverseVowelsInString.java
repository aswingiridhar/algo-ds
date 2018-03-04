package com.leetcode.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/reverse-vowels-of-a-string/description/
 * 
 * @author agiridhar
 *
 */
public class ReverseVowelsInString {
	
	public static void main (String [] args) {
		
		System.out.println("Reversed Vowels in a String : " + reverseVowels("hello"));
		
	}
	
	public static String reverseVowels(String s) {
        
		if (s == null || s.length() == 0) {
			return s;
		}
		
		Set<Character> vowels = new HashSet<>(Arrays.asList(new Character[]{'a','e','i','o','u','A','E','I','O','U'}));

		char[] stringArray = s.toCharArray();
		
		int start = 0, end = s.length() - 1;
		
		while (start < end) {
			
			while (start < end && !vowels.contains(stringArray[start])) {
				start++;
			}
			
			while (start < end && !vowels.contains(stringArray[end])) {
				end--;
			}
			
			char temp = stringArray[start];
			
			stringArray[start] = stringArray[end];
			stringArray[end] = temp;
			
			start++;end--;
			
		}
		
		return String.valueOf(stringArray);
		
    }
	

}
