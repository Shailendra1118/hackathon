package com.booking.redhat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterateOver {

	static ArrayList<Integer> arr1 = new ArrayList();
	static ArrayList<Integer> arr2 = new ArrayList();
	static ArrayList<Integer> result = new ArrayList();
	public static void main(String[] args) {
		
		arr1.add(1);
		arr1.add(6);
		arr1.add(8);
		
		arr2.add(4);
		arr2.add(7);
		arr2.add(18);
		List list = combine(arr1.iterator(), arr2.iterator());
		Iterator iter = list.iterator();
		while(iter.hasNext()){
			System.out.println(iter.next());
		}
		
	}
	
	public static List<Integer> combine(Iterator<Integer> itr1,Iterator<Integer> itr2){

        Integer x = itr1.hasNext() ? itr1.next() : null;
        Integer y = itr2.hasNext() ? itr2.next() : null;
        while (x != null && y != null) {
            if (x.compareTo(y) < 0) {
            	result.add(x);
                x = itr1.hasNext() ? itr1.next() : null;
            }
            else { 
            	result.add(y);
                y = itr2.hasNext() ? itr2.next() : null;
            }
        }
        
        if (x != null) {
        	result.add(x);
            while (itr1.hasNext()) {
            	result.add(itr1.next());
            }
        }
        else if (y != null) {
        	result.add(y);
            while (itr2.hasNext()) {
            	result.add(itr2.next());
            }
        }
        
        return result;
	}

}
