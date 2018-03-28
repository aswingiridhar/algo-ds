package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array nums and a target value k, find the maximum length
 * of a subarray that sums to k. If there isn't one, return 0 instead.
 * Note:
 * The sum of the entire nums array is guaranteed to fit within the
 * 32-bit signed integer range.
 * Example 1: Given nums = [1, -1, 5, -2, 3], k = 3,
 * Return 4. ([1, -1, 5, -2] is the longest subarray that sums to 3)
 * Example 2: Given nums = [-2, -1, 2, 1], k = 1,
 * Return 2. ([-1, 2] is the longest subarray that sums to 1)
 * Follow Up: Can you do it in O(n) time?
 */

public class MaximumSizeSubarraySum {
	
	public static void main(String [] args) {
		int [] nums = {1, -1, 5, -2, 3};
		int [] nums2 = {-2, -1, 2, 1};
		
		System.out.println("Minimum Size Sub Array Sum Length : " + maxSubArrayLen(3, nums));
		System.out.println("Minimum Size Sub Array Sum Length : " + maxSubArrayLen(1, nums2));
	}
	
	public static int maxSubArrayLen(int k, int[] nums) {
		
		int sum = 0, max = Integer.MIN_VALUE;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
			
			if (sum == k) {
				max = Math.max(max, i+1);
			}
			
			int diff = sum-k;
			 
	        if(map.containsKey(diff)){
	            max = Math.max(max, i-map.get(diff));
	        }
	 
	        if(!map.containsKey(sum)){
	            map.put(sum, i);
	        }
		}
        
		return max == Integer.MIN_VALUE ? 0 : max;
	}
}
