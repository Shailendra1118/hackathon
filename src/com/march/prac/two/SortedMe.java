package com.march.prac.two;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortedMe {

	public static void main(String[] args) {
		
		Temp t1 = new Temp(10.16);
		Temp t2 = new Temp(10.08);
		Temp t3 = new Temp(10.00);
		
		Temp t4 = new Temp(10.18);
		Temp t5 = new Temp(10.20);
		Temp t6 = new Temp(10.26);
		List<Temp> list = new ArrayList<>();
		list.add(t3);
		list.add(t2);
		list.add(t1);
		list.add(t4);
		list.add(t5);
		list.add(t6);
		Collections.sort(list);
		System.out.println(list.toString());

	}
	
	private static class Temp implements Comparable<Temp>{
		
		private double degree = 0.0; 
		private Temp(double d){
			if(Double.isNaN(d))
				throw new IllegalArgumentException();
			this.degree = d;
		}
		
		@Override
		public int compareTo(Temp o) {
			//double EPSILON = 0.1; Should not use any fudge factor while using comparable
		System.out.println("compareTo method call- ");		
			if(this.degree < o.degree) { // - EPSILON)				
				return -1;
			}
			else if(this.degree > o.degree) { // + EPSILON)
				
				return 1;
			}
			else {
				return 0;
			}
		}
		
		public String toString(){
			return String.valueOf(degree);
		}
		
	}

}
