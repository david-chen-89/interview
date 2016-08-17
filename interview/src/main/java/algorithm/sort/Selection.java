package algorithm.sort;

/**
 	The selection sort improves on the bubble sort by reducing the number of swaps
	necessary from O(N2) to O(N). Unfortunately, the number of comparisons remains
	O(N2).
 */
public class Selection {
	public static void sort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 0; i < a.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j]) {
					min = j;
				}
			}
			swap(a, i, min);
		}
	}

	private static void swap(int[] a, int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
