package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Problem : https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
 * 
 * @author agiridhar
 *
 */
public class SlidingWindow_FindAllAnagrams {
	
	public static void main (String [] args) {
		
		System.out.println("Anagrams index : " + findAnagrams("cbaebabacd", "abc").toString());
		System.out.println("Anagrams index using map : " + findAnagramsMap("baa", "aa").toString());
		System.out.println("Anagrams index Optimized : " + findAnagramsOptimized("cbaebabacd", "abc").toString());
		
	}
	
	public static List<Integer> findAnagramsMap (String s, String p) {
		List<Integer> startIndices = new ArrayList<Integer>();
		
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : p.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		int left = 0, right = 0, count = map.size();
		
		while (right < s.length()) {
			
			if (map.containsKey(s.charAt(right))) {
				// do this so that duplicates will not be considered
				map.put(s.charAt(right), map.get(s.charAt(right))-1);
				
				if (map.get(s.charAt(right)) == 0) {
					count--;
				}
			}
			
			right++;
			
			// if count is 0, we found the anagram
			
			while (count == 0) {
				char tempc = s.charAt(left);
				if (map.containsKey(tempc)) {
					map.put(tempc, map.get(tempc)+1);
					
					if (map.get(tempc) > 0) {
						count++;
					}
				}
				
				if (right - left == p.length()) {
					startIndices.add(left);
				}
				
				left++;
				
			}
			
		}
		
		return startIndices;
	}
	
	public static List<Integer> findAnagramsOptimized (String s, String p) {
		List<Integer> startIndices = new ArrayList<Integer>();
		
		int mapArray[] = new int[256];
		
		for (char c : p.toCharArray()) {
			mapArray[c]++;
		}
		
		int left = 0, right = 0, count = p.length();
		
		while (right < s.length()) {
			
			
			if (mapArray[s.charAt(right)] >= 1) {
				count--;
			}
			// do this so that duplicates will not be considered
			mapArray[s.charAt(right)]--;
			right++;
			
			// if count is 0, we found the anagram
			if (count == 0) {
				startIndices.add(left);
			}
			
			System.out.println("Window between " + left + " and " + right + " has count : " + count);
			
			if (right - left == p.length()) {
				
				// remove the first element of the previous window
				if (mapArray[s.charAt(left)] >= 0) {
					count++;
				}
				mapArray[s.charAt(left)]++;
				left++;
			}
		}
		
		return startIndices;
	}
	
	public static List<Integer> findAnagrams(String s, String p) {
		
		List<Integer> startIndices = new ArrayList<Integer>();
		
		if (s == null || p == null || s.length() < p.length()) {
			return startIndices;
		}
		
		for (int i=0; i<=s.length()-p.length(); i++) {
			String substr = s.substring(i, i + p.length());
			
			if (isAnagram(p, substr)) {
				startIndices.add(i);
			}
			
		}
		
		return startIndices;
		
    }
	
	private static boolean isAnagram(String s1, String s2) {
		
		if (s1 == null || s2 == null || s1.length() != s2.length()) {
			return false;
		}
		
		Map<Character, Integer> occurencesCharactersMap = new HashMap<Character, Integer>();
		
		for (int i=0; i<s1.length(); i++) {
			int leftCount = 1;
			if (occurencesCharactersMap.containsKey(s1.charAt(i))) {
				leftCount += occurencesCharactersMap.get(s1.charAt(i));
			}
			occurencesCharactersMap.put(s1.charAt(i), leftCount);
			
			int rightCount = -1;
			if (occurencesCharactersMap.containsKey(s2.charAt(i))) {
				rightCount += occurencesCharactersMap.get(s2.charAt(i));
			}
			occurencesCharactersMap.put(s2.charAt(i), rightCount);
		}
		
		for (Character c : occurencesCharactersMap.keySet()) {
			if (occurencesCharactersMap.get(c) != 0) {
				return false;
			}
		}
		
		return true;
		
	}

}
