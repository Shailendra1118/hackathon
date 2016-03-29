package com.hackerrank.warmup;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

/*
 * Q2. Given a stream of characters (e.g. acacabcatghhellomvnsdb) and a list of words 
 * (e.g. [ "aca","cat","hello","world"] ) find and display count of each and every word once the stream ends.
 * (Like : "aca" : 2 , "cat" : 1 , "hello" : 1 , "world" : 0 ).
 *  [ Use LPS to make this counting online ].
 */



public class CountWords {

	static String input = "dogsdfsdfcatoioidsheepdfdfefefgegrhhecowfdfdcowsderer";
	static HashMap<String,Integer> dictionary = new HashMap<String,Integer>();
	static HashMap<String, Integer> map = new HashMap<>();
	
	public static void main(String[] args) {
		
		dictionary.put("dog",0);
		dictionary.put("sheep",0);
		dictionary.put("cat",0);
		dictionary.put("cow",0);
		
		countWords();
		countWordsWithTrie();
	}
	
	private static void countWordsWithTrie() {
		
		
	}

	private static void countWords() {
		int start = 0;
		while(start<input.length()-1){
			for(int i=start; i<input.length(); i++){
				String s = null;
				String f = input.substring(start,i);
				if(i+1 <input.length())
					s = input.substring(i+1, input.length()-1);
				System.out.println("first-"+f+" second-"+s);
				if(dictionary.containsKey(f)){
					dictionary.put(f, dictionary.get(f)+1);
				}
				if(dictionary.containsKey(s)){
					dictionary.put(s, dictionary.get(s)+1);
				}	
				
			}
			start++;
			System.out.println("START "+start);
		}
		printDictionary();
		
	}

	private static void printDictionary() {
		Iterator<Entry<String, Integer>> iter = dictionary.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String,Integer> entry = iter.next();
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
	}

}
