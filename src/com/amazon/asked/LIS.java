package com.amazon.asked;

import java.util.ArrayList;
import java.util.Arrays;

public class LIS {

	static int max = 1;

	// longest increasing subsequence
	public static void main(String[] args) {

		// recursive
		// int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
		int arr[] = { 3, 2, 6, 4, 5, 1 };
		int n = arr.length;
		lis(arr, n);
		System.out.println("Length of lis is " + max);

		System.out.println(lisDp(arr, n));
		StoreLisDp(arr, n);
	}

	private static int lisDp(int[] arr, int n) {
		int lis[] = new int[n];
		// int mx = -1;
		for (int i = 0; i < n; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
				}

			}
		}

		System.out.println(Arrays.toString(lis));
		// return lis[n - 1]; this does NOT work ?
		return Arrays.stream(lis).max().getAsInt(); // can use reduce of stream

	}

	private static int StoreLisDp(int[] arr, int n) {
		// st[i] - The longest increasing sub-sequence ends with arr[i]
		ArrayList<ArrayList<Integer>> st = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			st.add(new ArrayList<Integer>());
		}
		st.get(0).add(arr[0]);

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && st.get(i).size() < st.get(j).size() + 1) {
					st.get(i).clear();
					st.get(i).addAll(st.get(j));
					// st.set(i, st.get(j));
				}
			}
			st.get(i).add(arr[i]);
		}

		printVec(st);
		return 0;
	}

	private static void printVec(ArrayList<ArrayList<Integer>> st) {
		System.out.println("Each subsequence ending at i");
		st.stream().forEach(l -> {
			l.forEach(e -> System.out.print(e + " "));
			System.out.println();
		});
	}

	// System.out.println("arr[i - 1] < arr[n - 1] " + (arr[i - 1]) + " "
	// + (arr[n - 1]));
	private static int lis(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}
		int max_ending_here = 1, res;
		for (int i = 1; i < n; i++) {
			res = lis(arr, i);

			if (arr[i - 1] < arr[n - 1] && res + 1 > max_ending_here) {
				max_ending_here = res + 1;
			}
		}
		if (max_ending_here > max) {
			max = max_ending_here;
		}

		return max_ending_here; // return max_ending_here for recursion
	}

}
