package leetcode.sudoku;

import java.util.HashSet;

import org.junit.Test;

public class Solution {
	public boolean isValidSudoku(char[][] board) {

		if (board == null || board.length != 9 || board[0].length != 9) {
			return false;
		}

		HashSet<Character> set = new HashSet<Character>();
		for (int i = 0; i < 9; i++) {

			for (int j = 0; j < 9; j++) {
				if ('.' != board[i][j])
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
			}

			set.clear();
		}

		for (int j = 0; j < 9; j++) {
			for (int i = 0; i < 9; i++) {
				if ('.' != board[i][j])
					if (set.contains(board[i][j])) {
						return false;
					} else {
						set.add(board[i][j]);
					}
			}

			set.clear();
		}

		for (int i = 0; i < 9; i = i + 3) {
			for (int j = 0; j < 9; j++) {
				for (int k = i; k < i + 3; k++) {
					for (int h = j; h < j + 3; h++) {
						if ('.' != board[k][h])
							if (set.contains(board[k][h])) {
								return false;
							} else {
								set.add(board[k][h]);
							}
					}
				}
				set.clear();
			}
		}

		return true;
	}

	@Test
	public void test() {
	}
}
