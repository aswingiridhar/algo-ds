package com.leetcode.list;

/**
 * 
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

	For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.

 * 
 * @author agiridhar
 *
 */
public class MoveZeroes {
	
	public static void main(String []args) {
		int nums[] = {0,1,2,0,1,2};
		
		moveZeroes(nums, 0);
		
		for (int num : nums) {
			System.out.println(num);
		}
	}
	
	public static void moveZeroes(int[] nums, int deleteElement) {
        
		if (nums == null || nums.length == 0)
			return;
		
		int index = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != deleteElement) {
				nums[index] = nums[i];
				index++;
			}
		}
		
		while (index < nums.length) {
			nums[index] = deleteElement;
			index++;
		}
		
    }

}
