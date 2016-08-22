package algorithm.linkedlist;

import org.junit.Before;
import org.junit.Test;

public class LinkListTest {

	private LinkList theList;

	@Before
	public void before() {
		theList = new LinkList();

		theList.insertFirst(22);
		theList.insertFirst(44);
		theList.insertFirst(66);
		theList.insertFirst(88);
	}

	@Test
	public void testDeleteFirst() {
		theList.displayList();

		while (!theList.isEmpty()) // until it’s empty,
		{
			Link aLink = theList.deleteFirst(); // delete link
			System.out.print("Deleted "); // display it
			aLink.displayLink();
			System.out.println("");
		}
		theList.displayList(); // display list
	}

	@Test
	public void testDelete() {
		theList.displayList();
		theList.delete(44);
		theList.displayList();
	}

}
