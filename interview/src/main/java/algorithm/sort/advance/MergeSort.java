package algorithm.sort.advance;

import java.util.Arrays;

/**
 * The heart of the merge sort algorithm is the merging of two already-sorted arrays.
 * <p> O(n*log(n))</p>
 */
public class MergeSort {

	public static void sort(int[] a) {
		sort(a, 0, a.length - 1);
	}

	private static void sort(int[] a, int start, int end) {

		if (end > start) {
			int mid = (start + end) / 2;
			sort(a, start, mid);
			sort(a, mid + 1, end);
			merge(a, start, mid, end);
		}

	}

	private static void merge(int[] a, int start, int mid, int end) {
		int[] tmp = Arrays.copyOf(a, a.length);

		int index = mid + 1;
		int pos = start;
		for (int i = start; i < mid + 1; i++) {
			if (index <= end) {
				if (tmp[i] < tmp[index]) {
					a[pos] = tmp[i];
					pos++;
				} else {
					while (index <= end && tmp[i] >= tmp[index]) {
						a[pos] = tmp[index];
						pos++;
						index++;
					}
					a[pos] = tmp[i];
					pos++;
				}
			} else {
				a[pos] = tmp[i];
				pos++;
			}
		}
	}
}
