package com.booking.ques;

import java.util.HashSet;
import java.util.Iterator;

public class SquareF {

	public static void main(String[] args) {
		int[] arr1 = {1,4,6,3,7};
		int[] arr2 = {46,63,36,31,70,16};
		
		HashSet<Integer> set1 = new HashSet<Integer>();
		HashSet<Integer> set2 = new HashSet<Integer>();
		
		for (int i = 0; i < arr1.length; i++) {
			set1.add(arr1[i]);
		}
		
		for (int i = 0; i < arr2.length; i++) {
			set2.add(arr2[i]);
		}
		
		//check to see square values in set2
		Iterator<Integer> iter = set1.iterator();
		while(iter.hasNext()){
			Integer value = iter.next();
			if(set2.contains(value*value)){
				System.out.println("Found sqr of value :"+value);
			}
		}
		
	}

}
