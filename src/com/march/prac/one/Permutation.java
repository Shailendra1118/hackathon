package com.march.prac.one;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

public class Permutation {

	public static void main(String[] args) throws FileNotFoundException {
		RandomizedQueue<String> rq = new RandomizedQueue<>();
		Scanner s = new Scanner(new File("D:/Keppler/Hackerrank/src/com/march/prac/one/input.txt"));
		// Reservoir sampling
        int k = 8; //Integer.parseInt(args[0]);
        int i = 0;
        while(s.hasNext()){
        	String str = s.next();
        	if (i <= k) {
                rq.enqueue(str);
            } else if (Math.random() < (double) k/i) {
                rq.dequeue();
                rq.enqueue(str);
            }
        	i++;
        	//Iterator<String> iter = rq.iterator();
        	//while(iter.hasNext())
        	//	System.out.print(iter.next()+" ");
        	//System.out.println();
        }
        Iterator<String> iter = rq.iterator();
        while(iter.hasNext())
    		System.out.print(iter.next()+" ");
        
        s.close();

	}

}
