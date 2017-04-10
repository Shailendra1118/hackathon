package com.zebra.hiring;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ProjectTeam {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\zebra\\hiring\\input.txt"));
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            int arr[] = new int[num];
            for(int j=0; j< num; j++){
                arr[j] = s.nextInt();
            }
            findLowestDiff(arr);
        }
        s.close();
	}
	
	private static void findLowestDiff(int arr[]){
        int karr[] = new int[arr.length/2];
        Arrays.sort(arr);
        int l = 0, i = 0;
        int r = arr.length -1;
        while(l < r){
            karr[i++] = arr[l++]+arr[r--];
            
        }
        System.out.println("KARR "+Arrays.toString(arr));
        Arrays.sort(karr);
        System.out.println(karr[karr.length-1]-karr[0]);
    }

}
