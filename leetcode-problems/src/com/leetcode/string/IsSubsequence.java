package com.leetcode.string;

/**
 * 
 * Problem : https://leetcode.com/problems/is-subsequence/description/
 * 
 * @author agiridhar
 *
 */
public class IsSubsequence {
	
	public static void main (String [] args) {
		
		System.out.println("Is Subsequence : " + isSubsequence("abc", "ahbgdc"));
	}
	
	public static boolean isSubsequence(String s, String t) {
        
		int indexS = 0, indexT = 0;
		if (s.length() == 0) return true;
		while (indexT < t.length()) {
			
			if (indexS < s.length() && s.charAt(indexS) == t.charAt(indexT)) {
				indexS++;
				if (indexS == s.length()) {
					return true;
				}
			}
			
			indexT++;
		}
		
		
		
		return false;
    }

}
