package com.booking.ques;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Denomination {
	static int INT_MAX = 999999;
	public static void main(String args[]){
		
		int arr[] = {9, 6, 5, 1}; //coins sorted descending 
		//System.out.println(1<=8);
		int coins[] = arr;
		int amount = 16;
		System.out.println(minCoins(arr, amount));
		
		HashMap<Integer, List<Integer>> map = new HashMap();
		int amt = amount;
		calculateDeno(amt);
		while(amt > 0){
			List prev = new ArrayList<Integer>();
			if(map.containsKey(amt)){
				prev = map.get(amt);
				//map.put(amt, prev)
			}
			int max = findMax(amt, arr);
			int deno = amt/max;
			amt = amt%max;
			//System.out.println("denominations "+max+"-"+deno);
			//map.put(amt, prev);
		}
		
	}

	private static int minCoins(int[] coins, int amount) {
		// table[i] will be storing the minimum number of coins
	    // required for i value.  So table[V] will have result
	    int table[] = new int[amount+1];
	 
	    // Base case (If given value V is 0)
	    table[0] = 0;
	 
	    // Initialize all table values as Infinite
	    for (int i=1; i<=amount; i++)
	        table[i] = INT_MAX;
	 
	    // Compute minimum coins required for all
	    // values from 1 to V
	    for (int i=1; i<=amount; i++)
	    {
	        // Go through all coins smaller than i
	        for (int j=0; j<coins.length; j++)
	          if (coins[j] <= i)
	          {
	              int sub_res = table[i-coins[j]];
	             if (sub_res != INT_MAX && sub_res + 1 < table[i])
	                  table[i] = sub_res + 1;
	          }
	    }
	    return table[amount];
	}

	private static void calculateDeno(int amt) {
		
	}

	private static int findMax(int amt, int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			if(amt >= arr[i]){ //arr[i] =< 
				max = arr[i];
				//System.out.println("max-"+max);
				break;
			}
		}
		return max;
	}

}
