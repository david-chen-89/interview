package amazon;

import java.util.Arrays;

public class IdentifyString {
	private static int stringCount = 0;

	public static void main(String[] args) {
		char[][] inputArray = { { 'B', 'B', 'A', 'B', 'B', 'N' }, { 'B', 'B', 'M', 'B', 'B', 'O' }, { 'B', 'B', 'A', 'B', 'B', 'Z' },
				{ 'N', 'O', 'Z', 'B', 'B', 'A' }, { 'B', 'B', 'B', 'B', 'B', 'M' }, { 'B', 'B', 'B', 'B', 'B', 'A' } };

		stringCount = countOccurence(inputArray, "AMAZON");
		System.out.println("count of string is " + stringCount);
	}

	private static int countOccurence(char[][] inputArray, String target) {
		int counter = 0;
		char[] arr = target.toCharArray();
		for (int i = 0; i < inputArray.length; i++) {
			for (int j = 0; j < inputArray.length; j++) {
				if (arr[0] == inputArray[i][j]) {
					counter += search(inputArray, Arrays.copyOfRange(arr, 1, arr.length), i, j);
				}
			}
		}
		return counter;
	}

	private static int search(char[][] arr, char[] tar, int x, int y) {
		int counter = 0;

		counter += check(arr, tar, x + 1, y);
		counter += check(arr, tar, x - 1, y);
		counter += check(arr, tar, x, y + 1);
		counter += check(arr, tar, x, y - 1);

		return counter;
	}

	private static int check(char[][] arr, char[] tar, int x, int y) {
		int counter = 0;
		if (x >= 0 && x < arr.length && y >= 0 && y < arr.length && arr[x][y] == tar[0]) {
			if (tar.length == 1)
				counter++;
			else
				counter += search(arr, Arrays.copyOfRange(tar, 1, tar.length), x, y);
		}
		return counter;
	}
}
