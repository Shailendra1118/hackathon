package com.funds.karumanchi;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MTree {

	static int ctr = 0;
	public static void main(String[] args) throws Exception {
		int ctr = 0;
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\input\\sbtree.txt"));
		List<xNode> list = new ArrayList<xNode>();
		int n = scan.nextInt();
		for(int i=0; i<n; i++){
		    int val = scan.nextInt();
		    xNode node = new MTree(). new xNode(val, null);
		    list.add(node);
		}
		while(scan.hasNext()){
		    int a = scan.nextInt();
		    int b = scan.nextInt();
		    xNode na = list.get(a);
		    xNode nb = list.get(b);
		    if(na.childs == null)
		    	na.childs = new ArrayList<xNode>();
		    na.childs.add(nb);	
		    	
		   
		}
		xNode root = list.get(0);
		System.out.println("root: "+root.data);
		for (int i = 0; i < root.childs.size(); i++) {
			countUni(root, root.childs.get(i));
		}
				
		System.out.println("counter: "+(ctr));
		scan.close();

	}
	
	
	private static boolean countUni(xNode node, xNode child) {
		boolean flag = true;
		if(node == null ){
			return true;
		}		
		if(node.data != child.data)
			return false;
		
		for (int i = 0; node.childs != null && i < node.childs.size(); i++) {
			child = node.childs.get(i);
			boolean arr[] = new boolean[5];
			int c = 0;
			arr[c++] = countUni(node, child);
			if(isAll(arr)){
				ctr++;
				flag = true;
			}
		}
		
		return flag;
	
	}
	
	private static boolean isAll(boolean[] arr) {
		boolean flag = true; 
		for (int i = 0; i < arr.length; i++) {
			if(! arr[i]){
				flag = false;
				break;
			}
		}
		return flag;
	}


	private static boolean countUniRec(xNode node, xNode child){
		if(child == null ){
			return true;
		}
		
		if(child.data != node.data)
			return false;
		
		return true;
	}
	
	
	class xNode{
	    int data;
	    List<xNode> childs;
	    xNode(int data, List<xNode> c){
	        this.data = data;
	        this.childs = c;
	        
	    }
	}

}


