package com.leetcode.list;

/**
 * 
 * https://leetcode.com/problems/remove-element/description/
 * 
 * @author agiridhar
 *
 */
public class RemoveElement {
	
	public static void main(String []args) {
		int [] nums = {2};
		int val = 2;
		
		System.out.println("removeDuplicates: " + removeElement(nums, val));
	}
	
	public static int removeElement(int[] nums, int val) {
        
		if (nums == null || nums.length == 0) return 0;
		
		int index = 0;
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != val) {
				nums[index++] = nums[i];
			}
		}
		
		return index;
    }
	

}
