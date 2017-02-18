package com.hackerrank.sprint;

public class SnackCaseRod {

	public static void main(String[] args) {
		String s = "have_a_nice_day";
		String arr[] = s.split(" ");
		System.out.println(arr.length);
		int ranks[] = {100,100,50,40,40,20,10};
		int count = 1;
		for (int i = 1; i < ranks.length; i++) {
			if(ranks[i] != ranks[i-1])
				count++;
		}
		System.out.println("rank: "+count);
		
		
		 int price[] = new int[] {1,   5,   8,   9,  10,  17,  17,  20};
	     int size = price.length;
	     System.out.println("Maximum Obtainable Value is "+cutRod(price, size));
		
	}
	
	 static int cutRod(int price[], int n)
	 {
	     if (n <= 0){
	    	 System.out.println("return with 0");
	         return 0;
	     }
	     int max_val = Integer.MIN_VALUE;
	
	     // Recursively cut the rod in different pieces and
	     // compare different configurations
	     for (int i = 0; i<n; i++){
	    	 System.out.println("infor: i: "+i+" n: "+n);
	         max_val = Math.max(max_val, price[i] + cutRod(price, n-i-1));
	         System.out.println("cutRod call returned max_val is: "+max_val);
	     }
	
	     //System.out.println("returning with max_val: "+max_val+" here n was: "+n);
	     return max_val;
	 }

}



