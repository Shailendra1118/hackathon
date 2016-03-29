package com.hackerrank.warmup.tree;

import java.util.ArrayList;


class Node{
	int data = 0;
	Node right = null;
	Node left = null;
	
	Node(int data){
		this.data = data;
	}
}

public class FindPath {
	
	static ArrayList<Integer> path = new ArrayList<Integer>();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		Node dest1 = new Node(4);
		root.left.left = dest1;
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		Node dest = new Node(10);
		root.left.right.left = dest;
		root.right.left.right = new Node(11);
		root.right.left.right.right = new Node(12);
		Node uDest = new Node(22);
		root.right.left.right.right.left = uDest; 
		
		findPath(root, uDest);
		System.out.println(path);

	}

	private static Boolean findPath(Node cur, Node dest) {
		
		if(cur == null)
			return false;
		if(cur.data == dest.data || findPath(cur.left, dest) || findPath(cur.right, dest)){
			path.add(cur.data);
			return true;
		}else
			return false;
		
	}

}
