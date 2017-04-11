package com.zebra.hiring;

import java.util.ArrayList;

public class IntersectionList {

	public static void main(String[] args) {
		ArrayList<Integer> l1 = new ArrayList<>();
		l1.add(1);
		l1.add(2);
		l1.add(3);
		l1.add(4);
		
		ArrayList<Integer> l2 = new ArrayList<>();
		l2.add(3);
		l2.add(4);
		
		ArrayList<Integer> l3 = new ArrayList<>();
		l3.add(6);
		l3.add(5);
		
		l1.retainAll(l2);
		l1.retainAll(l3);
		System.out.println(l1);

	}

}
