package com.booking.ques;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

class TrieNode{
	//int [] data;
	//TrieNode next;
	char c = '*';
	TrieNode[] children = new TrieNode[26];
	boolean isLeaf = false;
	String item = "";
	TrieNode(char c){
		//this.data = new int[10000];
		//System.out.println("value-"+value+" "+Integer.valueOf(value));
		//this.data[value] = value;
		this.c = c;		
	}

	public TrieNode() {
		// TODO Auto-generated constructor stub
	}
}

class Trie{
	TrieNode root = new TrieNode();
	
	public void insertWord(String word){
		TrieNode node = root;
		char[] arr = word.toCharArray();
		for(int i = 0; i<word.length(); i++){
			char c = arr[i];
			if(node.children[c-'a'] == null)
				node.children[c-'a'] = new TrieNode(c);
			node = node.children[c-'a'];
			//System.out.println("filling trie "+node.item);
		}
		node.isLeaf = true;
		node.item = word;
		System.out.println("final trie item-"+node);
	}
	
	//search word
	 public boolean search(String word){
	        TrieNode node = root;
	        for(char c: word.toCharArray()){
	            if(node.children[c-'a'] == null)
	                return false;
	            node = node.children[c-'a'];
	        }
	        if(node.isLeaf){
	            return true;
	        }else{
	            return false;
	        }
	    }
}


public class WordCount {
	static String input = "asdfokoelkjodhellokhelocatolkjoihellowedf";
	static String[] bucket = new String[26];
	//Trie to store dictionary words
	static HashMap<String,Integer> map = new HashMap<>();
	public static void main(String arg[]){
		Trie tree = new Trie();
		tree.insertWord("hello");
		tree.insertWord("cat");
		fillMap();
		buildTrieForDictionary();
		printTrie();
		
		
		String toSearch ="";
		int len = 0;
		for(int i=0; i<input.length(); i++){
			char c = input.charAt(i);
			System.out.println("bucket "+bucket[c-'a']);
			if(bucket[c-'a'].startsWith(c+"")){
				String key = input.substring(i, i+bucket[c-'a'].length());
				if(key.equals(bucket[c-'a'])){
					if(map.containsKey(key)){
						int ctr = map.get(key);
						map.put(key, ++ctr);
					}else{
						map.put(key, 1);
					}
				}
			}
		}
		
		
		//fillMap();
	/*	for(int i = 0; i<input.length(); i++){
			char c = input.charAt(i);
			if(bucket[c] != null){
				//check this word contains dictionary word
				TrieNode node = bucket[c];
				if(node.data[c] == c){
					//assume word found for now
					if(c == 'h'){
						int hcount = map.get("hello");
						//hcount++; //BEWARE of post-increment gotcha
						map.put("hello", ++hcount);
						System.out.println("hello "+hcount);
					}else{
						int ccount = map.get("cat");
						//ccount++;
						map.put("cat", ++ccount);
						System.out.println("cat "+ccount);
					}
					
//					/if(input.substring(beginIndex, endIndex)))
					
				}
			}
		} */
		
		printMap();
		
	}

	private static void printTrie() {
		
	}

	private static void printMap() {
		// TODO Auto-generated method stub
		System.out.println("Final word count---");
		Iterator<Entry<String, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()){
			Entry e = iter.next();
			System.out.println(e.getKey()+":"+e.getValue());
		}
		
	}

	private static void fillMap() {
		// TODO Auto-generated method stub
		map.put("hello", 0);
		map.put("cat", 0);
		for(int i=0; i< bucket.length; i++)
			bucket[i] = "";
		
	}

	private static void buildTrieForDictionary() {
		String word1 = "hello";
		String word2 = "cat";
//		TrieNode a = new TrieNode('h');
//		TrieNode b = new TrieNode('e');
//		TrieNode c = new TrieNode('l');
//		TrieNode d = new TrieNode('l');
//		TrieNode e = new TrieNode('o');
//		a.next = b;
//		b.next = c;
//		c.next = d;
//		d.next = e;
//		
//		TrieNode a1 = new TrieNode('c');
//		TrieNode b1 = new TrieNode('a');
//		TrieNode c1 = new TrieNode('t');
//		a1.next = b1;
//		b1.next = c1;
//		TrieNode cat = a1;
//		TrieNode hello = a;
//		bucket['c'] = a1;
//		bucket['h'] = a;
		bucket['c'-'a'] = "cat";
		int x = 'c'-'a';
		System.out.println("c-a"+x);
		bucket['h'-'a'] = "hello";
		int y = 'h'-'a';
		System.out.println("h-a"+y);
		
	}
}
