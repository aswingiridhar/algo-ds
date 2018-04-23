package com.leetcode.sort;

import java.util.Arrays;

public class KthLargestElement {
	
	public static void main(String []args) {
		int [] nums = {3,2,1,5,6,4};
		
		System.out.println("kth largest element: " + findKthLargest(nums, 2));
	}
	
	
	public static int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
        		return -1;
        }
        
        Arrays.sort(nums);
        
        return nums[nums.length - k];
        
    }
}
