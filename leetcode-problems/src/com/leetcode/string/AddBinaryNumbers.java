package com.leetcode.string;

/**
 * 
 * Problem : https://leetcode.com/problems/add-binary/description/
 * 
 * @author agiridhar
 *
 */
public class AddBinaryNumbers {
	
	public static void main (String [] args) {
		
		System.out.println("Addition of Binary Numbers : " + addBinaryNumbers("1010", "10"));
		
	}
	
	private static String addBinaryNumbers(String a, String b) {
		
		StringBuilder result = new StringBuilder();
		
		int i = a.length() - 1;
		int j = b.length() - 1;
		
		int carry = 0;
		
		while(i >= 0 || j >= 0) {
			
			int sum = 0;
			
			if(i >= 0 && a.charAt(i) == '1') {
				sum++;
			}
			
			if(j >= 0 && b.charAt(j) == '1') {
				sum++;
			}
			
			sum += carry;
			
			if (sum > 1) {
				carry = 1;
			} else {
				carry = 0;
			}
			
			result.append(sum%2);
			
			i--; j--;
		}
		
		if (carry == 1) {
			result.append('1');
		}
		
		return result.reverse().toString();
	}
	
	
}
