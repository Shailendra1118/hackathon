package com.booking.ques;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FunnyJava {

	@SuppressWarnings("all")
	public static void main(String args[]){
		System.out.println('d'-'a');
		//System.out.println(16>>4);
		//sort the hash-map based on values
		HashMap map = new HashMap();
		map.put("One", 1);
		map.put("Seven", 7);
		map.put("Three", 3);
		map.put("Three2", 3);
		map.put("Four", 4);
		
		TreeMap tree = new TreeMap(new Comparator() {
			@Override
			public int compare(Object o1, Object o2) {
				Entry e1 = (Entry) o1;
				//String e2 = (String) o2;
				Entry e2 = (Entry) o2;
				//Integer v1 = (Integer) e1.getValue();
				//v1 = v1.intValue();				
				//Integer v2 = (Integer) e2.getValue();
				//v2 = v2.intValue();				
				return ((Integer)e1.getValue()).compareTo((Integer) e2.getValue());
					
			}
			
		});
		
		TreeMap tree1 = new TreeMap(map);
		
		
		List list = new ArrayList();
		list.addAll(map.entrySet());
		
		//tree.putAll(map); //tree use comparator to call compareTo method on keys only`
		Collections.sort(list, tree.comparator());
		System.out.println(list);
		
		Iterator iter = tree1.entrySet().iterator();
		while(iter.hasNext()){
			Entry obj = (Entry) iter.next();
			System.out.println(obj.getKey()+"-"+obj.getValue());
		}
		
	}
}
