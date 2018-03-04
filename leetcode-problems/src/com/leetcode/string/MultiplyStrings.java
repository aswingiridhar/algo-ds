package com.leetcode.string;

/**
 * 
 * Problem : https://leetcode.com/problems/add-strings/description/
 * 
 * @author agiridhar
 *
 */
public class MultiplyStrings {
	
	public static void main (String [] args) {
		
		System.out.println("Multiplication of two strings : " + multiply("9133", "0"));
		
	}
	
	public static String multiply(String num1, String num2) {
        
		num1 = new StringBuffer(num1).reverse().toString();
		num2 = new StringBuffer(num2).reverse().toString();
		
		StringBuilder sb = new StringBuilder();
		int d[] = new int[num1.length() + num2.length()];
		
		for (int i=0; i<num1.length(); i++) {
			for (int j=0; j<num2.length(); j++) {
				d[i+j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			}
		}
		
		for (int i=0; i<d.length; i++) {
			
			int mod = d[i]%10;
			
			int carry = d[i]/10;
			
			if (i+1 < d.length ) {
				d[i+1] += carry;
			}
			
			sb.insert(0, mod);
		}
		
		
		return removeTrialingZeros(sb);
    }
	
	private static String removeTrialingZeros (StringBuilder sb) {
		if (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
			removeTrialingZeros(sb);
		} 
		return sb.toString();
	}
}
