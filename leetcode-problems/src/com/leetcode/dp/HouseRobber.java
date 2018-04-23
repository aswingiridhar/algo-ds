package com.leetcode.dp;

/**
 * 
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security system
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of
 * each house, determine the maximum amount of money you can rob tonight without
 * alerting the police.
 * 
 * @author agiridhar
 *
 */
public class HouseRobber {
	
	public static void main(String []args) {
		
		int nums[] = {100, 50, 60, 400, 20, 80}; // expect 580
		
		System.out.println("Max Money robbed: " + rob(nums));
		
	}
	
	public static int rob(int[] nums) {
        
		if (nums == null || nums.length == 0) return 0;
		
		if (nums.length == 1) return nums[0];
		
		int a = 0, b = 0;
		
		
		for (int i = 0; i < nums.length; i++) {
			
			if (i%2 == 0) {
				a = Math.max(a + nums[i], b);
			} else {
				b = Math.max(a, nums[i] + b);
			}
			
		}
		
		return Math.max(a, b);
    }

}
