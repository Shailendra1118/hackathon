package com.hackerearth.zuaba;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VyasaWork {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner in = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerearth\\zuaba\\input.txt"));
		int N, Q, L, R, i, j, k;
		N = Integer.parseInt(in.next());
		int[][][] counts = new int[26][2][N + 1];
		char[] foodTypes = in.next().toCharArray();
		char[] sleepTypes = in.next().toCharArray();
		long m, c0, c1, total;
 
		for (i = 0; i < N; i++) {
			for (j = 0; j < 26; j++) {
				for (k = 0; k < 2; k++) {
					counts[j][k][i + 1] = counts[j][k][i];
				}
			}
 
			j = foodTypes[i] - 'a';
			k = sleepTypes[i] - '0';
 
			counts[j][k][i + 1]++;
		}
 
		Q = Integer.parseInt(in.next());
		m = 1000000007;
 
		//String[] tokens;
 
		while (Q > 0) {
			Q--;
 
			//tokens = in.nextin
			L = in.nextInt();
			R = in.nextInt();
 
			total = c0 = c1 = 0;
 
			for (j = 0; j < 26; j++) {
				c0 += counts[j][0][R] - counts[j][0][L - 1];
				c1 += counts[j][1][R] - counts[j][1][L - 1];
			}
 
			total = (total%m + (c0 * (c0 - 1) / 2) % m) % m;
			total = (total%m + (c1 * (c1 - 1) / 2) % m) % m;
 
			for (j = 0; j < 26; j++) {
				c0 = counts[j][0][R] - counts[j][0][L - 1];
				c1 = counts[j][1][R] - counts[j][1][L - 1];
 
				total = (total%m + (c0 * c1) % m) % m;
			}
 
			System.out.println(total);
		}
		
		in.close();
	}
	

}
