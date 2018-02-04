package leetcode.backtrack.permutations;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> rs = new ArrayList<List<Integer>>();
		if (nums.length == 1) {
			ArrayList<Integer> ls = new ArrayList<>();
			ls.add(nums[0]);
			rs.add(ls);
		} else if (nums.length > 1) {
			for (Integer i : nums) {
				int[] newNums = removeElement(nums, i);
				List<List<Integer>> tmpRs = permute(newNums);
				for (List<Integer> e : tmpRs) {
					e.add(0, i);
					rs.add(e);
				}
			}
		}
		return rs;
	}

	private int[] removeElement(int[] nums, int remove) {
		int[] newNums = new int[nums.length - 1];
		boolean found = false;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != remove) {
				if (found) {
					newNums[i - 1] = nums[i];
				} else {
					newNums[i] = nums[i];
				}
			} else {
				found = true;
			}
		}
		return newNums;
	}

	//	private List<List<Integer>> permute(List<Integer> nums) {
	//		List<List<Integer>> rs = new ArrayList<List<Integer>>();
	//		if (nums.size() == 1) {
	//			ArrayList<Integer> ls = new ArrayList<>();
	//			ls.add(nums.get(0));
	//			rs.add(ls);
	//		} else {
	//			for (Integer i : nums) {
	//				ArrayList<Integer> newNums = new ArrayList<>(nums);
	//				newNums.remove(i);
	//
	//				List<List<Integer>> tmpRs = permute(newNums);
	//				for (List<Integer> e : tmpRs) {
	//					e.add(0, i);
	//					rs.add(e);
	//				}
	//
	//			}
	//		}
	//
	//		return rs;
	//	}

	public static void main(String[] args) {
		Solution s = new Solution();
		s.permute(new int[] { 1, 2, 3 });
	}
}
