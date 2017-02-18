package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Combination { //its actually Combination problem
	
	static HashMap<Integer, Long> map = new HashMap<>();
	public static void main(String[] args) throws FileNotFoundException {
		int total = -1, picked = -1;
		Scanner scan = new Scanner(new File("D:/Keppler/Hackerrank/src/com/practice/april/input.txt"));
		String size = scan.next();
		for (int i = 0; i < Integer.valueOf(size); i++) {
			total = Integer.valueOf(scan.next());
			picked = Integer.valueOf(scan.next());
			System.out.println(combine(total,picked) % 142857);
			//System.out.println(map.keySet()+" "+map.values());
		}
		
		scan.close();
		
		
	}

	private static Long combine(int total, int picked) {
		int denominator = (total-picked);
		if(denominator == 0)
            denominator = 1;
		
		if(picked == 0)
			picked = 1;
		return (Long) (factorial(total)/(factorial(picked) * factorial(denominator)));
		//return factorial(total)/factorial(total-picked);
	}

	private static Long factorial(int i) {
		Long result = (long) i;
		if(map.containsKey(i))
			return map.get(i);
		if(i == 1)
			return 1L;
		result = result * factorial(i-1);
		map.put(i, (long) result);
		return result;
	}

}
