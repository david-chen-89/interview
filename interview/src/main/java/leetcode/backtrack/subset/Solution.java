package leetcode.backtrack.subset;

import java.util.ArrayList;
import java.util.List;

public class Solution {
	public List<List<Integer>> subsets(int[] nums) {
		return subsets(nums, 0);
	}

	private List<List<Integer>> subsets(int[] nums, int start) {
		List<List<Integer>> result = new ArrayList<>();

		if (start == nums.length) {
			List<Integer> empty = new ArrayList<>();
			result.add(empty);
			return result;
		}

		List<List<Integer>> tempResult = subsets(nums, start + 1);
		result.addAll(tempResult);
		for (List<Integer> ls : tempResult) {
			ArrayList<Integer> tmp = new ArrayList<>(ls);
			tmp.add(0, nums[start]);
			result.add(tmp);
		}

		return result;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> result = s.subsets(new int[] { 1, 2, 3 });
		System.out.println(result);
	}
}
