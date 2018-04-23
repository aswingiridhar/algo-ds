package com.leetcode.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together.
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 * [ ["ate", "eat","tea"],
 *   ["nat","tan"],
 *   ["bat"] ]
 * Note: All inputs will be in lower-case.
 */


/** @brief: Use a hash-table to store each group of anagrams.*
 * The key to hash-table must be unique for all members of   *
 * the group. Use sorted string as the key.                  */
public class GroupAnagrams {
	
	public static void main(String []args) {
		
		String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};		
		System.out.println(groupAnagrams(input));
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		List<List<String>> result = new ArrayList<List<String>>();
		
		Map<String, List<String>> map = new HashMap<String, List<String>>();
		
		for (String s : strs) {
			char[] key = s.toCharArray();
			Arrays.sort(key);
			
			if (map.containsKey(String.valueOf(key))) {
				List<String> values = map.get(String.valueOf(key));
				values.add(s);
				map.put(String.valueOf(key), values);
			} else {
				List<String> values = new ArrayList<String>();
				values.add(s);
				map.put(String.valueOf(key), values);
			}
		}
		
		for (Map.Entry<String, List<String>> entry : map.entrySet()) {
			result.add(entry.getValue());
		}
		
		return result;
	}

}
