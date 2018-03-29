package com.leetcode.list;

import java.util.HashMap;
import java.util.Map;

public class ConflictingAppointments {
	
	public static void main(String []args) {
		
		int arr[][] = {{1,3}, {2, 4}, {5, 6}};
		
		// array to hold start times
 		int [] start = new int [arr.length];
 		
 		// array to hold start times
 		int [] end = new int [arr.length];
 		
 		convertToStartAndEndArray(arr, start, end);
 		
		
 		Map<Integer, Integer> conflictingAppointments = findConflictingAppointments(start, end);
 		System.out.println("Conflicting Events are: ");
 		for (Map.Entry<Integer, Integer> entry : conflictingAppointments.entrySet()) {
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
	
	public static Map<Integer, Integer> findConflictingAppointments(int[] start, int [] end) {
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		if (start == null || end == null || start.length != end.length)
			return map;
		
		for (int i = 1; i < start.length; i++) {
			
			// there is a conflict
			if (start[i] < end[i - 1]) {
				map.put(start[i-1], end[i-1]);
				map.put(start[i], end[i]);
			}
			
		}
		
		return map;
	}
	

}
