package com.ib.hrank;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindRegions {
	
	private static int ROW = 0;
	private static int COL = 0;
	private static int count = 0;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\ib\\hrank\\matrix.txt"));
        ROW = s.nextInt();
        COL = s.nextInt();
        int result = Integer.MIN_VALUE;
        int arr[][] = new int[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for(int j=0; j<COL; j++){
                arr[i][j] = s.nextInt();   
            }
        }
        
        System.out.println("Arrays:"); // created visited array
        boolean visited[][] = new boolean [ROW][COL];
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                System.out.print(arr[i][j]+" ");
                visited[i][j] = false;
            }
            System.out.println();
        }
        
        for(int i=0; i<ROW; i++){
            for(int j=0; j<COL; j++){
                //System.out.println("with arr "+i+" "+j);
                if(arr[i][j] == 1 && !visited[i][j]){
                	count = 1;
                	DFS(arr, i, j, visited);
                }
                result = Math.max(result, count);
               
            }
        }
        System.out.println("Res: "+result);        
        s.close();

	}
	
	private static void DFS(int[][] arr, int i, int j, boolean[][] visited) {
		//mark it visited
		visited[i][j] = true;
		int rowNum[] = {-1,-1,-1,0,0,1,1,1};
		int colNum[] = {-1,0,1,-1,1,-1,0,1};
		// 8 neighbors
		for (int k = 0; k < 8; k++) {
			//if(i-1 >= 0 && j-1 >= 0 && !visited[i][j] && arr[i][j] == 1){
			//	count++;
			//	DFS(arr, i-1, j-1, visited, count);
			if(isSafe(arr, i+rowNum[k], j+colNum[k], visited)){
				count++;
				DFS(arr, i+rowNum[k], j+colNum[k], visited);
			}
		}
		
	}

	private static boolean isSafe(int[][] arr, int i, int j, boolean[][] visited) {
		return(i >= 0 && i < ROW && j >=0 && j < COL
				&& !visited[i][j] && arr[i][j] == 1);
		
	}
}
