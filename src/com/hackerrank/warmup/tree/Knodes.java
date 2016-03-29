package com.hackerrank.warmup.tree;

public class Knodes {

	public static void main(String[] args) {
		Node root = new Node(20);
		root.left = new Node(8);
		root.right = new Node(22);
		
		root.left.left = new Node(4);
		root.left.right = new Node(12);
		root.left.right.left = new Node(10);
		root.left.right.right = new Node(14);
	
		//find nodes from root of distance k = 2
		findKNodes(root, root.left, 2);
	}

	private static int findKNodes(Node node, Node target, int k) {
//		if(node == null)
//			return -1;
//		
//		if(node == target){
//			findNodesDown(node, k);
//			return 0;			
//		}
			
		return 0;
		
	}

	private static void findNodesDown(Node root, int k) {
		if(root == null || k<0)
			return;
		
		findNodesDown(root.left, k-1);
		findNodesDown(root.right, k-1);
		if(k == 0){
			System.out.println(root.data);
		}
		
	}
	
	
	

}
