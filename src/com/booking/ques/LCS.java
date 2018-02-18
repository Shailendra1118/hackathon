package com.booking.ques;

public class LCS {

	public static void main(String[] args) {

		String x = "GXTXAYB";
		String y = "AGGTAB";

		int res = lis(x, y, x.length(), y.length());
		System.out.println("LCS: " + res);

	}

	private static int lis(String x, String y, int m, int n) {

		int L[][] = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				} else if (x.charAt(i - 1) == y.charAt(j - 1)) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}

		printL(L, m + 1, n + 1);
		printLCS(x, y, L, m, n);
		return L[m][n];
	}

	private static void printLCS(String x, String y, int[][] L, int m, int n) {
		int idx = L[m][n];
		char lcs[] = new char[idx + 1];
		int k = 0;
		for (int i = m; i > 0;) {
			for (int j = n; j > 0;) {
				if (x.charAt(i - 1) == y.charAt(j - 1)) {
					lcs[k++] = x.charAt(i - 1);
					i--;
					j--;
					break;
				} else {
					if (L[i - 1][j] > L[i][j - 1]) {
						i--;
					} else {
						j--;
					}
				}

			}
		}

		String ans = new String(lcs);
		StringBuilder sb = new StringBuilder(ans);
		System.out.println(sb.reverse());
		for (int i = 0; i < lcs.length; i++) {
			System.out.print(lcs[i] + " ");
		}
	}

	private static void printL(int[][] L, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(L[i][j] + " ");
			}
			System.out.println();
		}

	}

}
