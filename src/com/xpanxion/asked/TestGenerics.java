package com.xpanxion.asked;

import java.util.ArrayList;
import java.util.List;

public class TestGenerics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<?>list = new ArrayList<>();
		//list.add(new Object());
		
		List<Integer>listy = new ArrayList<>();
		listy.add(new Integer(4));
		
		doSome(listy);
		
		
	}
	
	public static void doSome(List<?> listy){
		for(Object num: listy){
			System.out.println(num);
		}
	}

}
