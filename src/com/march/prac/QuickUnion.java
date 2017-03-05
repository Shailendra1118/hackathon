package com.march.prac;

import java.util.Arrays;

public class QuickUnion {
	
	static int arr[] = null; //{ 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
	static int size[] = null; 
	
	public QuickUnion(int n){
		//System.out.println("QuickUnion constructed initialized.");
		int total = n*n;
		//System.out.println("with size: "+total);
		arr = new int[total+1];
		for (int i = 1; i < arr.length; i++) {
			arr[i] = i;
		}		
		//System.out.println("QU created: "+Arrays.toString(arr));
		size = new int[arr.length];
	}
	
	public QuickUnion(){
		System.out.println("default constructor");
	}
	public static void main(String[] args) {
		QuickUnion qu = new QuickUnion();
		
		qu.union(4, 3);	
		System.out.println(Arrays.toString(arr));
		qu.union(3, 8);		
		System.out.println(Arrays.toString(arr));
		qu.union(6, 5);		
		System.out.println(Arrays.toString(arr));
		qu.union(9, 4);
		System.out.println(Arrays.toString(arr));
		qu.union(2, 1);
		System.out.println(Arrays.toString(arr));
		qu.union(5, 0);
		System.out.println(Arrays.toString(arr));
		qu.union(7, 2);
		System.out.println(Arrays.toString(arr));
		qu.union(6, 1);
		//qu.union(7, 3);
		System.out.println(Arrays.toString(arr));
		System.out.println(qu.isConnected(7, 8));

	}
	
	private static int root(int a){		
		while(arr[a] != a){
			a = arr[a];
		}
		return a;
	}
	public boolean isConnected(int a, int b) {
		return root(a) == root(b);
		/*
		if(arr[a] == arr[b])
			return true;
		while(arr[a] != a){
			a = arr[a];
		}
		while(arr[b] != b){
			b = arr[b];
		}
		if(arr[a] == arr[b])
			return true;
		else 
			return false;
			*/
	}
	public void union(int a, int b) {
		if(arr[a] == a && arr[b] == b){
			arr[a] = b; 
			return;
		}
		int i = root(a);
		int j = root(b);
		if(i == j){
			//System.out.println("already connected");
			return;
		}
		if(size[i] < size[j]){
			arr[i] = arr[j];
			size[j] = size[j] + size[i];
		}else{
			arr[j] = arr[i];
			size[i] = size[i] + size[j];
		}
		
		/*
		while(arr[b] != b){
			b = arr[b];
		}		
		while(arr[a] != a){
			a = arr[a];
		}*/
		//arr[a] = arr[b];
	}
}
