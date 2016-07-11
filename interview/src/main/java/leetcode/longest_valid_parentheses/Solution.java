package leetcode.longest_valid_parentheses;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class Solution {

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		return addTwoNumbers(l1, l2, 0);
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2, int i) {
		if (l1 == null) {
			return addTwoNumbers(l2, i);
		} else if (l2 == null) {
			return addTwoNumbers(l1, i);

		}

		ListNode result = new ListNode((l1.val + l2.val + i) % 10);
		result.next = addTwoNumbers(l1.next, l2.next, (l1.val + l2.val + i) / 10);
		return result;
	}

	public ListNode addTwoNumbers(ListNode l1, int i) {
		if (l1 == null) {
			if (i == 0) {
				return null;
			} else {
				return new ListNode(i);
			}
		}
		ListNode result = new ListNode((l1.val + i) % 10);
		result.next = addTwoNumbers(l1.next, (l1.val + i) / 10);
		return result;
	}
}