package com.hackerrank.warmup.tree;

public class FindDist {

	
	public static void main(String[] args) {
	
		Node one = new Node(1);
		Node two = new Node(2);
		Node three = new Node(3);
		Node four = new Node(4);
		Node five = new Node(5);
		Node six = new Node(6);
		Node seven = new Node(7);
		Node eight = new Node(8);
		
		one.left = two;
		one.right = three;
		two.left = four;
		two.right = five;
		three.left = six;
		three.right = seven;
		six.right = eight;
		
		int res = findDistance(one, 6, 8);
		System.out.println("res: "+res);
	}
	
	
	private static int findDistance(Node node, int x, int y) {
		
		if(node == null)
			return 0;
		
		int leftd = findDepth(node, x, 1);
		int rightd = findDepth(node, y, 1);
		System.out.println("left dep: "+leftd+" right dept: "+rightd);
		
		//find LCA
		int d = 0;
		Node lca = findLCA(node, x, y);
		if(leftd != -1 && rightd != -1){
			d = leftd + rightd - 2*lca.data;
		}
		
		return d;
	}


	private static Node findLCA(Node node, int x, int y) {
		if(node == null)
			return null;
		
		if(node.data == x || node.data == y){
			return node;
		}
		Node llca = findLCA(node.left, x, y);
		Node rlca = findLCA(node.right, x, y);
		
		if(llca != null && rlca != null){
			return node;
		}
		else if(llca != null){
			return llca;
		}else
			return rlca;
	}


	private static int findDepth(Node node, int k, int level) {
		if(node == null)
			return -1;
		
		if(node.data == k){
			return level;			
		}
		int left = findDepth(node.left, k, level+1);
		if(left != -1)
			return left;
		else return findDepth(node.right, k, level+1);
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
