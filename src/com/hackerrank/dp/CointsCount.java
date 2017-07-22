package com.hackerrank.dp;

public class CointsCount {

	//static int min = Integer.MAX_VALUE;
	public static void main(String[] args) {
		int coins[] = {1,2,5};
		// use these coins - minimum to make the sum 
		int n = coins.length;
		int sum = 11;
		
		//minimum coins to for sum
		int res = minCoins(coins, n, sum);
		System.out.println("Res: "+res);
		minCoinsDp(coins, n, sum);
	}

	// recursive
	private static int minCoins(int[] coins, int n, int sum) {
		//base case
		if(sum == 0){
			//System.out.println("sum is zero.");
			return 0; // return 0, now coins made up the sum
		}
		int min = Integer.MAX_VALUE;
		
		for (int i = 0; i < coins.length; i++) {
			if(coins[i] <= sum){
				int res = minCoins(coins, n, sum-coins[i]);
				if(res != Integer.MAX_VALUE && res+1 < min){
					min = res+1;
				}
			}
		}
		return min;
		
	}
	
	// dynamic programming
	private static void minCoinsDp(int[] coins, int n, int sum){
		int dp[] = new int[sum+1];
		dp[0] = 0;
		for (int i = 1; i <= sum; i++) {
			dp[i] = 9999;
		}
		
		// Compute minimum coins required for all
	    // values from 1 to sum
		for (int i = 1; i <= sum; i++) {
			for (int j = 0; j < n; j++) {
				if(coins[j] <= i){ // i is the amount
					int sub_res = dp[i-coins[j]]+1;
					// check sub_res not equal to max to prevent overflow
					if(sub_res < dp[i]){ // add 1 for this coin
						dp[i] = dp[i-coins[j]] + 1;
					}
				}
			}
		}
		
		System.out.println("Res: "+dp[sum]);
	}

}
