package com.leetcode.list;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

Example:
Input:
[4,3,2,7,8,2,3,1]

Output:
[2,3]
 * 
 * @author agiridhar
 *
 */
public class FindAllDuplicatesInArray {
	
	public static void main(String[] args) {
		int nums[] = {4,3,2,7,8,2,3,1};
		List<Integer> duplicates = findDuplicates(nums);
		
		for (int n : duplicates) {
			System.out.println(n);
		}
		
		int nums2[] = {4,3,2,7,8,2,3,1};
		List<Integer> disappearedNumbers = findDisappearedNumbers(nums2);
		
		for (int n : disappearedNumbers) {
			System.out.println(n);
		}
	}
	
	public static List<Integer> findDuplicatesUsingMap(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for (int i = 0; i < nums.length; i++) {
        		map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        		if (entry.getValue() > 1) {
        			result.add(entry.getKey());
        		}
        }
        
        return result;
    }
	
	// when find a number i, flip the number at position i-1 to negative. 
    // if the number at position i-1 is already negative, i is the number that occurs twice.
	public static List<Integer> findDuplicates(int [] nums) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			
			if (nums[index] < 0) {
				result.add(Math.abs(index+1));
			}
				
			nums[index] = -nums[index];
		}
		
		return result;
	}
	
	public static List<Integer> findDisappearedNumbers(int[] nums) {
		List<Integer> result = new ArrayList<Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				result.add(i + 1);
			}
		}
		
		return result;
    }

	
}
