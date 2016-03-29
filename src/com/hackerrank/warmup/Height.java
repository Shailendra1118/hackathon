package com.hackerrank.warmup;

public class Height {	

	public static void main(String[] args) {
		
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.right.right.left = new Node(8);	
		//root.right.right.left.right = new Node(9);
		
		System.out.println(findHeight(root));
	}

	private static int findHeight(Node node) {
		if(node == null)
			return -1;
		
		int left = findHeight(node.left);
		int right = findHeight(node.right);
		System.out.println("L "+left+" R "+right);
		return Math.max(left, right)+1;
	}

}
