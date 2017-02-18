package com.hackerrank.warmup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FanFollow {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner scanner = new Scanner(System.in);
		Scanner scanner = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\input\\follow.txt"));
		int size = scanner.nextInt();
		int out = scanner.nextInt();
		TreeMap<Integer,List<String>> map = new TreeMap<>(new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o1);
			}
			
		});
		for (int i = 0; i < size; i++) {
			String str = scanner.next();
			int score = Integer.valueOf(scanner.next());
			if(map.containsKey(score)){
				List<String> val = map.get(score);
				val.add(str);
			}else{
				List<String> list = new ArrayList<>();
				list.add(str);
				map.put(score, list);
			}			
		}
		
		
		int count = 0;
		for(Map.Entry<Integer, List<String>> entry : map.entrySet()){
			//System.out.println("count is "+count);
			if(count < out){			
				Collections.sort(entry.getValue());
				for (int i = 0; i < entry.getValue().size() && (count < out); i++) {
					System.out.println(entry.getValue().get(i));
					count++;
				}			
			}else
				break;
		}

		
		
		scanner.close();
	}

}
