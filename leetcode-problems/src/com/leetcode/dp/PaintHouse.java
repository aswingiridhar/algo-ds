package com.leetcode.dp;

public class PaintHouse {
	
	public static void main (String []args) {
		
		int [][] costs = {
				{10, 40, 50},
				{20, 80, 90},
				{30, 20, 70},
				{50, 70, 40}
		};
		
		System.out.println("MinCost: " + minCost(costs));
	}
	
	
	public static int minCost(int[][] costs) {
		
		if (costs == null || costs.length == 0) 
			return 0;
		
		for (int i = 1; i < costs.length; i++) {
			costs[i][0] += Math.min(costs[i-1][1], costs[i-1][2]);
			costs[i][1] += Math.min(costs[i-1][0], costs[i-1][2]);
			costs[i][2] += Math.min(costs[i-1][0], costs[i-1][1]);
		}
		
		
		return Math.min(Math.min(costs[costs.length-1][0], costs[costs.length-1][1]), costs[costs.length-1][2]);
	}

}
