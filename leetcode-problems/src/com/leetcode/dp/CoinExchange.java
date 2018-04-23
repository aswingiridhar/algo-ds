package com.leetcode.dp;

/**
 * 
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin.
 * 
 * @author agiridhar
 *
 */
public class CoinExchange {
	
	public static void main(String []args) {
		int []coins = {1,3,5};
		System.out.println("Coin Exchange: " + coinChange(coins, 11)); // expect 3
		
		System.out.println("Coin Exchange: " + coinChange(new int[]{2}, 3)); // expect 3
	}
	
	public static int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) return 0;
		
        int []result = new int[amount+1];
        
        result[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
        		
        		result[i] = amount+1;
        		
        		for (int j = 0; j < coins.length; j++) {
        			if (coins[j] <= i) {
        				result[i] = Math.min(result[i], result[i-coins[j]] + 1);
        			}
        		}
        }
        
		return result[amount] > amount ? -1 : result[amount];
    }

}
