package com.leetcode.string;

/**
 * 
 * Problem : https://leetcode.com/problems/valid-palindrome/description/
 * 
 * @author agiridhar
 *
 */
public class ValidPalindrome {

	public static void main(String[] args) {

		String input = "aA";

		System.out.println("is " + input + " a valid palindrome : "
				+ isPalindrome(input));

	}

	public static boolean isPalindrome(String s) {
		
		if (s != null) {
			s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		}
		
		int i = 0;
		int j = s.length() - 1;

		while (i < j) {

			if (s.charAt(i) != s.charAt(j)) {
				return false;
			} else {
				i++;
				j--;
			}
		}

		return true;

	}

}
