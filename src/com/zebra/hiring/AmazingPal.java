package com.zebra.hiring;

public class AmazingPal {

	public static void main(String[] args) {
		String str = "abaa";
		printSub(str);

	}

	private static void printSub(String str) {
		char arr[] = str.toCharArray();
		int n = str.length();
		// Pick starting point		
	    for (int i=0; i <n; i++)
	    {
	        // Pick ending point
	        for (int j=i; j<n; j++)
	        {
	            // Print sub-array between current starting
	            // and ending points
	            for (int k=i; k<=j; k++)
	            	System.out.print(arr[k]+" ");
	 
	            System.out.println();
	        }
	    }
	}

}
