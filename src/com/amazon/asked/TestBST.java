package com.amazon.asked;

public class TestBST {

	public static void main(String[] args) {
		Node root = new Node(6);
		root.left = new Node(3);
		root.right = new Node(7);
		root.left.left = new Node(1);
		root.left.right = new Node(8);
		
		int parent = 999;
		Node node = root;
		boolean isBST = true;
		while(true){
			if(node.left != null && node.left.data < node.data && node.left.data < parent){
				parent = node.data;
				//node = node.left;
				//continue;
			}
			
			if(node.right != null && node.right.data > node.data && node.right.data < parent){
				parent = node.data;
				node = node.right;
				//continue;
			}//else if(node.right != null){
			//	isBST = false;
			//}
			
			//if(! isBST)
			//	break;
				
		}

	}

}
