package com.applied;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class SearchMtx {

	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();		
		ArrayList<Integer> l1 = new ArrayList<Integer>(Arrays.asList(3)); 
		a.add(l1);
		ArrayList<Integer> l2 = new ArrayList<Integer>(Arrays.asList(29, 32));
		a.add(l2);
		ArrayList<Integer> l3 = new ArrayList<Integer>(Arrays.asList(36));
		a.add(l3);
		ArrayList<Integer> l4 = new ArrayList<Integer>(Arrays.asList(63));
		a.add(l4);
		ArrayList<Integer> l5 = new ArrayList<Integer>(Arrays.asList(67));
		a.add(l5);
		ArrayList<Integer> l6 = new ArrayList<Integer>(Arrays.asList(72));
		a.add(l6);
		ArrayList<Integer> l7 = new ArrayList<Integer>(Arrays.asList(78));
		a.add(l7);
		ArrayList<Integer> l8 = new ArrayList<Integer>(Arrays.asList(85));
		a.add(l8);
		
		int[][] arr = {{3}, {29}, {36}, {63}, {67}, {72}, {74}, {78}, {85}};
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < 1; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		
		int b = 32;
		Iterator<ArrayList<Integer>> list = a.iterator();
		while(list.hasNext()){
			ArrayList<Integer> l = list.next();
			Integer[] la = l.toArray(new Integer[l.size()]);
			//System.out.println("Array "+Arrays.toString(la));
			int low = 0, hi = la.length-1;
			int mid = (hi-low)/2+low;
			// in case of single element
			if(la[mid] == b){
				System.out.println("Found "+la[mid]);
				break;
			}				
			// devil is in details - base case - start with 1 and 2 then 3
			while(low <= hi){				
				mid = (hi-low)/2+low; // int mid = (l + r - 1) >> 1;
				System.out.println("Mid "+la[mid]);
				if(la[mid] == b){
					System.out.println("Found "+b);
					break;
				}
				if(la[mid] > b){
					hi = mid;
				}else if(la[mid] < b)
					low = mid+1;
					
			}
		}
		System.out.println("Not Found");

	}

}
