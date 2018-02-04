package leetcode.backtrack.subset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BacktrackII {
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums); // key point
		backtrack(result, nums, 0, new ArrayList<Integer>());
		return result;
	}

	private void backtrack(List<List<Integer>> result, int[] nums, int start, List<Integer> tmpList) {
		result.add(new ArrayList<>(tmpList)); // wrong: result.add(tmpList)
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) continue; // key point

			//backtrack
			tmpList.add(nums[i]);
			backtrack(result, nums, i + 1, tmpList);
			tmpList.remove(tmpList.size() - 1);
		}
	}

	public static void main(String[] args) {
		BacktrackII s = new BacktrackII();
		List<List<Integer>> result = s.subsetsWithDup(new int[] { 1, 2, 2 });
		System.out.println(result);
	}
}
