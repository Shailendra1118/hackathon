/**
 * 
 */
package com.bdd;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Shailendra
 *
 */
public class MergeSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		List<Integer> a = new ArrayList<>();
		a.add(1);
		a.add(5);
		a.add(7);
		a.add(7);
		List<Integer> b = new ArrayList<>();
		b.add(0);
		b.add(1);
		b.add(2);
		b.add(3);

		List<Integer> res = mergeArrays(a, b);
		System.out.println(res);
	}

	static List<Integer> mergeArrays(List<Integer> a, List<Integer> b) {

		int asize = a.size();
		int bsize = b.size();
		int i = 0;
		int j = 0;

		List<Integer> res = new ArrayList<>();
		while (i < asize && j < bsize) {
			if (a.get(i) < b.get(j)) {
				res.add(a.get(i));
				i++;
			} else if (a.get(i) > b.get(j)) {
				res.add(b.get(j));
				j++;
			} else {
				res.add(a.get(i));
				i++;
				j++;
			}
		}

		if (i < asize) {
			for (int p = i; p < asize; p++) {
				res.add(a.get(p));
			}
		} else if (j < bsize) {
			for (int q = j; q < bsize; q++) {
				res.add(b.get(q));
			}

		}

		return res;
	}

}
