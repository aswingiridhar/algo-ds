package com.leetcode.list;

public class MissingNumberInArray {
	
	public static void main(String [] args) {
		
		int []arr = {4,3,5,1};
		
		System.out.println("Missing Number in Array: " + missingNumberInArray(arr));
		
	}
	
	public static int missingNumberInArray(int[] arr) {
		int n = arr.length + 1;
		
		if (n == 0) return 0;
		
		int arithmeticSum = n*(n+1)/2;
		
		int arrSum = 0;
		
		for (int i=0;i<arr.length;i++) {
			arrSum += arr[i];
		}
		
		return (arithmeticSum - arrSum);
	}

}
