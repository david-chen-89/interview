package algorithm.sort;

import org.junit.Test;

public class SortTest {
	int[] a = { 12, 2, 3, 1, 45, 33, 123, 46, 99, 37, 76 };

	@Test
	public void bubbleTest() {
		Bubble.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	@Test
	public void selectionTest() {
		Selection.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	@Test
	public void insertionTest() {
		Insertion.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
}
