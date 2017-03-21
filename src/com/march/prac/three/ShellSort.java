package com.march.prac.three;

import java.util.ArrayList;
import java.util.Arrays;

public class ShellSort {

	public static void main(String[] args) {
		Product p1 = new Product(12, "Nike", null);
		Product p2 = new Product(12, "Adidas", null);
		Product p3 = new Product(12, "Puma", null);
		Product p4 = new Product(12, "Lotto", null);
		Product p5 = new Product(12, "Asics", null);
		Product p6 = new Product(12, "NewBalance", null);
		Product p7 = new Product(12, "Sketchers", null);
		Product p8 = new Product(12, "Boku", null);
		Product p9 = new Product(12, "Fubu", null);
		Product p10 = new Product(12, "DC", null);
		Product p11 = new Product(12, "Crocs", null);
		
		Product[] arr = new Product[4];
		ArrayList<Product> list = new ArrayList<>();
		list.add(p4);
		list.add(p3);
		list.add(p2);
		list.add(p1);
		list.add(p5);
		list.add(p6);
		list.add(p7);
		list.add(p8);
		list.add(p9);
		list.add(p10);
		list.add(p11);
		arr = list.toArray(new Product[0]);		
		list.forEach(item->System.out.print(item+" "));
		sortIt(arr);
		System.out.println();
		//System.out.println("After sorting...");
		list = new ArrayList<Product>(Arrays.asList(arr));
		list.forEach(item->System.out.print(item+" "));

	}

	private static void sortIt(Comparable<Product>[] arr) {
		
		int n = arr.length;
		int h = 1;
		while(h < n/3){
			h = 3*h+1;
		}
		while(h>=1){
			// h-sort the array
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h; j=j-h) {
					if(less(arr[j], arr[j-h]))
						exch(arr, j, j-h);					
				}				
			}
			h = h/3;
		}		
	}
	
	@SuppressWarnings("unused")
	private static int maxJump(int length) {
		// using 3x+1 formula
		return (length-1)/3;
	}

	private static boolean less(Comparable<Product> a, Comparable<Product> b){
		return a.compareTo((Product) b) < 0;
	}
	
	private static void exch(Comparable<Product>[] arr, int i, int j){ 
		Comparable<Product> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
