package com.leetcode.list;
/**
 * 	https://leetcode.com/problems/first-missing-positive/
 * 
 * Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space.
 * 
 *  @author agiridhar
 *
 */
public class FindMissingPositive {
	
	public static void main(String []args) {
		
		int nums[] = {1,2,0};
		int nums2[] = {3,4,-1,1};
		
		System.out.println("Find Missing Positive :" + firstMissingPositive(nums));
		System.out.println("Find Missing Positive :" + firstMissingPositive(nums2));
	}
	
	public static int firstMissingPositive(int[] nums) {
        
		int n = nums.length;
		
		for (int i = 0; i < n; i++) {
			while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		
		for (int i = 0; i < n; i++) {
			if (nums[i] != i + 1) {
				return i+1;
			}
		}
		
		return n + 1;
    }

}
