package com.leetcode.stack;

import java.util.Stack;

/**
*
* https://leetcode.com/problems/evaluate-reverse-polish-notation/description/
* 
* @author agiridhar
*
*/
public class ReversePolishNotation {
	
	public static void main(String []args) {
		
		String []tokens = {"4", "5", "+", "3", "*"};
		System.out.println("Evaluate RPN: " + evalRPN(tokens));
	}
	
	public static int evalRPN(String[] tokens) {
		
		if (tokens == null || tokens.length == 0) 
			return 0;
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for (String token : tokens) {
			// operators
			if (token.equals("+")) {
				stack.push(stack.pop() + stack.pop());
			} else if (token.equals("-")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b-a);
			} else if (token.equals("/")) {
				int a = stack.pop();
				int b = stack.pop();
				stack.push(b/a);
			} else if(token.equals("*")) {
				stack.push(stack.pop() * stack.pop());
			} 
			// operand
			else {
				stack.push(Integer.parseInt(token));
			}
			
		}
		
		if (!stack.empty()) 
			return stack.pop();
		
		return 0;
    }

}
