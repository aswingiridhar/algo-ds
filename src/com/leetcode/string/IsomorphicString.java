package com.leetcode.string;

import java.util.HashMap;

/**
 * 
 * Problem : https://leetcode.com/problems/isomorphic-strings/description/
 * 
 * @author hariniaswin
 *
 */
public class IsomorphicString {

	public static void main(String[] args) {

		System.out.println("Is Isomorphic : " + isIsomorphic("ba", "aa"));

	}

	private static boolean isIsomorphic(String s, String t) {

		if (s == null || t == null || s.length() != t.length()) {
			return false;
		}

		HashMap<Character, Character> map = new HashMap<Character, Character>();

		for (int i = 0; i < t.length(); i++) {

			char c1 = s.charAt(i);
			char c2 = t.charAt(i);

			if (map.containsKey(c1)) {
				// key exists for c1 and value not same as c2, exit
				if (map.get(c1) != c2) {
					return false;
				}
			} else {
				// c2 already mapped and no key exists, exit
				if (map.containsValue(c2)) {
					return false;
				}
				map.put(c1, c2);
			}

		}

		return true;

	}

}
