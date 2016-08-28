package algorithm.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class GraphBreadthFS {
	private int v; // number of vetics
	private LinkedList<Integer> adj[];

	GraphBreadthFS(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList<>();
	}

	void addEdge(int v, int w) {
		adj[v].add(w); // Add w to v’s list.
	}

	// The function to do DFS traversal. It uses recursive DFSUtil()
	void BFS(int s) {
		// Mark all the vertices as not visited(set as
		// false by default in java)
		boolean visited[] = new boolean[v];

		// Create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<Integer>();

		// Mark the current node as visited and enqueue it
		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");

			Iterator<Integer> i = adj[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

	public static void main(String args[]) {
		GraphBreadthFS g = new GraphBreadthFS(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Depth First Traversal " + "(starting from vertex 2)");

		g.BFS(2);
	}
}
