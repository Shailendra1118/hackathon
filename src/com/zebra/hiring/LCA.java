package com.zebra.hiring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LCA {

	public static void main(String[] args) throws FileNotFoundException {
        //Scanner
        Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\zebra\\hiring\\tree.txt"));
        int N = s.nextInt();
        int arr[] = new int[N];
        arr[0] = 0; //root
        for (int i = 1; i < N; i++) {
        	//fill array to mark parents
        	arr[i] = s.nextInt();
        }
        int cn = s.nextInt();
        ArrayList<Stack<Integer>> paths = new ArrayList<>(); // size makes it complicated in case of list
        for (int i = 0; i < cn; i++) {
        	Stack<Integer> path = new Stack<>();
			int c = s.nextInt();
			path.push(c);
			while(arr[c] != 0){
				path.push(arr[c]);
				c = arr[c];
			}
			path.push(0);
			paths.add(path);			
		}
        System.out.println(paths);
        int res = findCommon(paths);
        System.out.println("Res: "+res);
        s.close();
	}

	private static int findCommon(ArrayList<Stack<Integer>> paths) {
		int ret = -1, prev = -1;
		while(true){
			ret = prev; // save last previous as current return
			for (int i = 0; i < paths.size(); i++) {
				Stack<Integer> stk = paths.get(i);
				if(stk.isEmpty())
					return ret;
				int temp = stk.pop();
				System.out.println(temp+" popped");
				if(i != 0 && temp != prev)
					return ret;
				prev = temp;
			}
		}
	
	}

}
