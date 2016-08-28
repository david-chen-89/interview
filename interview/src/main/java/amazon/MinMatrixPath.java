package amazon;

import java.util.LinkedList;
import java.util.Queue;

// https://www.careercup.com/question?id=5725333299920896 
public class MinMatrixPath {

	public static int minPath(int[][] m) {
		if (m == null)
			return 0;

		int len = m.length;
		Integer[][] costM = new Integer[len][len];
		Queue<Point> queue = new LinkedList<Point>();

		costM[0][0] = m[0][0];
		queue.add(new Point(0, 0));
		while (queue.peek() != null) {
			Point p = queue.poll();

			if (p.x < len - 1) {
				if (costM[p.x + 1][p.y] == null || costM[p.x + 1][p.y] > costM[p.x][p.y] + m[p.x + 1][p.y]) {
					costM[p.x + 1][p.y] = costM[p.x][p.y] + m[p.x + 1][p.y];
					queue.add(new Point(p.x + 1, p.y));
				}
			}

			if (p.y < len - 1) {
				if (costM[p.x][p.y + 1] == null || costM[p.x][p.y + 1] > costM[p.x][p.y] + m[p.x][p.y + 1]) {
					costM[p.x][p.y + 1] = costM[p.x][p.y] + m[p.x][p.y + 1];
					queue.add(new Point(p.x, p.y + 1));
				}
			}

			if (p.x < len - 1 && p.y < len - 1) {
				if (costM[p.x + 1][p.y + 1] == null || costM[p.x + 1][p.y + 1] > costM[p.x][p.y] + m[p.x + 1][p.y + 1]) {
					costM[p.x + 1][p.y + 1] = costM[p.x][p.y] + m[p.x + 1][p.y + 1];
					queue.add(new Point(p.x + 1, p.y + 1));
				}
			}
		}

		return costM[len - 1][len - 1];
	}

	public static void main(String[] args) {
		int[][] m = new int[3][3];
		m[0][0] = 4;
		m[0][1] = 0;
		m[0][2] = 2;
		m[1][0] = 1;
		m[1][1] = 3;
		m[1][2] = 0;
		m[2][0] = 0;
		m[2][1] = 1;
		m[2][2] = 2;

		System.out.println(minPath(m));

	}

}

class Point {
	public int x;
	public int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}