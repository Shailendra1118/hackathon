package com.practice.april;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;


public class HEarch {

	public static void main(String[] args) throws FileNotFoundException {
		//Scanner
        Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\practice\\april\\inputHR.txt"));
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int total = scan.nextInt();
            int k = scan.nextInt();
            long pro = 1;
            int arr[] = new int[total];
            for(int j=0; j<total;j++){
                arr[j] = scan.nextInt();
                pro = pro * arr[j];
            }
           
            int f = 0;
            int s = arr.length-1;
            //System.out.println("arr:"+Arrays.toString(arr));
           // System.out.println("product: "+pro);
            while(k > 0){
                int narr[] = new int[arr.length-1];
                if(pro/arr[f] < pro/arr[s]){
                    System.arraycopy(arr, 0, narr, 0, arr.length-1);
                    arr = narr;
                     s--;
                }else{
                    System.arraycopy(arr, 1, narr, 0, arr.length-1);
                    arr = narr;
                    f++;
                }
                pro = getPro(arr);
                k--;
            }
            System.out.println(getPro(arr));
            
        }
     
        scan.close();
	}
	
	private static long getPro(int arr[]){
        long pro = 1;
        for(int i=0; i<arr.length; i++){
            pro = pro* arr[i];
        }
        return pro;
    }

}
