package com.hackerrank.warmup;

public class PathToCandies {

	static int [][]mat = { {1, 2, 3}, {4, 5, 6}, {7,8,9} };
	static int ROW = 3;
	static int COL = 3;
	static int path[] = new int[6];
	public static void main(String[] args) {
		 //int [][]mat = { {1, 2, 3}, {4, 5, 6} };
		 printAllPaths();
		 
	}

	private static void printAllPaths() {
		//int path[] = new int[6];
		printAllPathsUtil(0, 0, ROW, COL, 0);		
	}

	private static void printAllPathsUtil(int i, int j, int m,	int n, int pi) {
		
		 if (i == m-1)
		    {
		        for (int k = j; k < n; k++){
		            path[pi] =  mat[i][k];
		            pi++;
		        }
		        
		        for (int l = 0; l < pi; l++)
		            System.out.print(path[l]+" ");
		        System.out.println();
		        return;
		    }
		 
		 if (j == n - 1)
		    {
		        for (int k = i; k < m; k++){
		            path[pi] = mat[k][j];
		            pi++;
		        }
		        for (int l = 0; l < pi; l++)
		        	 System.out.print(path[l]+" ");
		        System.out.println();
		        return;
		    }
		 
		 // Add the current cell to the path being generated
		    path[pi] = mat[i][j]; 
		    
		    // Print all the paths that are possible after moving down
		    printAllPathsUtil(i+1, j, m, n, pi + 1);
		 
		    // Print all the paths that are possible after moving right
		    printAllPathsUtil(i, j+1, m, n, pi + 1);
	}
	
	
	
	
	

}
