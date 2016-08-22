package algorithm.linkedlist;

public class LinkList {
	private Link first;

	public LinkList() {
		first = null; // no items on list yet
	}

	public boolean isEmpty() {
		return (first == null);
	}

	public void insertFirst(int value) {
		Link newLink = new Link(value);
		newLink.next = first; // newLink --> old first
		first = newLink; // first --> newLink
	}

	public Link deleteFirst() {
		Link tmp = first;
		if (first != null) {
			first = first.next;
		}
		return tmp;
	}

	public void delete(int value) {
		if (first != null && first.value == value) {
			first = first.next;
		}

		Link previous = null;
		Link current = first;
		while (current != null) {
			if (current.value != value) {
				previous = current;
				current = current.next;
			} else {
				previous.next = current.next;
				break;
			}
		}
	}

	public void displayList() {
		System.out.print("List (first-->last): ");
		Link current = first; // start at beginning of list
		while (current != null) // until end of list,
		{
			current.displayLink(); // print data
			current = current.next; // move to next link
		}
		System.out.print("\n");
	}
}
