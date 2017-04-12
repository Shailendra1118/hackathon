package com.hackerrank.warmup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Singapore {

	static int hills[][];
	static int row = 0, col = 0;
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\warmup\\elevation.txt"));
			row = scanner.nextInt();
			col = scanner.nextInt();
			//System.out.println(size);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		hills= new int [row][col];
		System.out.println(hills.length);
		//fill the hills mtx
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				if(scanner.hasNextInt())
					hills[i][j] = scanner.nextInt();
			}
		}
		
		//print the hills mtx
//		for(int i=0; i<row; i++){
//			for(int j=0; j<col; j++){
//					System.out.print(hills[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		Stack<Integer> path = new Stack<Integer>(); 
		for(int i=0; i<row; i++){
			for(int j=0; j<col; j++){
				path.clear(); //empty stack
				int startPoint = hills[i][j];
				path.push(startPoint);
				process(i,j,path);
			}
		}
		
		
		

	}
	
	
	private static void process(int i, int j, Stack<Integer> path) {
		
		//popIfNotBotton(i, j, path);
		
		//check left
		if(j > 0 && (hills[i][j] > hills[i][j-1])){				
			path.push(hills[i][j-1]);
			process(i, j-1, path);
			popIfNotBotton(i, j, path);
		}
		
		//check right
		if(j+1 < col && (hills[i][j] > hills[i][j+1])){
			path.push(hills[i][j+1]);
			process(i, j+1, path);
			popIfNotBotton(i, j, path);
		}
		
		//check down
		if(i+1 < row && (hills[i][j] > hills[i+1][j])){
			path.push(hills[i+1][j]);
			process(i+1, j, path);
			popIfNotBotton(i, j, path);
		}
		
				
	}

	
	private static void popIfNotBotton(int i, int j, Stack<Integer> path) {
		// if its bottom of the hill
		if(!path.isEmpty()){
			if(i+1 == row-1){
			//found path to the bottom
				System.out.println(path);
				path.clear();
			}else{
				path.pop(); //remove the element
			}
		}
	}

	// not used
	class Elevention{
		int value = 0;
		boolean visitedLeft = false;
		boolean visitedRight = false;
		boolean visitedDown = false;
		//boolean visitedLeft = false;
	}

}
