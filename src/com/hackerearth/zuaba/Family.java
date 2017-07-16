package com.hackerearth.zuaba;

public class Family {

	public static void main(String[] args) {
		int n = 4;
		int arr[][][] = new int[26][2][n+1];
		String foodType = "abcd";
		String sleepType = "1100";
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<26;j++) {
				for(int k=0;k<2;k++) {
					arr[j][k][i+1] = arr[j][k][i];
				}
			}
			
			int j = foodType.charAt(i)-'a';
			int k = sleepType.charAt(i)-'0';
					
			arr[j][k][i+1]++;
		}
		
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<26;j++) {
				for(int k=0;k<2;k++) {
					System.out.print(arr[j][k][i]+" ");
				}
				System.out.println();
			}
			System.out.println();
		}

	}

}
