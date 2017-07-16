package com.hackerrank.dp;

public class SumTotal {

	private static int dp[] = new int[20];
	public static void main(String[] args) {
		int arr[] = {1, 3, 5};
		int n = 6;
		dp[0] = 1;
		int res = solve(arr, n);
		System.out.println("Res: "+res);
		
		int num = '1' - '0';
		System.out.println("Num: "+num);

	}
	//applying memoization technique
	private static int solve(int[] arr, int n) {
		if(n < 0){
			return 0;
		}
		else if(n == 0){ //last remaining number
			return dp[n];
		}
		
		if(dp[n] != 0){
			System.out.println("found n "+n+" value");
			return dp[n];
		}
		
		return dp[n] = solve(arr, n-1) + solve(arr, n-3) + solve(arr, n-5);
		
	}

}
