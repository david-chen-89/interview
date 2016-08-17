package algorithm.sort;

/**
 	still executes in O(N2) time, but it’s about twice as fast as the bubble sort
	and somewhat faster than the selection sort in normal situations.
 */
public class Insertion {
	public static void sort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		for (int i = 1; i < a.length; i++) {
			int tmp = a[i];
			int j = i;
			while (j > 0 && a[j - 1] >= tmp) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = tmp;
		}
	}

}
