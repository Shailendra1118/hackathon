package com.booking.again;

import java.util.HashMap;
import java.util.Map;

public class FrequencyMap {

	public static void main(String[] args) {
		int arr[] = {89, 23, 56, 3, 23, 8, 3, 2, 98, 89, 23};
		
		int res = foundMaxOccurring(arr);
		System.out.println("res: "+res);
	}

	private static int foundMaxOccurring(int[] arr) {
		int count = 0;
		int num = -1;
		
		if(arr.length == 0){
			throw new IllegalStateException();
		}
		Map<Integer, Integer> fm = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			if(fm.containsKey(arr[i])){
				int cur = fm.get(arr[i])+1;
				if(cur > count){
					count = cur;
					num = arr[i];
				}
				fm.put(arr[i],cur);
			}else{
				fm.put(arr[i], 1);
			}
		}
		return num;
	}

}
