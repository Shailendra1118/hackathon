package com.amazon.asked;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class ToMoon {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("D:/Keppler/Hackerrank/src/com/amazon/asked/toMoon.txt"));
		int total = scan.nextInt();
		int lines = scan.nextInt();		
	
		//HashMap<Integer,Set<Integer>> map = new HashMap<>();
		List<Set<Integer>> list = new ArrayList<>();
		int i = 0;
		for (; i < lines; i++) {
			int a = scan.nextInt();
			int b = scan.nextInt(); 
			HashSet<Integer> set = new HashSet<>();
			set.add(a);
			set.add(b);
			list.add(set);
			merge(list);
		}
		
		list.forEach(a-> System.out.println(a));
		int x = 0;
		for (int j = 0; j < total; j++) {
			Integer obj = j;
			Object[] f = list.stream().toArray();
			System.out.println(f[0]+": "+f[1]);
		}
		
		
		
		//list.stream().forEach(t->System.out.println(t));
		
//		int num = 0;
//		for (int i = total-2; i >= 2; i=i-2) {
//			num = num + (i*2);
//		}
//		System.out.println("num: "+num);
		scan.close();
	}

	private static void merge(List<Set<Integer>> list) {
		// TODO Auto-generated method stub
		
	}

}
