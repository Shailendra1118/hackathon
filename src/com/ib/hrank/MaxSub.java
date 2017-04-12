package com.ib.hrank;

import java.io.File;
import java.util.Scanner;


public class MaxSub {

	public static void main(String args[] ) throws Exception {
        //Scanner
        Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\ib\\hrank\\input.txt"));
        int N = s.nextInt();
        for (int i = 0; i < N; i++) {
            int size = s.nextInt();
            int arr[] = new int[size];
            for(int j=0; j<size; j++){
                arr[j] = s.nextInt();
            }
            //System.out.println(Arrays.toString(arr));
            printSubArray(arr);
        }
        s.close();
    }
    
	// look for all positive contiguous segments of the array (max_ending_here). 
	// keep track of maximum sum contiguous segment among all positive segments (max_so_far).
    private static void printSubArray(int arr[]){
        int maxSoFar = Integer.MIN_VALUE;
        int maxEnds = 0, start = 0, end = 0, s = 0;
        
        for(int i=0; i<arr.length; i++){
        	maxEnds = maxEnds + arr[i];
            if(maxEnds < 0){
            	maxEnds = 0;
            	s = i+1;
            }
            else if(maxEnds > maxSoFar){
            	maxSoFar = maxEnds;
            	start = s;
            	end = i;
            }
                
        }
        System.out.println(maxSoFar+" "+"starting from "+start+" to "+end);    
        
       
    }

	 
}
