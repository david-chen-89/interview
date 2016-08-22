package algorithm.btree;

import java.util.Stack;

public class Tree {

	private Node<Integer> root;

	public boolean find(int value) {
		Node<Integer> tmp = root;
		while (tmp != null) {
			if (tmp.data == value) {
				return true;
			} else {
				tmp = tmp.data > value ? tmp.left : tmp.right;
			}
		}
		return false;
	}

	public Integer min() {
		if (root == null)
			return null;

		Node<Integer> cur = root;
		while (cur != null && cur.left != null) {
			cur = cur.left;
		}
		return cur.data;
	}

	public Integer max() {
		if (root == null)
			return null;

		Node<Integer> cur = root;
		while (cur != null && cur.right != null) {
			cur = cur.right;
		}
		return cur.data;
	}

	public void insert(Integer value) { // insert or update

		Node<Integer> newNode = new Node<Integer>();
		newNode.data = value;

		if (root == null) {
			root = newNode;
			return;
		}

		Node<Integer> cur = root;

		while (true) {
			int flag = cur.data - value;

			if (flag == 0) {
				return;
			} else if (flag > 0) {
				if (cur.left == null) {
					cur.left = newNode;
					return;
				} else {
					cur = cur.left;
				}
			} else if (flag < 0) {
				if (cur.right == null) {
					cur.right = newNode;
					return;
				} else {
					cur = cur.right;
				}
			}
		}
	}

	/*
	 * most complicated common operation for binary search trees.
	 */
	public void delete(int value) {
		if (root == null) {
			return;
		} else {
			root = nodeDelete(root, value);
		}

	}

	private Node<Integer> nodeDelete(Node<Integer> node, int value) {
		if (node == null) {
			return null;
		} else if (node.data > value) {
			node.left = nodeDelete(node.left, value);
			return node;
		} else if (node.data < value) {
			node.right = nodeDelete(node.right, value);
			return node;
		} else {
			if (node.left == null && node.right == null) {
				node = null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			} else {
				Node<Integer> tmp = node.right.left;
				if (tmp == null) {
					node.right.left = node.left;
					return node.right;
				} else {
					Node<Integer> pre = node;
					while (tmp.left != null) {
						pre = tmp;
						tmp = tmp.left;
					}

					pre.left = null;
					tmp.left = node.left;
					tmp.right = node.right;
					return tmp;
				}
			}

			return node;
		}

	}

	public void travers() {
		travers(root);
	}

	public void travers(Node<Integer> node) {
		if (node != null) {
			travers(node.left);
			System.out.println(node.data);
			travers(node.right);
		}
	}

	public void displayTree() {
		Stack<Node<Integer>> globalStack = new Stack<Node<Integer>>();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println("......................................................");
		while (isRowEmpty == false) {
			Stack<Node<Integer>> localStack = new Stack<Node<Integer>>();
			isRowEmpty = true;
			for (int j = 0; j < nBlanks; j++) {
				System.out.print(" ");
			}
			while (globalStack.isEmpty() == false) {
				Node<Integer> temp = globalStack.pop();
				if (temp != null) {
					System.out.print(temp.data);
					localStack.push(temp.left);
					localStack.push(temp.right);
					if (temp.left != null || temp.right != null)
						isRowEmpty = false;
				} else {
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for (int j = 0; j < nBlanks * 2 - 2; j++)
					System.out.print(" ");
			}
			System.out.println();
			nBlanks /= 2;
			while (localStack.isEmpty() == false)
				globalStack.push(localStack.pop());
		} // end while isRowEmpt

		System.out.println("......................................................");

	}

	public Node<Integer> getRoot() {
		return root;
	}

	public void setRoot(Node<Integer> root) {
		this.root = root;
	}
}