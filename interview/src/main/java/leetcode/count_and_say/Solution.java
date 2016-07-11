package leetcode.count_and_say;

import org.junit.Assert;
import org.junit.Test;

public class Solution {
	//	public String countAndSay(int n) {
	//		if (n < 0) {
	//			return "";
	//		}
	//
	//		int start = 1;
	//		String pre = "1";
	//
	//		while (start < n) {
	//
	//			StringBuilder sb = new StringBuilder();
	//			int counter = 1;
	//			for (int i = 1; i < pre.length(); i++) {
	//				if (pre.charAt(i) == pre.charAt(i - 1)) {
	//					counter++;
	//				} else {
	//					sb.append(counter).append(pre.charAt(i - 1));
	//					counter = 1;
	//				}
	//			}
	//			sb.append(counter).append(pre.charAt(pre.length() - 1));
	//			pre = sb.toString();
	//			start++;
	//		}
	//		return pre;
	//	}

	public String countAndSay(int n) {
		if (n < 0)
			return "";
		if (n == 1)
			return "1";

		String pre = countAndSay(n - 1);

		StringBuilder sb = new StringBuilder();
		int counter = 1;
		for (int i = 1; i < pre.length(); i++) {
			if (pre.charAt(i) == pre.charAt(i - 1)) {
				counter++;
			} else {
				sb.append(counter).append(pre.charAt(i - 1));
				counter = 1;
			}
		}
		sb.append(counter).append(pre.charAt(pre.length() - 1));
		return sb.toString();
	}

	@Test
	public void test() {
		Assert.assertEquals("11", countAndSay(2));
		Assert.assertEquals("21", countAndSay(3));
		Assert.assertEquals("1211", countAndSay(4));
	}
}
