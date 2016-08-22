package algorithm.sort;

import org.junit.Test;

import algorithm.sort.advance.MergeSort;
import algorithm.sort.advance.QuickSort;
import algorithm.sort.advance.RadixSort;
import algorithm.sort.advance.ShellSort;

public class SortTest {
	int[] a = { 13, 14, 94, 33, 82, 25, 59, 94, 65, 23, 45, 27, 73, 25, 39, 10 };

	//	int[] a = { 12 };

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

	@Test
	public void MergeSortTest() {
		MergeSort.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	@Test
	public void ShellSortTest() {
		ShellSort.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	@Test
	public void QuickSortTest() {
		QuickSort.sort(a);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}

	@Test
	public void RadixSortTest() {
		RadixSort.sort(a, 2);

		for (int i : a) {
			System.out.print(i + " ");
		}
		System.out.print("\n");
	}
}
