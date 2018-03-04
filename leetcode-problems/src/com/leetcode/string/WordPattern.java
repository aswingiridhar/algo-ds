package com.leetcode.string;

import java.util.HashMap;

/**
 * 
 * Problem : https://leetcode.com/problems/word-pattern/description/
 * 
 * @author agiridhar
 *
 */
public class WordPattern {
	
	public static void main(String[] args) {

		System.out.println("Is Word Pattern : " + wordPattern("abba", "dog dog dog dog"));

	}

	private static boolean wordPattern(String pattern, String str) {
		
		String[] strArray = str.split(" ");
		
		if (pattern == null || str == null || pattern.length() != strArray.length) {
			return false;
		}

		HashMap<Character, String> map = new HashMap<Character, String>();

		for (int i = 0; i < pattern.length(); i++) {

			char key = pattern.charAt(i);
			String value = strArray[i];

			if (map.containsKey(key)) {
				// key exists for c1 and value not same as c2, exit
				if (!map.get(key).equalsIgnoreCase(value)) {
					return false;
				}
			} else {
				if (map.containsValue(value)) {
					return false;
				}
				map.put(key, value);
			}

		}

		return true;

	}

}
