package com.leetcode.list;

public class FindSecondHighestNumber {
	
	public static void main(String []args) {
		
		int []arr = {5, 6, 3, 2, 7, 9};
		
		System.out.println("Second Highest: " + findSecondHighestNumber(arr));
		
	}
	
	public static Integer findSecondHighestNumber(int[] arr) {
		
		int highest = Integer.MIN_VALUE;
		int secondHighest = Integer.MIN_VALUE;
		
		for (int i = 0; i < arr.length; i++) {
			
			if (arr[i] > highest) {
				secondHighest = highest;
				highest = arr[i];
			} else if (arr[i] > secondHighest) {
				secondHighest = arr[i];
			}
			
		}
		
		return secondHighest;
	}

}
