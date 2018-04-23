package com.leetcode.dp;

/**
 * 
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

For example, given the array [2,3,-2,4],
the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author agiridhar
 *
 */
public class MaxSubarrayProduct {
	
	public static void main(String[]args) {
		
		int []nums = {2,3,-2,4}; 
		
		System.out.println("Max Subarray Product: " + maxSubArray_DP(nums)); // expect 6
		
	}
	
	
	public static int maxSubArray_DP(int[] nums) {
		
		if (nums.length == 0) return 0;
		
		int r = nums[0];
		
		for (int i = 1, imin = r, imax = r; i < nums.length; i++) {
			
			if (nums[i] < 0) {
				int temp = imax;
				imax = imin;
				imin = temp;
			}
			
			imax = Math.max(nums[i], imax * nums[i]);
			imin = Math.min(nums[i], imin * nums[i]);
			
			r = Math.max(r, imax);
		}
		
		return r;
	}
}
