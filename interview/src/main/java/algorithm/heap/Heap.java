package algorithm.heap;

/**
 * represent with an array
 *
 */
public class Heap {
	private Node[] heapArray;
	private int currentSize;

	public Heap(int size) {
		heapArray = new Node[size];
	}

	public boolean insert(int key) {
		if (currentSize == heapArray.length) {
			return false;
		}

		Node newNode = new Node(key);
		heapArray[currentSize] = newNode;
		trickleUp(currentSize++); // trickle it up
		return true;
	}

	private void trickleUp(int index) {
		int parent = (index - 1) / 2;
		Node bottom = heapArray[index];
		if (heapArray[parent].getKey() < bottom.getKey()) {
			heapArray[index] = heapArray[parent];
			heapArray[parent] = bottom;
			trickleUp(parent);
		}
	}

	public void remove() {
		if (currentSize == 0)
			return;

		heapArray[0] = heapArray[currentSize - 1];
		heapArray[currentSize - 1] = null;
		currentSize--;

		if (currentSize > 1) {
			trickleDown(0);
		}

	}

	private void trickleDown(int index) {
		if (index * 2 + 2 < currentSize) {
			int largIndex;
			if (heapArray[index * 2 + 2].getKey() < heapArray[index * 2 + 1].getKey()) {
				largIndex = index * 2 + 1;
			} else {
				largIndex = index * 2 + 2;
			}

			if (heapArray[index].getKey() < heapArray[largIndex].getKey()) {
				swap(index, largIndex);
				trickleDown(largIndex);
			}

		} else if (index * 2 + 1 < currentSize) {
			if (heapArray[index].getKey() < heapArray[index * 2 + 1].getKey()) {
				swap(index, index * 2 + 1);
				trickleDown(index * 2 + 1);
			}
		}
	}

	private void swap(int a, int b) {
		Node tmp = heapArray[a];
		heapArray[a] = heapArray[b];
		heapArray[b] = tmp;

	}

	public void display() {
		{
			System.out.print("heapArray: "); // array format
			for (int m = 0; m < currentSize; m++)
				if (heapArray[m] != null)
					System.out.print(heapArray[m].getKey() + " ");
				else
					System.out.print("-- ");
			System.out.println();
			// heap format
			int nBlanks = 32;
			int itemsPerRow = 1;
			int column = 0;
			int j = 0; // current item
			String dots = "...............................";
			System.out.println(dots + dots); // dotted top line
			while (currentSize > 0) // for each heap item
			{
				if (column == 0) // first item in row?
					for (int k = 0; k < nBlanks; k++)
						// preceding blanks
						System.out.print(" ");
				// display item
				System.out.print(heapArray[j].getKey());
				if (++j == currentSize) // done?
					break;
				if (++column == itemsPerRow) // end of row?
				{
					nBlanks /= 2; // half the blanks
					itemsPerRow *= 2; // twice the items
					column = 0; // start over on
					System.out.println(); // new row
				} else
					// next item on row
					for (int k = 0; k < nBlanks * 2 - 2; k++)
						System.out.print(" "); // interim blanks
			} // end for
			System.out.println("\n" + dots + dots); // dotted bottom line
		} // end displayHeap()
			// -------------------------------------------------------------
	}
}
