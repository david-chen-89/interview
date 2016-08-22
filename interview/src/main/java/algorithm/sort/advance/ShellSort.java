package algorithm.sort.advance;

/**
 * https://zh.wikipedia.org/wiki/希尔排序
 *
 */
public class ShellSort {
	public static void sort(int[] a) {
		if (a == null || a.length == 0) {
			return;
		}

		sort(a, 5);
		sort(a, 3);
		sort(a, 1);
	}

	private static void sort(int[] a, int off) {
		for (int i = 0; i < off; i++) {
			for (int j = i; j < a.length; j += off) {
				int tmp = a[j];
				int k = j;
				while (k - off >= 0 && a[k - off] >= tmp) {
					a[k] = a[k - off];
					k -= off;
				}
				a[k] = tmp;
			}
		}
	}

}
