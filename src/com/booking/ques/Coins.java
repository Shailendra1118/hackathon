package com.booking.ques;

public class Coins {
	static int[] coins = {9,6,5,1};
	static  int amount = 11;
	static int []lookup = new int[100];
	
	public static void main(String args[]){
		lookup[0] = 0;
		System.out.println(findMin());
	}

	private static int findMin() {
		//fill the lookup table
		for(int i=1; i<amount+1; i++){
			int j=0;
			while(j<coins.length-1 && coins[j] > lookup[i]){
				j++;
			}
			int res = lookup[i-1];
			lookup[i] = 1+(lookup	[res]);
		}
		
		
		return 0;
	}
}
