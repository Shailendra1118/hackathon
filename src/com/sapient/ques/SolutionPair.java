package com.sapient.ques;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SolutionPair{
	public static void main(String[] args) throws FileNotFoundException {	
		File file = new File("D:\\Keppler\\Hackerrank\\src\\com\\sapient\\ques\\test.txt");
		Scanner scan = new Scanner(file);
	    //Scanner scan = //new Scanner(System.in);
		//int size = scan.nextInt();
		//System.out.println(size);
		
		HashSet<Pair> set = new HashSet<>();
	    while(scan.hasNext()){
	        String input = scan.nextLine();
	        if(input.equals("5"))
	        	continue;
	        //System.out.println("input "+input);
	        StringTokenizer tokenizer = new StringTokenizer(input," ");
	        //System.out.println(tokenizer.nextToken());
	        //String [] arr = input.split(" ");	        
	        set.add(new Pair(tokenizer.nextToken(),tokenizer.nextToken()));
	       // System.out.println(arr[0]+" - "+arr[1]);
	        System.out.println(set.size());
	    }
	    scan.close();
	}
	
	static class Pair {
	    String first;
	    String second;
	    
	    public Pair(String f, String s){
	    	this.first = f;
	    	this.second = s;
	    }
	
		public boolean equals(Object obj){
			if(obj == null || this == null)
				return false;
			if(obj instanceof Pair){
				Pair otherObj = (Pair) obj;
				if(otherObj.first.equals(first) && otherObj.second.equals(second)){
					return true;
				}
			}
			return false;			
		}
		
		public int hashCode(){
			int prime = 31;
			int code = 1;
			code = prime*code;
			code = code + this.first.hashCode() + this.second.hashCode();
			return code;
		}
	    
	}
}