package leetcode.longest.unique.substring;

import java.util.HashMap;

public class LongString {
	public String longestUniqueSubstring(String input) {
		if (input == null || input.length() <= 1) {
			return input;
		}

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String str = "";
		for (int i = 0; i < input.length(); i++) {
			Character c = input.charAt(i);

			if (map.containsKey(c)) {
				String subStr = input.substring(map.get(c) + 1);
				String subLongestStr = longestUniqueSubstring(subStr);
				if (str.length() >= subLongestStr.length()) {
					return str;
				} else {
					return subLongestStr;
				}
			}
			str += c;
			map.put(c, i);
		}
		return str;
	}

	public static void main(String[] args) {
		//		ArrayList< String> ls = new ArrayList<String>();
		//		ls.iterator();
		LongString ls = new LongString();
		System.out.println(ls.longestUniqueSubstring("ACBECFGHA"));
		System.out.println(ls.longestUniqueSubstring("ACBECFGHA").equals("BECFGH"));
		System.out.println(ls.longestUniqueSubstring("abcabcbb").equals("abc"));
		System.out.println(ls.longestUniqueSubstring("bbbbb").equals("b"));
		System.out.println(ls.longestUniqueSubstring("pwwkew").equals("wke"));
	}
}
