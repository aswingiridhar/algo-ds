package com.leetcode.list;

/**
 * 
 * Given an array of n positive integers and a positive integer s, 
 * find the minimal length of a contiguous subarray of which the sum ≥ s. 
 * If there isn't one, return 0 instead.
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 * 
 * @author agiridhar
 *
 */
public class MinimumSizeSubarraySum {
	
	public static void main(String [] args) {
		int [] nums = {2,3,1,2,4,3};
		int s = 7;
		
		System.out.println("Minimum Size Sub Array Sum Length : " + minSubArrayLen(s, nums));
	}
	
	public static int minSubArrayLen(int s, int[] nums) {
        
		if (nums == null || nums.length == 0)
			return 0;
		
		int index = 0, sum = 0, min = Integer.MAX_VALUE;
		
		for (int i = 0; i < nums.length; i++) {
			
			sum += nums[i];
			
			while (sum >= s) {
				min = Math.min(min, i - index + 1);
				sum -= nums[index];
				index++;
			}
			
		}
		
		return min == Integer.MAX_VALUE ? 0 : min;
    }
	

}
