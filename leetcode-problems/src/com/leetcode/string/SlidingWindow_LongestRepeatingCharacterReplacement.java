package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;


public class SlidingWindow_LongestRepeatingCharacterReplacement {
	
	public static void main (String [] args) {
		System.out.println("Length of Repeating Character Replacement: " + characterReplacement("abcabcbb", 2));
	}
	
	private static int characterReplacement(String s, int k) {
		
		int left = 0, right = 0, counter = 0, res = 0;
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		while (right < s.length()) {
			
			char c = s.charAt(right);
			
			map.put(c, map.getOrDefault(c, 0) + 1);
			
			if (counter < map.get(c)) {
				counter = map.get(c);
			}
			
			right++;
			
			while (right - left - counter > k) {
				
				char tempc = s.charAt(left);
				
				map.put(tempc, map.get(tempc) - 1);
				
				counter = getMax(map);
				
				left++;
			}
			
			res = Math.max(res, right - left);
		}
		
		return res;
	}
	
	private static int getMax(Map<Character, Integer> map) {
		int max = 0;
		for(int freq : map.values()) {
			max = Math.max(max, freq);
		}
		return max;
    }

}
