package com.leetcode.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 
 * Problem : https://leetcode.com/problems/sort-characters-by-frequency/description/
 * 
 * @author agiridhar
 *
 */
public class FrequencyOfCharactersSort {
	
	public static void main (String [] args) {
		System.out.println("Frequency of Characters Sorted : " + frequencySort("tree"));
	}
	
	public static String frequencySort(String s) {
        
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		
		for (char c : s.toCharArray()) {
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		
		// Bucket sort
		List<Character> [] bucket = new List[s.length() + 1];
		
		
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			int freq = entry.getValue();
			
			if (bucket[freq] == null) {
				bucket[freq] = new ArrayList<Character>();
			}
			
			bucket[freq].add(entry.getKey());
		}
		
		StringBuilder sb = new StringBuilder();
		
		for (int pos=bucket.length-1; pos>=0; pos--) {
			if (bucket[pos] != null) {
				
				for (char c : bucket[pos]) {
					for (int i=0; i<map.get(c); i++) {
						sb.append(c);
					}
				}
			}
		}
		
		return sb.toString();
    }
	
}
