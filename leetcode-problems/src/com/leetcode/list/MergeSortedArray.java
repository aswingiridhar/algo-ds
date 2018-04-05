package com.leetcode.list;

/**
 * 
 * https://leetcode.com/problems/merge-sorted-array/description/
 * 
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space (size that is greater or equal to m + n) 
to hold additional elements from nums2. The number of elements initialized in nums1 and nums2 
are m and n respectively.
 * 
 * @author agiridhar
 *
 */
public class MergeSortedArray {
	
	public static void main(String []args) {
		int []nums1 = {1, 3, 5, 7, 9, 0, 0, 0, 0, 0};
		
		int []nums2 = {2, 4, 6, 8, 10};
		
		merge(nums1, 5, nums2, nums2.length);
		
		for (int n : nums1) {
			System.out.println(n);
		}
		
	}
	
	/* Since num1 is larger array and it has enough space to hold*
	 * all elements from num2, start filling from end of num1    *
	 * Time Complexity = O(n+m), Space Complexity = O(1)         */
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
		int i = m-1, j = n-1, k = m+n-1;
		
		while (i >= 0 && j >= 0) {
			
			if (nums1[i] > nums2[j]) {
				nums1[k--] = nums1[i--];
			} else {
				nums1[k--] = nums2[j--]; 
			}
			
		}
		while (j >= 0) {
			nums1[k--] = nums2[j--];
		}
		
    }

}
