package com.booking.ques;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWrite {
	public static void main(String args[]){
		List<String> list = new CopyOnWriteArrayList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			String val = iter.next();
			System.out.println(val);
			if(val.equals("3")){
				list.remove("4");
				list.add("5");
				list.add("7");
			}
		}
		
		System.out.println("-----");
		Iterator<String> iter1 = list.iterator();
		while(iter1.hasNext())
			System.out.println(iter1.next());
		
	}
}
