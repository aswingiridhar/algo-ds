package com.leetcode.stack;

import java.util.Stack;

/**
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 * 
 * @author agiridhar
 *
 */
public class ValidParenthesis {
	
	public static void main(String []args) {
		System.out.println("isValid: " + isValid("{}[]()"));
	}
	
	public static boolean isValid(String s) {
		
		Stack<Character> stack = new Stack<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(')');
			} else if (s.charAt(i) == '{') {
				stack.push('}');
			} else if (s.charAt(i) == '[') {
				stack.push(']');
			} else {
				if (stack.isEmpty() || stack.pop() != s.charAt(i)) {
					return false;
				}
			}
		}
		
        return stack.empty();
    }

}
