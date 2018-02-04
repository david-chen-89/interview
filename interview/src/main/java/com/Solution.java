package com;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
		boolean str = s.isMatch("aaabbbaabaaaaababaabaaabbabbbbbbbbaabababbabbbaaaab", "a*******b");
		System.out.println(str);
	}

	public boolean isMatch(String s, String p) {
		if (s == null) {
			return p == null;
		} else if (s.length() == 0) {
			if (p.length() == 0)
				return true;

			for (char c : p.toCharArray()) {
				if (c != '*')
					return false;
			}

			return true;
		}

		char[] sChars = s.toCharArray();
		char[] pChars = p.toCharArray();

		int flag = 0;
		for (int i = 0; i < sChars.length; i++) {
			if (flag >= pChars.length) {
				return false;
			}

			if (sChars[i] == pChars[flag] || pChars[flag] == '?') {
				flag++;
			} else if (pChars[flag] == '*') {
				if (flag == pChars.length - 1) {
					if (i == sChars.length - 1)
						return true;
					continue;
				} else {
					return isMatch(s.substring(i, sChars.length), p.substring(flag + 1, pChars.length))
							|| isMatch(s.substring(i + 1, sChars.length), p.substring(flag, pChars.length));
				}
			} else {
				return false;
			}

		}

		if (flag == pChars.length) {
			return true;
		} else {
			for (int i = flag; i < pChars.length; i++) {
				if (pChars[i] != '*') {
					return false;
				}
			}
			return true;
		}
	}
}