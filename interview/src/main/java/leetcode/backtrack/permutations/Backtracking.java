package leetcode.backtrack.permutations;

import java.util.ArrayList;
import java.util.List;

/**
 * https://discuss.leetcode.com/topic/46162/a-general-approach-to-backtracking-questions-in-java-subsets-permutations-combination-sum-palindrome-partioning
 *
 */
public class Backtracking {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> list = new ArrayList<>();
		backtrack(list, new ArrayList<>(), nums);
		return list;
	}

	private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
			System.out.println(tempList);
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i])) continue; // element already exists, skip
				tempList.add(nums[i]);
				backtrack(list, tempList, nums);
				tempList.remove(tempList.size() - 1);
			}
		}
	}

	public static void main(String[] args) {
		Backtracking s = new Backtracking();
		s.permute(new int[] { 1, 2, 3 });
	}
}
