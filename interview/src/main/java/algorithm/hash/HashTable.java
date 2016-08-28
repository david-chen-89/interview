package algorithm.hash;

public class HashTable<T> {

	private int length = 16;
	private Node<T>[] nodeArr;

	@SuppressWarnings("unchecked")
	public HashTable() {

		nodeArr = new Node[length];
	}

	@SuppressWarnings("unchecked")
	public HashTable(int length) {
		this.length = length;
		nodeArr = new Node[length];
	}

	public void put(String key, T value) {
		int hash = key.hashCode();
		int index = hash % length;
		if (nodeArr[index] == null) {
			nodeArr[index] = new Node<T>(key, value);
		} else {
			Node<T> cur = nodeArr[index];
			while (true) {
				if (cur.getKey().equals(key)) {
					cur.setValue(value);
					return;
				}

				if (cur.getNext() == null) {
					break;
				}
				cur = cur.getNext();
			}
			cur.setNext(new Node<T>(key, value));
		}
	}

	public T get(String key) {
		int hash = key.hashCode();
		int index = hash % length;
		if (nodeArr[index] != null) {
			Node<T> cur = nodeArr[index];
			while (cur != null) {
				if (cur.getKey().equals(key)) {
					return cur.getValue();
				}
				cur = cur.getNext();
			}
		}
		return null;
	}
}
