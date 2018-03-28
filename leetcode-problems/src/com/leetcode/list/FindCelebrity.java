package com.leetcode.list;

import java.util.Stack;

/**
 * 
 * @author agiridhar
 *
 */
public class FindCelebrity {
	
	 // Person with 2 is celebrity
    static int MATRIX[][] = { 
    						{ 0, 0, 1, 0 },
    						{ 0, 0, 1, 0 },
    						{ 0, 0, 0, 0 }, 
    						{ 0, 0, 1, 0 } 
    					};
	
	public static void main(String[] args) {
		
	    System.out.println("Celebrity index: " + findCelebrity(4));
	}
	
	public static boolean knows(int a, int b) {
		if (MATRIX[a][b] == 1) 
			return true;
		else 
			return false;
	}
	
	public static int findCelebrity(int n) {
		
		if (n == 0)
			return -1;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (int i = 1; i < n; i++) {
			stack.push(i);
		}
		
		while (stack.size() > 1) {
			
			int a = stack.pop();
			int b = stack.pop();
			
			if (knows(a, b)) {
				stack.push(b);
			} else {
				stack.push(a);
			}
		}
		
		int candidate = stack.pop();
		
		for (int i = 0; i < n; i++) {
			if (i != candidate && (!knows(i, candidate) || knows(candidate, i))) {
				return -1;
			} 
		}
		
		return candidate;
	}
	
	

}
