package com.random.bits;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class MapSort {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(100, 5);
		map.put(200, 4);
		map.put(300, 3);
		map.put(400, 2);
		
		Iterator<Entry<Integer, Integer>> itr = map.entrySet().iterator();
		while(itr.hasNext()){
			Entry<Integer, Integer> e = itr.next();
			System.out.println(e.getKey()+" "+e.getValue());
		}
		
		TreeMap<Integer, Integer> tree = new TreeMap<>();
		tree.putAll(map);		
		System.out.println(tree);
		
		java.util.List<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer,Integer>>(map.entrySet());
		/*
		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();
		while(it.hasNext()){
			list.add(it.next());
		}
		*/
		Collections.sort(list, new MapSort().new ValueComp());
		System.out.println(list);
		
		//put back to hashmap
		Iterator<Entry<Integer, Integer>> it1 = list.iterator();
		Map<Integer,Integer> resultMap = new LinkedHashMap<>();
		while(it1.hasNext()){
			Entry<Integer,Integer> ent = it1.next();
			resultMap.put(ent.getKey(),ent.getValue());
		}
		
		System.out.println("After sorting -");
		System.out.println(resultMap);
		
	}
	
	class ValueComp implements Comparator<Entry<Integer, Integer>>{

		@Override
		public int compare(Entry<Integer, Integer> o1,
				Entry<Integer, Integer> o2) {
			if(o1.getValue() > o2.getValue())
			return 1;
			else
				if(o1.getValue() < o2.getValue())
					return -1;
				else
					return 0;
		}
		
	}

}
