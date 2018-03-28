package com.leetcode.list;

/**
 * 
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, 
 * find the duplicate one.

Note:
You must not modify the array (assume the array is read only).
You must use only constant, O(1) extra space.
Your runtime complexity should be less than O(n2).
There is only one duplicate number in the array, but it could be repeated more than once.
 * 
 * @author agiridhar
 *
 */
public class FindTheDuplicateNumber {
	
	public static void main(String[] args) {
		int nums[] = {3, 1, 3, 4, 2};
		int duplicate = findDuplicate(nums);
		System.out.println("Duplicate: " + duplicate);
		
		int nums1[] = {2, 2, 2, 2, 2};
		int duplicate1 = findDuplicate(nums1);
		System.out.println("Duplicate1: " + duplicate1);
		
		int nums2[] = {3, 2, 2, 2, 4};
		int duplicate2 = findDuplicate(nums2);
		System.out.println("Duplicate2: " + duplicate2);
		
		int nums3[] = {7, 9, 7, 4, 2, 8, 7, 7, 1, 5};
		int duplicate3 = findDuplicate(nums3);
		System.out.println("Duplicate3: " + duplicate3);
		
	}
	
	/* Use Linked List cycle detection algorithm.                *
	 * note, should have started from last element since that    *
	 * index will not be visited otherwise using 1-n as index    *
	 * - Credit: Tortoise & Hair algo (Don. Knuth, Floyd)        */
	public static int findDuplicate(int[] nums) {
        
		int walker = 0, runner = 0;
		
		do {
			walker = nums[walker];
			runner = nums[nums[runner]];
		} while (walker != runner);
		
		

		// Find the beginning of the loop                       
		walker = 0;
		
		while (walker != runner) {
			walker = nums[walker];
			runner = nums[runner];
		}
		
		return walker;
    }

}
