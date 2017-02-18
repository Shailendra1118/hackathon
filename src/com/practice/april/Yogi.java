package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Yogi {

	public static void main(String[] args) throws FileNotFoundException {
		 //Scanner s = new Scanner(System.in);
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\practice\\april\\inputHR.txt"));
	        int N = s.nextInt();
	        int arr[] = new int[N];
	        for (int i = 0; i < N; i++) {
	            arr[i] = s.nextInt();
	        }
	        int op1 = 0;
	        int op2 = 0;
	        System.out.println(Arrays.toString(arr));
	        while(! isSorted(arr)){
	            //check if ascending order
	        	int[] tArr = new int[arr.length]; 
	        	System.arraycopy(arr, 0, tArr, 0, arr.length);
	            int i = 0, j = 0;
	            while(i < arr.length){
	    			int minI = i;
	    			for (j = i+1; j < arr.length; j++) {
	    				if(arr[minI] > arr[j]){
	    					minI = j;
	    					op1++;
	    				}
	    			}
	    			int temp = arr[i];
	    			arr[i] = arr[minI];
	    			arr[minI] = temp;
	    			i++;
	    			
			    }
			    arr = tArr;
			    //check if ascending order
	            i = 0;
	            j = 0;
	            while(i < arr.length){
	    			int minI = i;
	    			for (j = i+1; j < arr.length; j++) {
	    				if(arr[minI] > arr[j]){
	    					minI = j;
	    					op2++;
	    				}
	    			}
	    			int temp = arr[i];
	    			arr[i] = arr[minI];
	    			arr[minI] = temp;
	    			i++;
	    			
			    }
			    
			    if(op1 < op2)
			        System.out.println(op1);
			    else
			        System.out.println(op2);
			    
	        }


	}
	
	private static boolean isSorted(int arr[]){
        boolean inc = true;
        boolean desc = true;
        boolean dFlag = false;
        boolean iFlag = false;
        if(arr[0] > arr[1]){
        	dFlag = true;
            for(int i=1; i<arr.length-1;i++){
                if(arr[i] < arr[i+1]){
                    desc = false;
                }
            }
        }
        
        if(dFlag && desc)
        	return true;
      
        if(arr[0] < arr[1]){
        	iFlag = true;
            for(int i=1; i<arr.length-1;i++){
                if(arr[i] > arr[i+1]){
                    inc = false;
                }
            }
        }
        if(iFlag && inc)
            return true;
        else
            return false;
    }

}
