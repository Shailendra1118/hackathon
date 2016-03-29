package com.interview.bit;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class Factors {
	public static void main(String args[]){
		
		System.out.println(allFactors(36));
	}
	
	public static ArrayList<Integer> allFactors(int a) {
	    
	    Set<Integer> result= new TreeSet<Integer>();
	    result.add(1);
	    result.add(a);
	    int ctr = 0;
	    int i = 2;
	    while(i <= Math.sqrt(a)){ //a/2){
	    	 System.out.println("running "+(++ctr)+"th time");
	        if(a%i ==0){ 
	            result.add(i);
	            if(i != Math.sqrt(a))
	            	result.add(a/i);
	        }
	        
	        i++;
	    }
	   ArrayList<Integer> ans = new ArrayList<>();
	   ans.addAll(result);
	   return ans;
	}
}
