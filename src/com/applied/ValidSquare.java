package com.applied;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ValidSquare {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\applied\\input.txt"));
		int tcs = scan.nextInt();
		for (int i = 0; i < tcs; i++) {
			int N = scan.nextInt();
			int arr[][] = new int[N][N];
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					arr[j][k] = scan.nextInt();
				}
			}
			//print this 2-d array
			System.out.println("----");
			printArray(arr);
			int res = N*N + countValid(arr, N-1) + countValid(arr, N);
			System.out.println("Res: "+res);
		}
		//close scanner
		scan.close();
	}

	private static int countValid(int[][] arr, int size) {
		int total = 0;
		int N = arr.length;
		int currow = 0, curcol = 0;
		int row = currow + size-1;
		int col = size-1;
		// loop to shift columns of size to the right
		while(col < N){
			// reset the rows when one set of columns of size done
			currow = 0;
			row = currow + size-1;
			// run down with current columns
			while(row < N){
				boolean flag = true;
				int first = -1;
				// main loops to check the grid of give size is valid
				for (int i = currow; i <= row; i++) {
					for (int j = curcol; j <= col; j++) {
						if(first == -1)
							first = arr[i][j];
						else if(arr[i][j] != first){
							flag = false;
							break;
						}					
					}
					if(!flag)
						break;
				}
				if(flag)
					total++;
				// go to the next row
				row++;
				currow++;
			}
			// shift columns to right
			col++;
			curcol++;
		}
		
		System.out.println("size of "+size+":"+total);
		return total;
		
	}

	private static void printArray(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}

}
