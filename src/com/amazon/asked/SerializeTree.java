package com.amazon.asked;

import java.util.Arrays;

public class SerializeTree {

	// at h total numbers of nodes n^h
	// total nodes in the tree 2^h+1 -1; root's height is 0
	static int ser[] = new int[24];
	static int idx = 0;
	public static void main(String[] args) {
		Node n6 = new Node(6, null, null);
		Node n7 = new Node(7, null, null);
		Node n8 = new Node(8, null, null);
		Node n3 = new Node(3, null, null);
		Node n4 = new Node(4, n6, n7);
		Node n2 = new Node(2, n3, n4);
		Node n5 = new Node(5, null, n8);
		Node n1 = new Node(1, n2, n5);
		
		serialize(n1);
		System.out.println(Arrays.toString(ser));
		// Node root = new Node(99, null, null);
		deserialize(n1, 1);
		printTree(n1);
	}
	
	

	private static void printTree(Node root) {
		if(root == null)
			return;
		printTree(root.left);
		System.out.print(root.data+" ");
		printTree(root.right);
	}



	private static void deserialize(Node node, int idx) {
		if(idx >= ser.length)
			return;
		if(ser[idx] == -1 || ser[idx] == 0)
			return;
		
		node = new Node(ser[idx], null, null);
		deserialize(node.left, idx+1);
		deserialize(node.right, idx+1);
		
	}



	private static void serialize(Node n) {
		// preorder DLR
		if(n == null){
			ser[idx++] = -1;
			return;
		}
		ser[idx++] = n.data;
		serialize(n.left);
		serialize(n.right);
		
	}

	static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data, Node l, Node r){
			this.data = data;
			this.left = l;
			this.right = r;
		}
	}

}
