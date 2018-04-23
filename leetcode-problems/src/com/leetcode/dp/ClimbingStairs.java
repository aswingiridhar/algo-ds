package com.leetcode.dp;

/**
 * 
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.

Example 1:

Input: 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step

Hint: its a fibonacci series fib(n) = fib(n-1) + fib(n-2)

 * 
 * @author agiridhar
 *
 */
public class ClimbingStairs {
	
	public static void main(String[] args) {
		System.out.println("Diff ways to climb stairs : " + climbStairs(0));
		System.out.println("Diff ways to climb stairs : " + climbStairs(1));
		System.out.println("Diff ways to climb stairs : " + climbStairs(2));
		System.out.println("Diff ways to climb stairs : " + climbStairs(3));
		System.out.println("Diff ways to climb stairs : " + climbStairs(10));
	}
	
	public static int climbStairs(int n) {
		
		if (n < 1) {
			return 0;
		}
		
		if (n == 1) {
			return 1;
		}
		
		if (n == 2) {
			return 2;
		}
		
		int result[] = new int[n+1];
		
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		
		for (int i = 3; i <= n; i++) {
			result[i] = result[i-1] + result[i-2];
		}
		
		return result[n];
		
        
    }

}
