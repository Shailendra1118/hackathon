package com.march.prac;

public class EditDist {

	public static void main(String[] args) {
		
		String str1 = "sunday";
		String str2 = "saturday";
		
		editDp(str1, str2, str1.length(), str2.length());

	}

	private static void editDp(String str1, String str2, int m, int n) {
		int dp[][] = new int[m+1][n+1];
		
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				// filling bottom up manner
				if(i == 0){
					dp[i][j] = j;
				}
				else if(j == 0){
					dp[i][j] = i;
				}
				else if(str1.charAt(i-1) == str2.charAt(j-1)){ //check the last character, if same ignore processing
					System.out.println(i+" "+j+" are same");
					dp[i][j] = dp[i-1][j-1];
				}
				else{
					System.out.println(i+" "+j+" are diff");
					dp[i][j] = 1 + Math.min(dp[i][j-1], Math.min(dp[i-1][j], dp[i-1][j-1])); //last one is for replace
				}
			}
		}
		
		for (int f = 0; f <=m; f++) {
			for (int i = 0; i <=n; i++) {
				System.out.print(dp[f][i]+" ");
			}
			System.out.println();
		}
		
		System.out.println("Ans: "+dp[m][n]);
	}

}
