package com.amazon.asked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class DistinctEle {

	 public static void main(String[] args) throws FileNotFoundException {
         @SuppressWarnings("resource")
         //Scanner in = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\amazon\\asked\\input.txt"));
         Scanner in = new Scanner(new File("C:/Users/Shailendra/Desktop/Dequeu.txt"));   //(System.in);
         Deque<Integer> deque = new ArrayDeque<>();
         int n = in.nextInt();
         int m = in.nextInt();         
         int currmax = 0, max = 0;
         
         int arr[] = new int[1000000];
         for(int i=0; i<n; i++){
        	 int num = in.nextInt();
        	 if(deque.size() < m){    //until one less than window 
        		 if(arr[num] == 0){
        			 // arr[num]++; wrong
        			 currmax++;	
        		 }
        		 arr[num]++;
        		 deque.addLast(num);
        		 
        	 }else{
        		 int temp = deque.removeFirst();
        		 arr[temp]--;
        		 
        		 if(arr[temp] == 0)
        			 currmax--;
        		 
        		if(arr[num] == 0)
        			 currmax++;
        		
        		//need to increment always
        		 arr[num]++;
        		 deque.addLast(num);
        	 }
        	 
        	 //System.out.println("In "+i+"th pass "+currmax);
        	 if(currmax > max)
        		 max = currmax;
         }
         
         
         System.out.println(max);
     }

}
