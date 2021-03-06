package com.leetcode.list;

/**
 * Write a program to find the nth super ugly number.

Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.

Note:
(1) 1 is a super ugly number for any given primes.
(2) The given numbers in primes are in ascending order.
(3) 0 < k ≤ 100, 0 < n ≤ 106, 0 < primes[i] < 1000.
(4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 * 
 * https://leetcode.com/problems/super-ugly-number/description/
 * 
 * @author agiridhar
 *
 */
public class SuperUglyNumber {
	
	public static void main(String []args) {
		
		int [] primes = {2, 7, 13, 19};
		
		System.out.println("nth super ugly number : " + nthSuperUglyNumber(12, primes));
		
	}
	
	public static int nthSuperUglyNumber(int n, int[] primes) {
		
		int []result = new int[n];
		
		int idx[] = new int[primes.length];
		
		result[0] = 1;
		
		for (int i = 1; i < n; i++) {
			
			result[i] = Integer.MAX_VALUE;
			
			for (int j = 0; j < primes.length; j++) {
				
				result[i] = Math.min(result[i], primes[j] * result[idx[j]]);
				
			}
			
			for (int j = 0; j < primes.length; j++) {
				if (result[i] == (primes[j] * result[idx[j]])) {
					idx[j]++;
				}
			}
			
			
		}
		
		return result[n-1];
    }

}
