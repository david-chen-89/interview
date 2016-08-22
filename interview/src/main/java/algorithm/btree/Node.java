package algorithm.btree;

public class Node<T extends Comparable<T>> {
	public T data;
	public Node<T> left;
	public Node<T> right;
}
