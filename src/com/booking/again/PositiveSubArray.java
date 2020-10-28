/**
 * 
 */
package com.booking.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Shailendra
 *
 */
public class PositiveSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer arr[] = { 1, 2, 5, -7, 2, 4, 2 };
		// Integer arr[] = { 0, 0, -1, 0, 0, 0 };
		// Integer arr[] = { -846930886, -1714636915, 424238335, -1649760492 };
		ArrayList<Integer> A = new ArrayList<Integer>(Arrays.asList(arr));
		// A.stream().forEach(System.out::print);
		List<Integer> list = new PositiveSubArray().maxset(A);
		list.forEach(System.out::print);
	}

	public ArrayList<Integer> maxset(List<Integer> A) {
		int curStartIdx = -1, curEndIdx = -1;
		int startIdx = -1, endIdx = -1;
		long curMax = 0;
		long max = 0;
		boolean newStarted = false;
		int i = 0;
		for (; i < A.size(); i++) {
			int num = A.get(i);
			if (num >= 0) {
				curMax = curMax + num;
				if (!newStarted) {
					newStarted = true;
					curStartIdx = i;
				}

			} else if (newStarted) {
				// got negative number
				curEndIdx = i - 1;
				if (curMax > max) {
					max = curMax;
					startIdx = curStartIdx;
					endIdx = curEndIdx;
				} else {
					if (curMax == max || curMax == 0) {
						if (Math.abs(startIdx - endIdx) < Math.abs(curStartIdx
								- curEndIdx)) {
							startIdx = curStartIdx;
							endIdx = curEndIdx;
						}

					}
				}

				curMax = 0;
				newStarted = false;
				curEndIdx = -1;
				curStartIdx = -1;
			}

		}

		// check at last as well
		if (newStarted) {
			curEndIdx = i - 1;
			if (curMax > max) {
				max = curMax;
				startIdx = curStartIdx;
				endIdx = curEndIdx;
			} else {
				if (curMax == max || curMax == 0) {
					if (Math.abs(startIdx - endIdx) < Math.abs(curStartIdx
							- curEndIdx)) {
						startIdx = curStartIdx;
						endIdx = curEndIdx;
					}

				}
			}
		}

		// construct the arraylist to return
		if (startIdx < 0 || endIdx < 0)
			return new ArrayList<Integer>();
		return new ArrayList<Integer>(A.subList(startIdx, endIdx + 1));
	}
}
