package interview;

import org.junit.Test;

public class NodeTest {

	@Test
	public void test() {
		Node root = new Node(1);

		Node second = new Node(2);

		Node third = new Node(3);

		root.next = second;
		second.next = third;

		Node tmp = third;
		tmp.next = root.next;
		third = root;
		third.next = null;
		second.next = third;
		root = tmp;

		char a = '5';
		if (Character.isDigit(a)) {
			System.out.println(Character.getNumericValue(a) + 10);
		}

	}

}

class Node {
	public int value;
	public Node next;

	public Node(int value) {
		this.value = value;
	}
}