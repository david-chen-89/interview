package leetcode.search_range;

import org.junit.Test;

public class Solution {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null) {
			return new int[] { -1, -1 };
		}
		return searchRange(nums, 0, nums.length - 1, target);
	}

	private int[] searchRange(int[] nums, int start, int end, int target) {
		if (end - start == 0) {
			if (target == nums[end]) {
				return new int[] { end, end };
			} else {
				return new int[] { -1, -1 };
			}
		} else if (end - start == 1) {
			if (target == nums[start]) {
				if (target == nums[end]) {
					return new int[] { start, end };
				} else {
					return new int[] { start, start };
				}
			} else if (target == nums[end]) {
				return new int[] { end, end };
			} else {
				return new int[] { -1, -1 };
			}
		}

		if (nums[(start + end) / 2] == target) {
			int left = find(nums, start, (start + end) / 2, target, true);
			int right = find(nums, (start + end) / 2, end, target, false);
			return new int[] { left, right };
		} else if (nums[(start + end) / 2] > target) {
			return searchRange(nums, start, (start + end) / 2, target);
		} else if (nums[(start + end) / 2] < target) {
			return searchRange(nums, (start + end) / 2, end, target);
		}

		return new int[] { -1, -1 };
	}

	private int find(int[] nums, int start, int end, int target, boolean isLeft) {
		if (nums.length == 1 || end == start) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		} else if (end == start + 1) {
			if (isLeft) {
				if (nums[start] == target) {
					return start;
				} else if (nums[end] == target) {
					return end;
				} else {
					return -1;
				}
			} else {
				if (nums[end] == target) {
					return end;
				} else if (nums[start] == target) {
					return start;
				} else {
					return -1;
				}
			}
		}

		if (isLeft) {
			if (nums[(start + end) / 2] >= target) {
				return find(nums, start, (start + end) / 2, target, isLeft);
			} else {
				return find(nums, (start + end) / 2, end, target, isLeft);
			}
		} else {
			if (nums[(start + end) / 2] <= target) {
				return find(nums, (start + end) / 2, end, target, isLeft);
			} else {
				return find(nums, start, (start + end) / 2, target, isLeft);
			}
		}
	}

	@Test
	public void test() {
		int[] nums = new int[] { 1, 1, 2, 2, 2, 3 };
		searchRange(nums, 2);
	}
}