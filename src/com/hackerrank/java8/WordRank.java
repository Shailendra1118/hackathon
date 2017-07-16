package com.hackerrank.java8;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class WordRank {

	public static void main(String[] args) {
		 //Scanner s = new Scanner(System.in);
	        int N = 1;//s.nextInt();

	        for (int i = 0; i < N; i++) {
	           //String ip = s.nextLine();
	           //String arr[] = ip.split(" ");
	           String str = "abc"; //arr[0];
	           int pos = 5; //Integer.parseInt(arr[1]);
	           process(str, pos);
	        }

	        
	        //s.close();
	}
	
	private static void process(String str, int pos){
        Set<String> set = new TreeSet<>();
        for(int i=0; i<str.length(); i++){
            for(int j=i+1; j<str.length(); j++){
                char tempc[] = str.toCharArray();
                swapStore(tempc, i, j, set);
            }
        }
        set.forEach(s->(System.out.println(s)));
    }
    
    private static void swapStore(char[] arr, int i, int j, Set<String> set){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        String one = new String(arr);
        set.add(one);
        System.out.println(one+" is added.");
    }

}
