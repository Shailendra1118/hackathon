package com.march.prac.three;

import java.util.Arrays;
import java.util.Random;

public class KnuthShuffle {

	/**
	 *  Instead of generate a random number for each element and then sort those random
	 *  numbers. We could use below linear time algorithm to shuffle a deck of cards.  
	 *  Swapping could be done between i to N-1 instead of 0 to i, but 0 to N-1 is incorrect.
	 */
	public static void main(String[] args) {
		int[] deck = {1,2,3,4,5,6,7,8}; // ideally be 52
		Random rand = new Random(); // could be used inside for loop
		for (int i = 0; i < deck.length; i++) {
			//Random ran = new Random();
			int r = rand.nextInt(i+1);
			//System.out.println("Random: "+r);
			int temp = deck[i];
			deck[i] = deck[r];
			deck[r] = temp;
			
		}
		System.out.println(Arrays.toString(deck));		

	}

}
