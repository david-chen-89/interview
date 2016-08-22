package algorithm.sort.advance;

/**
 	still executes in O(N2) time, but it’s about twice as fast as the bubble sort
	and somewhat faster than the selection sort in normal situations.
 */
public class QuickSort {
	public static void sort(int[] a) {
		quickSort(a, 0, a.length - 1);
	}

	private static void quickSort(int[] a, int start, int end) {
		if (start >= end) {
			return;
		}

		int partition = partition(a, start, end);
		quickSort(a, start, partition - 1);
		quickSort(a, partition + 1, end);
	}

	private static int partition(int[] a, int start, int end) {
		int pivot = start;
		for (int i = start + 1; i <= end; i++) {
			if (a[i] < a[pivot]) {
				int tmp = a[i];
				for (int j = i; j >= start + 1; j--) {
					a[j] = a[j - 1];
				}
				a[start] = tmp;
			}
		}

		return pivot;
	}
}