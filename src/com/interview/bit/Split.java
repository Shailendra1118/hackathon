package com.interview.bit;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Split {

	public static void main(String[] args) throws IOException {
		
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String line = br.readLine();
//        int N = Integer.parseInt(line);
//        for (int i = 0; i < N; i++) {
//            System.out.println("hello world");
//        }
		
		Scanner scan = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\input.txt"));
		while(scan.hasNextLine()){
			String line = scan.next();
			int testCases = Integer.parseInt(line);
			
			//System.out.println(line);
			for(int i=0; i<testCases; i++){
				//start of test case
				String pnt = scan.nextLine();
				System.out.println(pnt);
			}
		}
       
		scan.close();
	}
	
	class Person{
		String name;
		int expenses;
		int paid;
		
	}

}
