/**
 * 
 * https://leetcode.com/problems/coin-change/
 * 
 */
package com.practice.ds.array;

import java.util.Arrays;

import com.practice.ds.miscell.Utils;

public class CoinChange {

	public static void main(String[] args) {
		CoinChange o = new CoinChange();
		int min = o.coinChange(new int[]{186,419,83,408}, 6249);
//		int min = o.coinChange(new int[] { 2 }, 3);
		System.out.println(min);

	}
	
	public int coinChange(int[] coins, int amount) {
        if (amount <= 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        Arrays.sort(coins);
        dp[0] = 0;
        
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int c : coins) {
                if (c > i) continue;
                dp[i] = Math.min(dp[i], dp[i - c] + 1);
            }
            //Utils.print(dp);
        }
        
        return dp[amount] == Integer.MAX_VALUE || dp[amount] == Integer.MIN_VALUE ? -1 : dp[amount];
    }

//	public int coinChange(int[] coins, int amount) {
//		if (amount <= 0) {
//			return 0;
//		}
//		int[] dp = new int[amount + 1];
//		Arrays.sort(coins);
//		Arrays.fill(dp, -1);
//		dp[0] = 0;
//
//		for (int coin : coins) {
//			for (int i = 1; i < amount + 1; i++) {
//				if (i < coin) {
//					continue;
//				}
//				if (dp[i - coin] == -1)
//					dp[i] = -1;
//				else
//					dp[i] = 1 + dp[i - coin];
//			}
//			Utils.print(dp);
//		}
//
//		return dp[amount];
//	}
}
