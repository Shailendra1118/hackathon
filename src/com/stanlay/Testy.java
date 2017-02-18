package com.stanlay;

import java.util.Arrays;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Testy {

	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		lock.lock();
		System.out.println(args.getClass().getName());
		System.out.println(args.getClass().getSuperclass().getSuperclass());
		//System.out.println(this); //cannot use in static context
		Testy t = new Testy();
		System.out.println(t.getClass().getSuperclass().getSuperclass());
		
		String arr[] = {"New York City", "Banglore", "London","Delhi","San Fransisco"};
		Arrays.sort(arr, new myComp());
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.binarySearch(arr, "Delhi"));
	}
	
	static void showIt(){
		Object obj = new Object();
		System.out.println(obj.getClass());
		//System.out.println(showIt());
	}
	
	

}

class myComp implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}

	
	
	
}
