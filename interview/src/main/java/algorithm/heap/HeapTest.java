package algorithm.heap;

import org.junit.Test;

public class HeapTest {
	@Test
	public void testTree() {
		Heap heap = new Heap(32);
		heap.insert(20);
		heap.insert(18);
		heap.insert(12);
		heap.insert(4);
		heap.insert(19);
		heap.insert(22);
		heap.insert(8);
		heap.insert(38);
		heap.insert(24);

		heap.display();

		//		System.out.println(heap.find(18));
		heap.remove();
		//		System.out.println(tree.find(18));
		//
		heap.display();
		//		tree.travers();
		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();

		heap.remove();
		heap.display();
	}
}
