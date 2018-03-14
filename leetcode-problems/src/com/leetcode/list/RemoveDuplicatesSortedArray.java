package com.leetcode.list;

/**
 * 
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
 * 
 * @author agiridhar
 *
 */
public class RemoveDuplicatesSortedArray {
	
	public static void main(String []args) {
		int [] nums = {1,1,2,2,3,3};
		
		System.out.println("removeDuplicates: " + removeDuplicates(nums));
	}
	
	public static int removeDuplicates(int[] nums) {
        
		if (nums == null || nums.length == 0) 
			return 0;
		
		if (nums.length < 2) return nums.length;
		
		int index = 1;
		
		// increment the index only if the prev element and current element is different
		
		for (int i=1;i<nums.length;i++) {
			
			if (nums[i] != nums[i-1]) {
				nums[index++] = nums[i]; 
			} 
			
		}
		
		return index;
    }
	

}
