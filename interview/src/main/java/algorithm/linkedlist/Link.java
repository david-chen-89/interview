package algorithm.linkedlist;

public class Link {
	public int value;

	public Link next;

	public Link(int value) {
		super();
		this.value = value;
	}

	public void displayLink() { // display ourself
		System.out.print("{value: " + value + "} ");
	}
}
