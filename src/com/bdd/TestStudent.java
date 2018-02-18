package com.bdd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		if(StudentType.HIGHSCHOOL.equals(StudentType.OTHER)){
			System.out.println("equals");
		}
		Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\bdd\\input.txt"));
		examineFile(s);
		
	}
	
	public static void examineFile(Scanner infile) {
	     int lines = 0;
	     int words = 0;
	     int chars = 0;
	     double wordLength = 0;
	     
	     while(infile.hasNextLine()){
	    	 String curLine = infile.nextLine();
	    	 lines++;
	    	 String[] wordsArr = curLine.split(" ");
	    	 for (int i = 0; i < wordsArr.length; i++) {
				words++;
				chars += wordsArr[i].length();
				wordLength = chars/words;
			}
	    	 
	     }
	     
	     System.out.println("Total lines = " + lines);
	     System.out.println("Total words = " + words);
	     System.out.println("Total chars = " + chars);

	     //if( lines > 100)
	         System.out.println("Word length = " + wordLength);
	}


}

enum StudentType {
    HIGHSCHOOL, PRIMARY, OTHER;
}
