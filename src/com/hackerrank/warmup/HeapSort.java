package com.hackerrank.warmup;

public class HeapSort {

	static int[] array = {4,1,3,2,16,9,10,14,8,7};
	public static void main(String[] args) {
		/*
		 * 
		 */
		printArray(array);
		heapSort(array);
		//printArray(array);
	}
	
	
	private static void heapSort(int[] arr) {
		//build a max heap for increasing order - iteratively
		 /* Insertion onto heap */
	    for (int heapsize=0; heapsize<array.length; heapsize++) {
	        /* Step one in adding an element to the heap in the
	         * place that element at the end of the heap array-
	         * in this case, the element is already there. */
	        int n = heapsize; // the index of the inserted int
	        System.out.println("idx is "+n);
	        while (n > 0) { // until we reach the root of the heap
	            int p = (n-1)/2; // the index of the parent of n
	            System.out.println("reinitialize parent to "+p);
	            if (array[n] > array[p]) { // child is larger than parent
	            	System.out.println(" Swapping "+ array[n]+" and "+array[p]);
	               // arraySwap(array, n, p); // swap child with parent
	            	int temp = array[n];
	            	array[n] = array[p];
	            	array[p] = temp;
	                n = p; // check parent
	                System.out.println("Now n is "+p);
	            }
	            else // parent is larger than child
	                break; // all is good in the heap
	        }
	    }
	    System.out.println("After insertion -");
	    printArray(arr);
		
	}


	private static void printArray(int[] array2) {
		for(int i=0;i<array.length; i++){
			System.out.print(" "+array[i]);
		}		
	}

}
