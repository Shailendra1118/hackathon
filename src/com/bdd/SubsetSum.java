/**
 * 
 */
package com.bdd;

/**
 * @author Shailendra
 *
 */
public class SubsetSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;

		boolean present = isSubset(set, set.length - 1, sum);
		System.out.println(present);

	}

	/**
	 * @param set
	 * @param length
	 * @param sum
	 * @return
	 */
	private static boolean isSubset(int[] set, int n, int sum) {
		// boolean found = false; not required
		// Base Cases
		if (sum == 0)
			return true;

		if (sum != 0 && n == 0) {
			return false;
		}

		return isSubset(set, n - 1, sum - set[n - 1])
				|| isSubset(set, n - 1, sum);

	}

}
