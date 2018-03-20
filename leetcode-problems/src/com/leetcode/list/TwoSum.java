package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;


/**
 * 
 * https://leetcode.com/problems/two-sum/description/
 * 
 * @author agiridhar
 *
 */
public class TwoSum {

	public static void main(String []args) {
		int []arr = {3,2,4};
		int []result = twoSum(arr, 6);
		System.out.println(String.format("Indices:[%d, %d]", result[0], result[1]));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
		    if (map.containsKey(nums[i])) {
		        return new int[]{map.get(nums[i]), i};
		    } else {
		        map.put(target - nums[i], i);
		    }
		}
		return new int[]{0, 0};
	}

}
