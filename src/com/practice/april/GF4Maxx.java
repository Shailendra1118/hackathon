package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GF4Maxx {
	
		public static void main (String[] args) throws FileNotFoundException
		 {
		    //Scanner scanner = new Scanner(System.in);
			Scanner scanner = new Scanner(new File("D:/Keppler/Hackerrank/src/com/practice/april/LLinput.txt"));
			int size = scanner.nextInt();
			int arr[] = null;
		    for(int i=0; i<size; i++){
		        int len = scanner.nextInt();
		        int max = scanner.nextInt();
		        arr = new int[len];
		        for(int j=0; j<len; j++){
		            arr[j] = Integer.valueOf(scanner.next());
		        }
		        findMax(arr, max);
		        System.out.println();
		    }
		    scanner.close();
		 }
		 
		 public static void findMax(int [] arr, int num){
		     int maxNow = 1000;
		     while(num > 0){
		    	 int curr = -999;
		         for(int i=0; i<arr.length; i++){
	    	         if(arr[i] > curr && arr[i] < maxNow)
	    	            curr = arr[i];
	    	         //else 
	    	        //	 if(arr[i] == maxNow)
	    	        //		 System.out.println(arr[i]);
	    	         
	    	       
		         }
		       
		        num--;
		        maxNow = curr;
		        System.out.print(curr+" ");
		     }
		     
		 }
	
}
