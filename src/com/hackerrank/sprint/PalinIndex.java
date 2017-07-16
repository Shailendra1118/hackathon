package com.hackerrank.sprint;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PalinIndex {

	public static void main(String[] args) throws FileNotFoundException {
		 /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(new File("D:\\Keppler\\Hackerrank\\src\\com\\hackerrank\\sprint\\strings.txt"));
        int tc = s.nextInt();
        System.out.println("total: "+tc);
        for(int i=0; i<tc; i++){
            String str = s.next();
            //System.out.println("this one: "+str);
            if(isPalindrome(str)){
                //System.out.println(str+"is palindrome so -1");
                System.out.println("-1");
                //break;
            }
            else{
                //System.out.println("find index "+str);
                findPIndex(str);
            }
        }
        s.close();
	}
	
	 private static void findPIndex(String str){
	        int len = str.length();
	        int idx = -1;	        
	        for(int i=0; i<len; i++){
	            String cur = str.substring(0, i) + str.substring(i+1);
	            //System.out.println(cur);
	            if(isPalindrome(cur)){	                
	                idx = i;	               
	            }
	        }
	        System.out.println(idx);
	    }
	    
	    private static boolean isPalindrome(String str){
	    	//System.out.println(str);
	        //System.out.println("is palindrome: "+str.length());
	    	//if(str.length()%2 != 0)
	    	//	return false;
	        int i = 0;
	        int j = str.length()-1;
	        while(i < j){
	            if(str.charAt(i) != str.charAt(j))
	                return false;
	            i++;
	            j--;
	        }
	        return true;
	    }

}
