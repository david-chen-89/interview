package com;

public class Test {

	public static void main(String[] args) {
		Test t = new Test();
		String st = t.reverse("this is a test string");

		int[] nums = new int[] { 5, 1, 2, 4, 2, 6, 1, -1 };
		t.quickSort(nums);
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i] + "\t ");
		}
	}

	public void quickSort(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		quickSort(nums, 0, nums.length - 1);
	}

	private void quickSort(int[] nums, int start, int end) {
		if (start == end) {
			return;
		} else if (end - start == 1) {
			if (nums[start] > nums[end]) {
				swap(nums, start, end);
			}
			return;
		}

		int flag = start + 1;
		for (int i = start + 1; i <= end; i++) {
			if (nums[i] < nums[flag]) {
				swap(nums, i, flag);
				flag++;
			}
		}
		quickSort(nums, start, flag);
		quickSort(nums, flag, end);
	}

	private void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}

	public boolean isInterleave(String s1, String s2, String s3) {
		if (s1.equals("")) {
			return s3.equals(s2);
		} else if (s2.equals("")) {
			return s3.equals(s1);
		} else if (s3.equals("")) {
			return false;
		}

		int pos1 = s1.length() - 1;
		int pos2 = s2.length() - 1;
		int pos3 = s3.length() - 1;

		if (s3.charAt(pos3) != s2.charAt(pos2) && s3.charAt(pos3) != s1.charAt(pos1)) {
			return false;
		} else if (s3.charAt(pos3) == s2.charAt(pos2) && s3.charAt(pos3) == s1.charAt(pos1)) {
			return isInterleave(s1, s2.substring(0, pos2), s3.substring(0, pos3)) || isInterleave(s1.substring(0, pos1), s2, s3.substring(0, pos3));
		} else if (s3.charAt(pos3) == s2.charAt(pos2)) {
			return isInterleave(s1, s2.substring(0, pos2), s3.substring(0, pos3));
		} else {
			return isInterleave(s1.substring(0, pos1), s2, s3.substring(0, pos3));
		}
	}

	public String reverse(String str) {
		if (str == null || str.length() == 0) {
			return str;
		}
		String result = "";
		char[] chars = str.toCharArray();

		int start = 0;
		int end = 0;
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] == ' ') {
				result = str.substring(start, end + 1) + result;
				result = " " + result;
				start = i;
				end = i;
			} else {
				if (i - 1 > 0 && chars[i - 1] == ' ') {
					start++;
				}
				end++;
			}
		}
		result = str.substring(start, end + 1) + result;

		return result;
	}
}