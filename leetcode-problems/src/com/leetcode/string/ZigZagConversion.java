package com.leetcode.string;


/**
 * https://leetcode.com/problems/zigzag-conversion/description/
 * 
 * Soln : http://www.lifeincode.net/programming/leetcode-zigzag-conversion-java/
 * 
 * @author agiridhar
 *
 */
public class ZigZagConversion {

	public static void main(String[] args) {
		System.out.println("ZigZag Conversion : " + convert("PAYPALISHIRING", 3));
	}

	public static String convert(String s, int numRows) {
		
		if (numRows == 1) {
			return s;
		}
		
		StringBuilder sb = new StringBuilder();
		
		int step = 2 * (numRows - 1);
		
		for (int row=0; row<numRows; row++) {
			
			if (row == 0 || row == numRows - 1) {
				for (int j=row; j<s.length();j=j+step) {
					sb.append(s.charAt(j));
				}
			} else {
				
				boolean flag = false;
				int step1 = 2*(numRows - 1 -row);
				int step2 = step - step1;
				
				int j = row;
				
				while (j < s.length()) {
					
					sb.append(s.charAt(j));
					
					if (flag) {
						j = j + step2;
						flag = false;
					} else {
						j = j + step1;
						flag = true;
					}
				}
				
				
			}
			
		}
		
		return sb.toString();
	}
}


