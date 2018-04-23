package com.leetcode.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4].
 * Return its length: 4.
 * Note: Your algorithm should run in O(n) complexity.
 */
public class LongestConsecutiveSequence {
	
	public static void main(String []args) {
		
		int []nums = {100, 4, 200, 1, 3, 2};
		
		System.out.println("Longest Consecutive: " + longestConsecutiveUsingMap(nums));
		
		int []nums1 = {1, 2, 0, 1};
		
		System.out.println("Longest Consecutive: " + longestConsecutiveUsingMap(nums1));
		
		
	}
	
	public static int longestConsecutiveUsingMap(int[] nums) {
		
		int max = 0;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int num : nums) {
			
			if (map.containsKey(num))
				continue;
			
			// 1.Find left and right num
			int left = map.getOrDefault(num - 1, 0);
			int right = map.getOrDefault(num + 1, 0);
			
			int sum = left + right + 1;
			
			max = Math.max(sum, max);
			
			// 2.Union by only updating boundary
            // Leave middle k-v dirty to avoid cascading update
			if (left > 0) map.put(num - left, sum);
			if (right > 0) map.put(num + right, sum);
			
			map.put(num, sum);
		}
		
		return max;
	}
	
	public static int longestConsecutive(int[] nums) {
		
		if (nums == null || nums.length == 0)
			return 0;
		
		int longestCons = 1, max = 1;
		
		Arrays.sort(nums);
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1]) {
				continue;
			} else if (nums[i] == nums[i-1] + 1) {
				max++;
			} else {
				longestCons = Math.max(longestCons, max);
				max = 1;
			}
		}
		
		longestCons = Math.max(longestCons, max);
		
		return longestCons;
    }
}
