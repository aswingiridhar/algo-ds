package com.leetcode.dp;

/**
 * 
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

 * 
 * @author agiridhar
 *
 */
public class MaxSubarraySum {
	
	public static void main(String[]args) {
		
		int []nums = {-2,1,-3,4,-1,2,1,-5,4}; 
		
		System.out.println("Max Subarray Sum: " + maxSubArray_DP(nums)); // expect 6
		
		int [] nums1 = {4,-1,2,1};
		
		System.out.println("Max Subarray Sum: " + maxSubArray_DP(nums1)); // expect 6
	}
	
	public static int maxSubArray(int[] nums) {
		
		int maxSoFar = nums[0], maxEndingHere = nums[0];
		
		for (int i = 1; i < nums.length; i++) {
			maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
			maxSoFar = Math.max(maxSoFar, maxEndingHere);
		}
		
		return maxSoFar;
	}
	
	public static int maxSubArray_DP(int[] nums) {
		
		if (nums.length == 0) return 0;
		
		int []result = new int[nums.length];
		
		result[0] = nums[0];
		
		int max = result[0];
		
		for (int i = 1; i < nums.length; i++) {
			result[i] = nums[i] + (result[i-1] > 0 ? result[i-1] : 0);
			
			max = Math.max(result[i], max);
		}
		
		return max;
	}
}
