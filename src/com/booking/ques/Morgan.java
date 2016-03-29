package com.booking.ques;

import java.util.Hashtable;
import java.util.Map;

public class Morgan {

	public static void main(String[] args) {
		
		Map<Key, Integer> map = new Hashtable<>();
		Key key = new Key(10);
		map.put(key, 100);
		System.out.println(String.format("Output 1: %d", map.get(key)));
		
		key.setVal(12);
		System.out.println(String.format("Output 2: %d", map.get(key)));
		
		key.setVal(10);
		System.out.println(String.format("Output 3: %d", map.get(key)));
		
		key = new Key(10);
		System.out.println(String.format("Output 4: %d", map.get(key)));
		
		key = new Key(12);
		System.out.println(String.format("Output 5: %d", map.get(key)));
		System.out.println(String.format("Output 6: %d", map.put(key, 110)));

		key = new Key(10);
		System.out.println(String.format("Output 7: %d", map.put(key, 120)));
		
		System.out.println(String.format("Output 8: %d", map.size()));
	}
	
	static class Key{
		private int val;
		public Key(int val){
			this.val = val;
		}
		
		public int hashCode(){
			return val;
		}
		
		public boolean equals(Object obj){
			return super.equals(obj);
		}
		
		public void setVal(int i){
			this.val = i;
		}
	}

}
