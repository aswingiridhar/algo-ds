package com.leetcode.list;

/**
 * 
 * 	https://leetcode.com/problems/sort-colors/description/
 * 
 * @author agiridhar
 *
 */
public class SortColors {
	
	public static void main(String []args) {
		
		int nums[] = {0,1,2,0,1,2};
		
		sortColors(nums);
		
		for (int num : nums) {
			System.out.println(num);
		}
		
		
	}
	
	/* Simple two-pointer approach to sort list into 3 buckets   *
	 * Treat left and right as mere container end-points. Iterate with*
	 * index and whenever there is a match, push to container        *
	 * Note: very similar to ds_list_remove_element.cc           *
	 * Time complexity = O(n)     Space complexity = O(1)        */
	public static void sortColors(int[] nums) {
        
		if (nums == null || nums.length < 2) return;
		
		int left = 0, right = nums.length - 1, index = 0;
		
		for (index = left; index <= right;) {
			
			if (nums[index] == 0 && index > left) {
				int temp = nums[index];
				nums[index] = nums[left];
				nums[left] = temp;
				left++;
			} else if (nums[index] == 2 && index < right) {
				int temp = nums[index];
				nums[index] = nums[right];
				nums[right] = temp;
				right--;
			} else {
				index++;
			}
			
		}
		
    }

}
