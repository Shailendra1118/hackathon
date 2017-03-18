package com.march.prac.three;

import java.util.ArrayList;
import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		Product p1 = new Product(12, "Nike", null);
		Product p2 = new Product(12, "Adidas", null);
		Product p3 = new Product(12, "Puma", null);
		Product p4 = new Product(12, "Lotto", null);
		Product[] arr = new Product[4];
		ArrayList<Product> list = new ArrayList<>();
		list.add(p4);
		list.add(p3);
		list.add(p2);
		list.add(p1);
		arr = list.toArray(new Product[0]);		
		list.forEach(item->System.out.print(item+" "));
		sortIt(arr);
		System.out.println();
		System.out.println("After sorting...");
		list = new ArrayList<Product>(Arrays.asList(arr));
		list.forEach(item->System.out.print(item+" "));
	}

	private static void sortIt(Comparable<Product>[] arr) {
		for (int i = 1; i < arr.length; i++) {
			for (int j = i; j > 0; j--) {
				if(less(arr[j], arr[j-1])){
					exch(arr, j, j-1);
				}
			}
		}
	}
	
	private static boolean less(Comparable<Product> a, Comparable<Product> b){
		return a.compareTo((Product) b) < 0;
	}
	
	private static void exch(Comparable<Product>[] arr, int i, int j){   //Comparable a, Comparable b){
		Comparable<Product> temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	

}


class Product implements Comparable<Product>{
	Integer id;
	String type;
	String section;
	public Product(Integer id, String type, String section){
		this.id = id;
		this.type = type;
		this.section = section;
	}
	@Override
	public int compareTo(Product o) {
		return this.type.compareTo(o.type);
	}
	
	public String toString(){
		return id+":"+type;
	}
}
