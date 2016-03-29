package com.hackerrank.warmup;

public class PathCost {

	public static void main(String[] args) {

		int matrix[][] = {{0,5,7},{7,9,1},{2,7,11}};
		int rows = matrix.length,column = matrix[0].length;
		System.out.println("rows : "+rows );
		System.out.println("columns : "+column);
		int TotalSum = 0, sum=0;

		FindTheTotalSum(0,0,sum,rows,column,matrix);
	}

	private static void FindTheTotalSum(int i, int j, int sum, int rows, int column, int[][] arr) {
				if((i==column-1)&&(j==rows-1)){
					System.out.println(sum+" sum of the path");
				}
				sum = sum + arr[j][i];
				if(i<column-1){
					FindTheTotalSum(i+1, j, sum, rows, column,arr);
				}
				if(j<rows-1){
					FindTheTotalSum(i, j+1, sum, rows, column,arr);
				}
			}

}
