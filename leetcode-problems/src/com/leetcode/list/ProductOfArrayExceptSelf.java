package com.leetcode.list;

/**
 * Given an array of n integers where n > 1, nums, return an array output such
 * that output[i] is equal to the product of all the elements of nums except nums[i].
 * Solve it without division and in O(n).
 * For example, given [1,2,3,4], return [24,12,8,6].
 * Follow up:
 * Could you solve it with constant space complexity? (Note: The output array does not
 * count as extra space for the purpose of space complexity analysis.)
 */

public class ProductOfArrayExceptSelf {
	
	public static void main(String []args) {
		int [] nums = {3,4,5,6};
		
//		int[] result = productExceptSelfWithDivision(nums);
		int[] result = productExceptSelf(nums);
		
		for (int n : result) {
			System.out.println(n);
		}
		
	}
	
	public static int[] productExceptSelf(int[] nums) {
		int[] result = new int[nums.length];
		
		result[0] = 1;
		
		for (int i = 1; i < nums.length; i++) {
			result[i] = result[i-1] * nums[i-1];
		}
		int right = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			result[i] *= right;
			right *= nums[i];
		}
		
		return result;
	}
	
	public static int[] productExceptSelfWithDivision(int[] nums) {
        int[] result = new int[nums.length];
        
        int total = 1;
        for (int i = 0; i < nums.length; i++) {
        		total *= nums[i];
        }
        
		for (int i = 0; i < nums.length; i++) {
			result[i] = total/nums[i];
        	
        }
		return result;
    }
}
