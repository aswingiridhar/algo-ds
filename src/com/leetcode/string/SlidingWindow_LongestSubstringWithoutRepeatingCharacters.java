package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem : https://leetcode.com/problems/longest-repeating-character-replacement/description/
 * 
 * @author hariniaswin
 *
 */
public class SlidingWindow_LongestSubstringWithoutRepeatingCharacters {
	
	public static void main (String [] args) {
		System.out.println("Length of Longest Substring : " + lengthOfLongestSubstring("abcabcbb"));
	}
	
	private static int lengthOfLongestSubstring(String s) {
		
		int left = 0, right = 0, counter = 0, d = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		while (right < s.length()) {
			
			char c = s.charAt(right);
			
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if (map.get(c) > 1) {
				counter++;
			}
			right++;
			
			while (counter > 0) {
				
				char tempc = s.charAt(left);
				
				if (map.containsKey(tempc) && map.get(tempc) > 1) {
					counter--;
				}
				map.put(tempc, map.get(tempc) - 1);
				left++;
			}
			
			d = Math.max(right - left, d);
		}
		
		
		return d;
	}

}
