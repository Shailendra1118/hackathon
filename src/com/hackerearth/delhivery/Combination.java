package com.hackerearth.delhivery;

public class Combination {

	public static void main(String[] args) {
		// Delivery 
		int sum = 8;
		int arr[] = {1,2,3,4,5};
		int r = 5;
		combination(arr, arr.length, r);

	}

	private static void combination(int[] arr, int n, int r) {
		int temp[] = new int[r];
		combUtil(arr, temp, 0, n-1, 0, r);
		
	}

	// start - end : indices in main array arr
	// index - index in temp array temp
	private static void combUtil(int[] arr, int[] temp, int start, int end, int index,
			int r) {
		
		// Current combination is ready to be printed, print it
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(temp[j]+" ");
            System.out.println("");
            return;
        }
 
        // replace index with all possible elements. The condition
        // "end-i+1 >= r-index" makes sure that including one element at index will make a combination with remaining elements
        // at remaining positions
        for (int i=start; i<=end ; i++) //&& end-i+1 >= r-index
        {
        	temp[index] = arr[i];
        	combUtil(arr, temp, i+1, end, index+1, r);
        }
	}

}
