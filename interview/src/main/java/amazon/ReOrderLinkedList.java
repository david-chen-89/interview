package amazon;

class Node {
	public int value;
	public Node next;

	public Node(int value) {
		this.value = value;
	}
}

public class ReOrderLinkedList {

	public static void reOrder(Node root) {
		if (root == null || root.next == null || root.next.next == null) {
			return;
		} else {
			Node last = root;
			Node secondLast = null;
			while (last.next != null) {
				secondLast = last;
				last = last.next;
			}
			Node second = root.next;
			root.next = last;
			last.next = second;
			secondLast.next = null;
		}

		reOrder(root.next);
	}

	public static void main(String[] args) {
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		node6.next = node7;
		node5.next = node6;
		node4.next = node5;
		node3.next = node4;
		node2.next = node3;
		node1.next = node2;

		swap(node1, 4);
		//		reOrder(node1);
		while (node1 != null) {
			System.out.println(node1.value);
			node1 = node1.next;
		}
	}

	public static void swap(Node root, int index) {
		if (root == null)
			return;

		Node tmp = root;
		int length = 0;
		while (tmp != null) {
			length++;
			tmp = tmp.next;
		}

		if (index < 1 || index > length)
			return;

		if (index == 1 && index == length) {
			return;
		} else {
			tmp = root;
			Node first = null, second = null;
			int cur = 1;
			while (tmp != null) {
				if (index == cur) {
					first = tmp;
				} else if (length - index + 1 == cur) {
					second = tmp;
				}

				if (first != null && second != null) {
					int tmpValue = first.value;
					first.value = second.value;
					second.value = tmpValue;
					return;
				} else {
					tmp = tmp.next;
					cur++;
				}
			}

		}
	}

}
