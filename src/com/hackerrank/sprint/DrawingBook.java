package com.hackerrank.sprint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DrawingBook {

	public static void main(String[] args) throws FileNotFoundException {
		  //Scanner in = new Scanner(System.in);
		Scanner in = new Scanner(new File("D:/Keppler/hackerrank/src/com/hackerrank/sprint/book.txt"));
	    int n = in.nextInt();
	    int p = in.nextInt();
	    in.close();
	    int res = countPage(n, p);	   
	    System.out.println("from start page need to be turned "+res);  
	}

	private static int countPage(int n, int p) {
		int turn = 0;
		int start = 1;
		int min = 0;
		if(n == p)
			return 0;
		if(p == 1)
			return 0;
		if((Math.abs(p-n) == 1)) // || p == n || p==0 || n==0)
			return 0;
		else{
			 while(start < p){
			    	start = start+2;
			    	turn++;
			    }
			min = turn;
			System.out.println("from front: "+turn);
			turn = 0;
			start = n;
			//from back
			while(start > p){
				start = start-2;
				turn++;
			}
			if(turn < min)
				min = turn;
			
			System.out.println("from back: "+turn);
		}
		
		return min;
	}

}
