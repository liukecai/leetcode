package cn.edu.kust.easy;

import java.util.Arrays;

/**
 *
 * 912. Sort an Array
 * timeout
 */
public class BubbleSort {
	public int[] sortIntegers(int[] A) {
		if (A.length == 1 || A.length == 0) {
			return A;
		}
		int a;
		int b;
		for (int j = 0; j < A.length; j++) {
			for (int i = 0; i < A.length - j - 1; i++) {
				a = A[i];
				b = A[i + 1];
				if (a > b) {
					A[i + 1] = A[i];
					A[i] = b;
				}
			}
		}

		return A;
	}

	public static void main(String[] args) {
		BubbleSort s = new BubbleSort();
		int[] A = {3, 4, 45, 67, 23, 13, 65};
		long start = System.currentTimeMillis();
		s.sortIntegers(A);
		System.out.println(Arrays.toString(A));
		long end = System.currentTimeMillis();
		System.out.println("\nused time: " + (end - start) + "ms");
	}
}
