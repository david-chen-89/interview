package algorithm.sort;

public class Bubble {

	/**
	 * O(N2)
	 */
	public static void sort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}
		for (int i = a.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1]) {
					swap(a, j, j + 1);
				}
			}
		}
	}

	private static void swap(int[] a, int one, int two) {
		int temp = a[one];
		a[one] = a[two];
		a[two] = temp;
	}
}
