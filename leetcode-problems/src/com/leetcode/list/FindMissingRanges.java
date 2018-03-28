package com.leetcode.list;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array where the range of elements are
 * [lower, upper] inclusive, return its missing ranges.
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * return ["2", "4->49", "51->74", "76->99"].
 */

/**
 * Iterate over all numbers, foreach number create lo, high  *
 * points. If lo=high, push 1 number, else, push range       *
 * @param:                                                   *
 *  nums  - input numbers whose inbetween ranges we need     *
 *  lower - lower number which should be <= nums[0]          *
 *  upper - higher number which should be >= nums[n]         *
 * @returns: a vector of strings of missing ranges           *
 * Time Complexity = O(n),  Space Complexity= O(1)           */
public class FindMissingRanges {
	
	public static void main(String []args) {
		int []nums = {0, 1, 3, 50, 75};
		
		List<String> missingRanges = findMissingRanges(nums, 0, 99);
		
		for (String range : missingRanges) {
			System.out.println(range);
		}
	}
	
	public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
		
		List<String> result = new ArrayList<String>();
		
		int lo = 0, hi = 0;
		
		for (int i = 0; i <= nums.length; i++) {
			
			if (nums.length == 0) {
				lo = lower;
				hi = upper;
			} else if (i == 0) {
				lo = lower;
				hi = nums[i] - 1;
			} else if (i == nums.length) {
				lo = nums[i-1] + 1;
				hi = upper;
			} else {
				lo = nums[i-1] + 1;
				hi = nums[i] - 1;
			}
			
			if (lo == hi) {
				result.add(String.valueOf(lo));
			} else if (lo < hi) {
				result.add(String.valueOf(lo) + "->" + String.valueOf(hi));
			}
		}
		
		
		return result;
	}

	
	
	
	
}
