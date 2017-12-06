package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/accounts/login/?next=/problems/palindrome-permutation/
 * 
 * Given a string, determine if a permutation of the string  *
 * could form a palindrome.                                  *
 * For example:                                              *
 * "code" -> False, "aab" -> True, "carerac" -> True.
 * 
 * @author agiridhar
 *        
 */
public class PalindromePermutation {
	
	public static void main (String [] args) {
		System.out.println("Can Permute Palindrome : " + canPermutePalindrome("abba"));
	}
	
	/**
	 * 
	 * If a string with an even length is a palindrome, 
	 * every character in the string must always occur an even number of times. 
	 * If the string with an odd length is a palindrome, every character except one 
	 * of the characters must always occur an even number of times. 
	 * Thus, in case of a palindrome, the number of characters with odd number of occurences 
	 * can't exceed 1(1 in case of odd length and 0 in case of even length).
	 * 
	 * @param s
	 * 
	 * @return boolean
	 */
	private static boolean canPermutePalindrome(String s) {
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int count = 0;
		for (char key  : map.keySet()) {
			count += (map.get(key) % 2);
		}
		return count <= 1;
	}
	
}
