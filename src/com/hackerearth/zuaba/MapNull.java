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
		
		String args1[] = {"-3", "-7"};
		        int c = 0;
		        for (String s: args1) {
		            Integer i = Integer.parseInt(s);
		            while (i > 0) {
		                if (i%2 == 1) {
		                    c++;
		                }
		                i >>= 1;
		            }
		        }
		        System.out.println(c);
		
		 Shape obj = new Circle();
		 Circle cobj = (Circle) obj.make();
		 System.out.println(cobj.getClass().getName());
		 //System.out.println(obj.make().getClass().getName());
		 
	}

}

class Shape{
	
	public Shape make(){
		return new Shape();
	}
}

class Circle extends Shape{
	
	public Circle make(){
		return new Circle();
	}
}

