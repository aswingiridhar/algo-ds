package com.leetcode.dp;

/**
 * 
 * @author agiridhar
 *
 */
public class ZigZagSubsequence {
	
	public static void main(String []args) {
		
		
		
		int []nums = {10, 8, 5, 4, 20, 30, 50, 1}; // expect 4
		
		System.out.println("Zig zag subsequence: " + longestZigZagSubsequence(nums));
		
		int []nums1 = {10, 8, 5, 4}; // expect 2
		
		System.out.println("Zig zag subsequence: " + longestZigZagSubsequence(nums1));
		
	}
	
	public static int longestZigZagSubsequence(int [] nums) {
		
		if (nums == null || nums.length == 0) return 0;
		
		// base case
		if (nums.length == 1) return 1;
		
		int up[] = new int [nums.length];
		int down[] = new int [nums.length];
		
		up[0] = 1;
		down[0] = 1;
		
		int longest = 0;
		
		for (int i = 1; i < nums.length; i++) {
			
			up[i] = 1;
			down[i] = 1;
			
			for (int j = 0; j < i; j++) {
				
				if (nums[i] > nums[j]) {
					up[i] = Math.max(up[i], down[j] + 1);
				} else {
					down[i] = Math.max(down[i], up[j] + 1);
				}
			}
			
			longest = Math.max(longest, Math.max(up[i], down[i]));
		}
		
		
		return longest;
	}

}
