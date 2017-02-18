package com.funds.karumanchi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MediaTree {
	public static int ctr = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\input\\sbtree.txt"));
		
		List<iNode> list = new ArrayList<iNode>();
		int n = scan.nextInt();
		for(int i=0; i<n; i++){
		    int val = scan.nextInt();
		    iNode node = new iNode(val, null, null);
		    list.add(node);
		}
		while(scan.hasNext()){
		    int a = scan.nextInt();
		    int b = scan.nextInt();
		    iNode na = list.get(a);
		    iNode nb = list.get(b);
		    if(na.left == null)
		        na.left = nb;
		    else
		        na.right = nb;
		}
		System.out.println(list.get(0).data);
		iNode root = list.get(0);
		//callTo(root.data, root);
		callTo(root.data, root.left );
		callTo(root.data, root.right );
		System.out.println("Ctr "+ctr);
		scan.close();
	}

	private static void callTo(int data, iNode node) {
		if(node.left == null && node.right == null){
			ctr++;
			return;
		}
		if(node.left.data == node.right.data && node.right.data == data)
			ctr++;
		
		iNode p = node;		
		callTo(p.data, node.left);
		callTo(p.data, node.right);
		
			
	}

}

class iNode{
    int data;
    iNode left;
    iNode right;
    iNode(int data, iNode l, iNode r){
        this.data = data;
        this.left = l;
        this.right = r;
    }
}

