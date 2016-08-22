package algorithm.btree;

import org.junit.Test;

public class TreeTest {
	@Test
	public void testTree() {
		Tree tree = new Tree();
		tree.insert(20);
		tree.insert(18);
		tree.insert(12);
		tree.insert(19);
		tree.insert(22);
		tree.insert(38);
		tree.insert(24);

		tree.displayTree();
		//		tree.travers();

		System.out.println(tree.find(18));
		tree.delete(18);
		System.out.println(tree.find(18));

		tree.displayTree();
		//		tree.travers();
	}
}
