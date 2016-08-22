package algorithm.search;

import org.junit.Before;
import org.junit.Test;

public class SearchTest {

	@Before
	public void before() {
	}

	@Test
	public void BinaryTest() {
		int[] a = { 1, 3, 4, 6, 8, 9, 11, 33, 37, 44, 47, 49, 50 };
		for (int i = 0; i < a.length; i++) {
			System.out.print(i + ": " + a[i] + "\t");
		}
		System.out.print("\n");
		System.out.println("33 index: " + BinarySearch.find(a, 33));
		System.out.println("36 index: " + BinarySearch.find(a, 36));
		System.out.println("1 index: " + BinarySearch.find(a, 1));
		System.out.println("50 index: " + BinarySearch.find(a, 50));
	}

}
