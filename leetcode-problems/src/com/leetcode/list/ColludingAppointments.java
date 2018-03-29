package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class ColludingAppointments {
	
	public static void main(String []args) {
		
		int arr[][] = {{1,3}, {2, 4}, {5, 6}};
		
		// array to hold start times
 		int [] start = new int [arr.length];
 		
 		// array to hold start times
 		int [] end = new int [arr.length];
 		
 		convertToStartAndEndArray(arr, start, end);
 		
 		for (int i : start) {
 			System.out.println("Start Times: " + i);
 		}
 		for (int i : end) {
 			System.out.println("End Times: " + i);
 		}
		
 		Map<Integer, Integer> colludingAppointments = findColludingAppointments(start, end);
 		
 		for (Map.Entry<Integer, Integer> entry : colludingAppointments.entrySet()) {
 			System.out.println("(" + entry.getKey() + "," + entry.getValue() + ")" );
 		}
 		
 		
	}
	
	
	public static void convertToStartAndEndArray(int arr[][], int[] start, int [] end) {
		
		if (arr != null && arr.length > 0) {
			
			for (int i = 0; i < arr.length; i++) {
				
				start[i] = arr[i][0];
				end[i] = arr[i][1];
			}
			
		}
		
	}
	
	public static Map<Integer, Integer> findColludingAppointments(int[] start, int [] end) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		if (start == null || end == null || start.length != end.length)
			return map;
		
		for (int i = 1; i < start.length; i++) {
			
			if (start[i] > end[i - 1] )
			
		}
		
		return map;
	}
	

}
