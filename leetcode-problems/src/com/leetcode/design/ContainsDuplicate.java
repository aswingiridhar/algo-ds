package com.leetcode.design;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * https://leetcode.com/problems/contains-duplicate/description/
 * 
 * Given an array of integers and an integer k, find out whether there are two
 * distinct indices i and j in the array such that nums[i] = nums[j] and the
 * absolute difference between i and j is at most k.
 * https://leetcode.com/problems/contains-duplicate-ii/description/
 * 
 * Given an array of integers, find out whether there are two distinct indices i
 * and j in the array such that the absolute difference between nums[i] and
 * nums[j] is at most t and the absolute difference between i and j is at most
 * k. https://leetcode.com/problems/contains-duplicate-iii/description/
 * 
 * @author agiridhar
 *
 */
public class ContainsDuplicate {
	
	public static void main(String []args) {
		int []nums = {1, 4, 6, 10, 8, 10};
		
		System.out.println("Contains Duplicate: " + containsDuplicate(nums));
		System.out.println("Contains Duplicate: " + containsDuplicate(nums, 2));
		System.out.println("Contains Duplicate: " + containsDuplicate(nums, 1, 1));
		
	}
	
	public static boolean containsDuplicate(int[] nums) {
        
		if (nums.length < 2) {
			return false;
		}
		
        Set<Integer> set = new HashSet<Integer>();
        
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
        }
        
        return false;
    }
	
	public static boolean containsDuplicate(int[] nums, int k) {
		
		if (nums.length < 2) {
			return false;
		}
		
		Set<Integer> set = new HashSet<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			if (i > k) {
				set.remove(nums[i-k-1]);
			}
			if (set.contains(nums[i])) {
				return true;
			} else {
				set.add(nums[i]);
			}
		}
		
		return false;
		
	}
	
	public static boolean containsDuplicate(int []nums, int k, int t) {
		
		if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }

        final TreeSet<Integer> values = new TreeSet<>();
        for (int ind = 0; ind < nums.length; ind++) {

            final Integer floor = values.floor(nums[ind] + t);
            final Integer ceil = values.ceiling(nums[ind] - t);
            if ((floor != null && floor >= nums[ind])
                    || (ceil != null && ceil <= nums[ind])) {
                return true;
            }

            values.add(nums[ind]);
            if (ind >= k) {
                values.remove(nums[ind - k]);
            }
        }

        return false;
		
	}

}
