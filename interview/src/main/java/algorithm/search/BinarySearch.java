package algorithm.search;

public class BinarySearch {

	// array a must be sorted
	public static int find(int[] a, int vale) {
		int start = 0;
		int end = a.length - 1;

		int mid;
		while (end >= start) {
			mid = (start + end) / 2;
			if (a[mid] > vale) {
				end = mid - 1;
			} else if (a[mid] < vale) {
				start = mid + 1;
			} else {
				return mid;
			}
		}

		return -1;

		/*
		 * int start = 0; int end = a.length - 1; while (end > start + 1) { if
		 * (a[(start + end) / 2] == vale) { return (start + end) / 2; } else if
		 * (a[(start + end) / 2] > vale) { end = (start + end) / 2; } else if
		 * (a[(start + end) / 2] < vale) { start = (start + end) / 2; } }
		 * 
		 * if (a[start] == vale) { return start; } else if (a[end] == vale) {
		 * return end; } else { return -1; }
		 */
	}
}
