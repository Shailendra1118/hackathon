package com.stanlay;

import java.util.HashMap;
import java.util.Iterator;

public class Test {
	
	public static void main(String args[]){
		HashMap<Integer,Integer> map = new HashMap<>();
		map.put(1, 2);
		map.put(2, 2);
		map.put(3, 3);
		
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext()){
			if(iter.next() == 2)
				//map.put(4, 4);
			System.out.println();
		}		
		System.out.println(map);
		printBinary(6);
		
	}
	
	public static void printBinary(int n) {
        for (int i = 1; i <= n; i++) {
            doPrintBinary(i);
            System.out.println();
        }
        
    }
    
    public static void doPrintBinary(int n) {
    	System.out.println("n is "+n);
        if (n > 1) {
            doPrintBinary(n >> 1);
        }
        System.out.print(n & 1);
    }

}
