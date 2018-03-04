package com.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * Problem : https://leetcode.com/problems/minimum-window-substring/description/
 * 
 * @author agiridhar
 *
 */
public class SlidingWindow_MinimumWindowSubstring {
	
	public static void main (String [] args) {
		
		System.out.println("Minimum Window Substring : " + minimumWindowSubstring("babbaa", "ab").toString());
		
	}
	
	public static String minimumWindowSubstring (String s, String t) {
		
		String result = "";
		
		if (s.length() < t.length()) {
			return result;
		}
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : t.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0, counter = map.size(), head = 0, d = Integer.MAX_VALUE;
		
		while (right < s.length()) {
			
			if (map.containsKey(s.charAt(right))) {
				map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
				
				if (map.get(s.charAt(right)) == 0) {
					counter--;
				}
			}
			
			right++;
			
			while (counter == 0) {
				
				char tempc = s.charAt(left);
				
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc) + 1);
					
					if (map.get(tempc) > 0) {
						counter++;
					}
				}
				
				if (right - left < d) {
					head = left;
					d = right - left;
				}
				left++;
			}
			
		}
		
		if (d < Integer.MAX_VALUE) {
			result = s.substring(head, head+d);
		}
		
		return result;
	}

}
