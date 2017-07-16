package com.funds.karumanchi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Trending {

	public static void main(String[] args) throws FileNotFoundException {

		Map<String, Integer> map = new HashMap<>();
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\funds\\karumanchi\\Twitter.txt"));
		int total = s.nextInt();
		for (int i = 0; i < total; i++) {
			String str = s.next();
			if(map.containsKey(str)){
				map.put(str, map.get(str)+1);
			}else{
				map.put(str, 1);
			}
		}
		s.close();
		
		map.forEach((k,v) -> {
			//System.out.println(k+" "+v);
		});
		
		/*
		List<Entry<String, Integer>> list = map.entrySet().stream().collect(Collectors.toList());
		list.sort((o1, o2) -> {
			if(o1.getValue().equals(o2.getValue())){
				return o1.getKey().compareTo(o2.getKey());
			}else{
				return o2.getValue().compareTo(o1.getValue());
			}
				
		});
		//list.forEach(System.out :: println);
		Map<String, Integer> nmap = new LinkedHashMap<>();		
		list.forEach( e -> nmap.put(e.getKey(), e.getValue()));
		nmap.forEach((k,v) -> System.out.println(k+" "+v));
		*/
		
		/*
		Map<String, Integer> nmap = new LinkedHashMap<>();
		map.entrySet().stream().sorted((o1, o2) -> {
			if(o1.getValue().equals(o2.getValue())){
				return o1.getKey().compareTo(o2.getKey());
			}else{
				return o2.getValue().compareTo(o1.getValue());
			}
				
		}).forEach(e -> nmap.put(e.getKey(), e.getValue()));
		*/
		
		Map<String, Integer> nmap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByKey()).forEach(e -> nmap.put(e.getKey(), e.getValue()));
		
		nmap.forEach((k,v) -> {
			System.out.println(k+" "+v);
		});
	}

}
