package com.amazon.asked;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;


public class TopView {

	static TreeMap<Integer, Node> set = new TreeMap<Integer, Node>(); //use dist with list for node ??
	public static void main(String[] args) {
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		Node nine = new Node(9);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		six.right = eight;
		seven.right = nine;
		
		printTop(one, 0);
		Iterator<Entry<Integer, Node>> iter = set.entrySet().iterator();
		while(iter.hasNext()){
			System.out.println(iter.next().getValue().data);
		}

	}
	
	private static void printTop(Node node, int dist) {
		if(node == null)
			return;
		printTop(node.left, dist-1);
		set.put(dist, node);
		System.out.println("adding dist "+dist+" for node "+node.data);
		printTop(node.right, dist+1);
		
	}

	static class Node{
		int data;
		Node left, right;
		
		public Node(int data, Node left, Node right){
			this.data = data;
			this.left = left;
			this.right = right;
		}
		public Node(int data){
			this.data = data;
		}
	}

}
