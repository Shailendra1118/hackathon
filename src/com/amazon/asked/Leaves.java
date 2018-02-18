package com.amazon.asked;

import java.util.ArrayList;
import java.util.List;

public class Leaves {
	
	private class Node{
		int data;
		Node left;
		Node right;
		
		Node(int data, Node l, Node r){
			this.data = data;
			this.left = l;
			this.right = r;
		}
	}

	public static void main(String[] args) {
		List<Leaves.Node> list = new ArrayList<>();
		Leaves obj = new Leaves();
		list.add(obj.new Node(1, null,null));
		list.add(obj.new Node(2, null,null));
		list.add(obj.new Node(3, null,null));
		list.add(obj.new Node(4, null,null));
		list.add(obj.new Node(5, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(6, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(-1, null,null));
		list.add(obj.new Node(7, null,null));
		list.add(obj.new Node(8, null,null));
		Node root = buildTree(list);
		int width = findW(root);
		System.out.println("width: "+width);
		printZig(root);
	}

	private static void printZig(Node root) {
		int h = height(root);
		System.out.println("height: "+h);
		boolean flag = true;
		for (int i = 1; i <= h; i++) {
			printLevel(root, i, flag);
			System.out.println();
			if(flag)
				flag = false;
			else 
				flag = true;
		}
	}

	private static void printLevel(Node root, int level, boolean flag) {
		if(root == null)
			return;		
		if(level == 1)
			System.out.print(root.data);
		else if(level > 1){
			if(flag){
				printLevel(root.left, level-1, flag);
				printLevel(root.right, level-1, flag);
			}else{
				printLevel(root.right, level-1, flag);
				printLevel(root.left, level-1, flag);
				
			}
		}
	}

	private static int height(Node root) {
		if(root == null)
			return 0;
		else{
			return Math.max(1+height(root.left), 1+height(root.right));
		}
	}

	private static int findW(Node node) {
		if(node == null)
			return 0;
		int lmx = findLmx(node.left);
		int rmx = findRmx(node.right);
		return rmx+lmx;
	}
	
	

	private static int findRmx(Node right) {
		if(right == null)
			return 0;
		int lmx = 1 + findRmx(right.right);
		return lmx;
	}

	private static int findLmx(Node left) {
		if(left == null)
			return 0;
		int lmx = 1 + findLmx(left.left);
		return lmx;
	}

	private static Leaves.Node buildTree(List<Leaves.Node> list) {
		Object arr[] =  list.toArray();
		Leaves.Node root = (Leaves.Node) arr[0];
		for(int i=0; i<arr.length; i++){
			Node n = (Leaves.Node)arr[i];
			if((2*i+1) < arr.length){
				Leaves.Node an = (Leaves.Node)arr[2*i+1];
				if(an.data == -1)
					n.left = null;
				else
					n.left = (Leaves.Node)arr[2*i+1];
			}else
				n.left = null;
			
			if((2*i+2) < arr.length){
				Leaves.Node an = (Leaves.Node)arr[2*i+2];
				if(an.data == -1)
					n.right = null;
				else
					n.right = (Leaves.Node)arr[2*i+2];
			}else
				n.right = null;
		}
		return root;
	}

}


