package com.leetcode.list;

/**
 * 
 * You are given arrival and departure time of trains reaching to a particular
 * station. You need to find minimum number of platforms required to accommodate
 * the trains at any point of time.
 * 
 * arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00} departure[] = {1:10, 3:00,
 * 2:20, 2:30, 3:15, 6:00} No. of platforms required in above scenario = 4
 * 
 * @author agiridhar
 *
 */
public class MinimumPlatformsInRailwayStations {

	public static void main(String args[]) {
		// arr[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
		// dep[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}

		int arr[] = { 100, 140, 150, 200, 215, 400 };
		int dep[] = { 110, 300, 220, 230, 315, 600 };
		System.out.println("Minimum platforms needed:" + findPlatformsRequiredForStation(arr, dep, 6));
	}
	
	public static int findPlatformsRequiredForStation(int arr[], int dep[], int n) {
		
		int i = 0, j = 0, platformsNeeded = 0, maxPlatforms = 0;
		
		while (i < n && j < n) {
			
			if (arr[i] < dep[j]) {
				i++;
				platformsNeeded++;
				
				if (platformsNeeded > maxPlatforms) {
					maxPlatforms = platformsNeeded;
				}
			} else {
				j++;
				platformsNeeded--;
			}
			
		}
		
		
		
		return maxPlatforms;
		
	}
	

}
