package com.hackerrank.warmup;

import java.util.ArrayList;

class Node{
	int data = 0;
	Node right = null;
	Node left = null;
	
	Node(int data){
		this.data = data;
	}
}

public class NodeDistance {
	
	public static ArrayList<Integer> path = new ArrayList<Integer>();

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		
		//System.out.println(findLCA(root, 4,6).data);
		printPath(root, root.right.right);
		//System.out.println("  final path "+path);
	}

	private static Boolean printPath(Node root, Node dest) {
	
			if(root==null) 
				return false;
			if(root==dest||printPath(root.left,dest)||printPath(root.right,dest)){
				System.out.print("  " + root.data);
				path.add(root.data);
				return true;
			}
			return false;
		}
	

	private static Node findLCA(Node node, int n1, int n2) {
		if(node == null)
			return null;
		
		if(node.data == n1 || node.data == n2){
			return node;
		}
		
		Node left_lca = findLCA(node.left, n1, n2);
		Node right_lca = findLCA(node.right, n1, n2);
		
		if(left_lca != null && right_lca != null){
			return node;
		}
		
		if(left_lca == null){
			return right_lca; 
		}
		else return left_lca;
		
	}

}


