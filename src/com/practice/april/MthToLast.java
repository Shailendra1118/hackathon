package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MthToLast {

	 public static void main(String[] args) throws FileNotFoundException {
	        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
	        //Scanner scan = new Scanner(System.in);
		 	Scanner scan = new Scanner(new File("D:/Keppler/Hackerrank/src/com/practice/april/LLinput.txt"));
			//String size = scan.next();
		 	 // Scanner scan = new Scanner(System.in);
		        int m = Integer.valueOf(scan.next());
		        System.out.println("m "+ m);
		        ArrayList<Integer> arr = new ArrayList<>(3000001);
		        int idx = 0;
		        while(scan.hasNext()){
		            arr.add(Integer.valueOf(scan.next()));
		        }
		       
		        System.out.println("list size "+arr.size());
		        if(arr.size()-m >= 0)
		        	System.out.println(m+"th from last "+arr.get(arr.size()-m));
		        else
		        	System.out.println("NIL");
		        
		        
	    }
	    
	    static class Node{
	        int value;
	        Node next;
	    
	    }   

}
