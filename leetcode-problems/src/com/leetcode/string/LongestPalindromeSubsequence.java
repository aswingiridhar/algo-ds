package com.leetcode.string;

/**
 * 
 * https://leetcode.com/problems/longest-palindromic-subsequence/description/
 * 
 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.

Example 1:
Input:

"bbbab"
Output:
4
One possible longest palindromic subsequence is "bbbb".
Example 2:
Input:

"cbbd"
Output:
2
One possible longest palindromic subsequence is "bb".
 * 
 * @author agiridhar
 *
 */
public class LongestPalindromeSubsequence {
	
	public static void main(String []args) {
		System.out.println("Longest Palindrome Subseq: " + longestPalindromeSubseq("ndan"));
	}
	
	public static int longestPalindromeSubseq(String s) {
		
		int [][]result = new int[s.length()][s.length()];
		
		for (int i = s.length() - 1; i >= 0; i--) {
			
			result[i][i] = 1;
			
			for (int j = i+1; j < s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					result[i][j] = result[i+1][j-1] + 2;
				} else {
					result[i][j] = Math.max(result[i+1][j], result[i][j-1]);
				}
			}
			
		}
		
		return result[0][s.length()-1];
        
    }

}
