package com.funds.karumanchi;

import java.util.Stack;

public class TopView {

	public static void main(String[] args) {
		Nodei root = new Nodei(3);
		root.left = new Nodei(5);
		root.right = new Nodei(2);
		root.left.left = new Nodei(1);
		root.left.right = new Nodei(4);
		root.right.left = new Nodei(6);
		root.right.right = new Nodei(7);
		//top_view(root);
		topView(root);
	}
	
	private static void topView(Nodei root) {
		if(root.left != null)
			leftT(root.left);
		
		System.out.print(root.data+" ");
		
		if(root.right != null)
			rightT(root.right);
	}

	static void top_view(Nodei root) 
	{   
		Nodei node = root;
	    Stack<Nodei> s = new Stack<>();
	    while(node != null){
	        s.push(node);
	        node = node.left;
	    }
	    printStack(s);
	    node = root.right;
	    while(node != null){
	    	System.out.print(node.data+" ");
	        node = node.right;
	    }
	    //printStack(s);
	  
	}

	private static void printStack(Stack<Nodei> s) {
		while(! s.isEmpty()){
			System.out.print(s.pop().data+" ");
		}
	}
	
	private static void leftT(Nodei left){
	    if(left == null){
	        return;
	    }
	    leftT(left.left);
	    System.out.print(left.data+" ");
	}
	
	private static void rightT(Nodei node){
	    if(node == null){
	        return;
	    }
	    System.out.print(node.data+" ");
	    rightT(node.right);
	   
	}

}

class Nodei{
	int data;
	Nodei left;
	Nodei right;
	
	Nodei(int data){
		this.data = data;
	}
}
