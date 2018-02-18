package com.applied;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class Police {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("D:\\Keppler\\Hackerrank\\src\\com\\applied\\police.txt"));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String[] line = br.readLine().split(" ");
            int N = Integer.parseInt(line[0]);
            int K = Integer.parseInt(line[1]);
            char[][] A = new char[N][N];
            for(int i_A=0; i_A<N; i_A++)
            {
            	String[] arr_A = br.readLine().split(" ");
            	for(int j_A=0; j_A<arr_A.length; j_A++)
            	{
            		A[i_A][j_A] = arr_A[j_A].charAt(0);
            	}
            }

            int out_ = solution(A, K);
            System.out.println(out_);
            System.out.println("");
         }

         wr.close();
         br.close();
    }
    static int solution(char[][] A, int k){
        // Write your code here
        int size = A.length;
        char[][] visited = new char[size][size];
        for(int i=0; i<size; i++){
            // ith row
            for(int j=0; j<size; j++){
                char cur = A[i][j];
                if(cur == 'P'){
                    //findLeft
                    int c = k;
                    while(c >= 0 && j-c >= 0){
                        if(A[i][j-c] == 'T' && visited[i][j-c] != 'X'){
                            visited[i][j-c] = 'X';
                        }
                        c--;
                    }
                    //find right
                    c = 0;
                    while(c < k && j+c < size){
                        if(A[i][j+c] == 'T' && visited[i][j+c] != 'X'){
                            visited[i][j+c] = 'X';
                        }
                        c++;
                    }
                }
                
            }
        }
        
        int res = 0;
        for (int i = 0; i < visited.length; i++) {
        	for (int j = 0; j < visited.length; j++) {
				if(visited[i][j] == 'X'){
					res++;
				}
			}
			
		}
		return res;
        
    
    }
        
    
}
