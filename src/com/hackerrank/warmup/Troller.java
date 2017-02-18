package com.hackerrank.warmup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Troller {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\input\\troller.txt"));
		// Scanner s = new Scanner(System.in);
        int N = s.nextInt();
		int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        int res = 0;
        int prm = 0;
        for(int i=1; i<=N; i++){
        	//System.out.println("processed: "+(fact(N)/(fact(i)*fact(N-i))));
        	res = res + ((fact(N)/(fact(i)*fact(N-i))));
        	System.out.println("res now: "+res);
        }
        System.out.println(Arrays.toString(arr));
        
        for(int j=0; j<N; j++){
        	if(isPrime(arr[j])){
        		prm++;
        	}
        }
       	System.out.println("primes "+prm);
		System.out.println("total: "+(res-prm));
		s.close();

	}
	
	 private static int fact(int n){
	    	int res = n;
	    	if(res == 1 || res == 0){
	    		return 1;
	    	}
	    	while(n>1){
	    		res = res * (n-1);
	    		--n;
	    	}
	    	return res;
	    }
	    
	    private static boolean isPrime(int n){
	    	boolean flag = true;
	    	for(int i=2; i<=n/2; i++){
	    		if(n%i == 0){
	    			flag = false;
	    			break;
	    		}
	    	}
	    	return flag;
	    }

}
