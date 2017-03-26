package com.hackerearth.zuaba;

import java.util.HashMap;
import java.util.Map.Entry;

public class MapNull {

	public static void main(String[] args) {
		HashMap<String,Integer> map = new HashMap<>();
		map.put(null, null);
		//map.put(null, 100);
		
		for(Entry<String, Integer> e : map.entrySet()){
			System.out.println(e.getKey()+":"+e.getValue());
		}
		
		System.out.println(map.get(null));
		System.out.println(map.get("SomeKey"));
		
	}

}
