package com.leetcode.dp;

/**
 * 
 * Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity?


 * 
 * @author agiridhar
 *
 */
public class LongestIncreasingSubsequence {
	
	public static void main(String []args) {
		int [] nums = {10, 9, 2, 5, 3, 7, 101, 18};
		
		System.out.println("LIS: " + lengthOfLIS(nums));
	}
	
	public static int lengthOfLIS(int[] nums) {
		
		if (nums == null || nums.length == 0)
			return 0;
		
		int lis[] = new int[nums.length];
		
		// base case
		lis[0] = 1;
		
		if (nums.length == 1) {
			return lis[0];
		}
		
		int longest = 0;
		
		for (int i = 1; i < nums.length; i++) {
			
			lis[i] = 1;
			
			for (int j = 0; j < i; j++) {
				
				if (nums[i] > nums[j]) {
					lis[i] = Math.max(lis[i], lis[j] + 1);
				}
				
			}
			
			longest = Math.max(longest, lis[i]);
		}
		
		
		return longest;
		
		
	}
	

}
