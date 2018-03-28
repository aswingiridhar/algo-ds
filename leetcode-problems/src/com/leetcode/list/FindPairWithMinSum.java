package com.leetcode.list;

import java.util.Arrays;

/**
 * 
 * array[]={1,3,-5,7,8,20,-40,6};
 * 
 * The pair whose sum is closest to zero :  -5 and 6
 * 
 * @author agiridhar
 *
 */
public class FindPairWithMinSum {
	
	public static void main(String []args) {
		int []arr = {1,30,-5,70,-8,20,-40,60};
		
		findPairWithMinSumClosestToZero(arr);
	}
	
	public static void findPairWithMinSumClosestToZero(int []arr) {
		
		// sort the array
		Arrays.sort(arr);
		
		//left and right indices
		int l = 0, r = arr.length - 1;
		
		int minSum = Integer.MAX_VALUE, sum = 0;
		int minLeft = l, minRight = r;
		
		while (l < r) {
			
			sum = arr[l] + arr[r];
			
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = l;
				minRight = r;
			}
			
			if (sum < 0) {
				l++;
			} else {
				r--;
			}
			
		}
		
		System.out.println(String.format("Pair: {%d, %d}", arr[minLeft], arr[minRight]));
		
	}
	
	public static void findPairWithMinSumClosestToX(int []arr, int x) {
		
		// sort the array
		Arrays.sort(arr);
		
		//left and right indices
		int l = 0, r = arr.length - 1;
		
		int minSum = Integer.MAX_VALUE, sum = 0;
		int minLeft = l, minRight = r;
		
		while (l < r) {
			
			sum = arr[l] + arr[r];
			
			if (Math.abs(sum) < Math.abs(minSum)) {
				minSum = sum;
				minLeft = l;
				minRight = r;
			}
			
			if (sum < x) {
				l++;
			} else {
				r--;
			}
			
		}
		
		System.out.println(String.format("Pair: {%d, %d}", arr[minLeft], arr[minRight]));
		
	}
}
