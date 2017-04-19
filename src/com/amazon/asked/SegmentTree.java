package com.amazon.asked;

import java.util.Arrays;

public class SegmentTree {

	static int st[] = null;
	public static void main(String[] args) {
		int arr[] = {1, 3, 5, 7, 9, 11};
		
	    constructST(arr, arr.length);	    
	    System.out.print("Sum of values in given range "+getSum(1, 3));	   
	    
	    //updateValue(arr, st, arr.length, 1, 10);	    
	    //System.out.print("Sum of values in given range "+getSum(1, 3));
	}
	
	private static int getSum(int i, int j) {
		if(i < 0 || j > st.length-1 || i > j){
			System.out.println("Wrong intput.");
			return -1;
		}
		return getSumUtil(0, st.length-1, i, j, 0);
	}

	@SuppressWarnings("unused")
	private static void updateValue(int[] arr, int[] st2, int length, int i, int j) {	
		//TODO
	}
	
	// i and j query range
	// ss and se - start and end index of segment of current node st[idx]
	private static int getSumUtil(int ss, int se, int i, int j, int idx) {
		 // If segment of this node is outside the given range
	    if (se < i || ss > j || idx > st.length)// || ((2*idx)+1 < st.length))
	        return 0;
		
		// If segment of this node is a part of given range, then return sum of the segment
		if (i <= ss && j >= se){
			System.out.println("i "+i+" j "+j+" ss "+ss+" se "+se);
			System.out.println("idx "+idx);
			return st[idx];
		}
				
		
		
		// If a part of this segment overlaps with the given range
	    int mid = (se-ss)/2+ss;
	    //System.out.println("(2*idx)+1 "+(2*idx)+1);
	    return getSumUtil(ss, mid, i, j, (2*idx)+1) + getSumUtil(mid+1, se, i, j, (2*idx)+2);
	}
	
	private static void constructST(int[] arr, int length) {
		// n leaf nodes and n-1 internal nodes
// http://stackoverflow.com/questions/28470692/how-is-the-memory-of-the-array-of-segment-tree-2-2-ceillogn-1
		double height = Math.ceil(Math.log10(length)/Math.log10(2));
		double msize = 2*Math.pow(2, height)-1;
		System.out.println(msize);
		st = new int[(int) msize];
		
		constructSTUtil(arr, 0, arr.length-1, 0);
		System.out.println("SegTree: "+Arrays.toString(st));
	}

	private static int constructSTUtil(int[] arr, int low, int hi, int idx) {
		// If there is one element in array, store it in current node of segment tree and return
		if(low == hi){
			st[idx] = arr[low];
			return st[idx];
		}
		
		// If there are more than one elements, then recur for left and 
		// right subtrees and store the sum of values in this node
		
		int mid = (hi-low)/2+low;
		st[idx] = constructSTUtil(arr, low, mid, (2*idx)+1) + constructSTUtil(arr, mid+1, hi, (2*idx)+2);	
		return st[idx];
	}

}
