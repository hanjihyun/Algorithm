package algorithm_8_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 별자리만들기_백준4386 {
	static int N;
	static double x, y, cost;
	static Node[] nodes;
	static int[] parents;
	static ArrayList<Edge> list = new ArrayList();

	static class Edge implements Comparable<Edge> {
		int x, y;
		double c;

		public Edge(int x, int y, double c) {
			super();
			this.x = x;
			this.y = y;
			this.c = c;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			if (this.c > o.c)
				return 1;
			return -1;

		}

	}

	static class Node {
		int num;
		double x, y;

		public Node(int num, double x, double y) {
			super();
			this.num = num;
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		nodes = new Node[N];
		cost = 0;
		for (int i = 0; i < N; i++) {
			x = sc.nextDouble();
			y = sc.nextDouble();
			nodes[i] = new Node(i, x, y);
		}

		for (int i = 0; i < N; i++) {
			getEdgeCost(i, nodes[i]);
		}

		Collections.sort(list);
		parents = new int[N];
		// makeSet
		for (int i = 0; i < N; i++) {
			parents[i] = i;
		}

		for (Edge edge : list) {
			if (find(edge.x) != find(edge.y)) {

				cost += edge.c;
				union(edge.x, edge.y);
			}
		}
		System.out.printf("%.2f", cost);
	}

	private static void union(int x1, int y1) {
		x1 = find(x1);
		y1 = find(y1);
		if (x1 != y1) {
			parents[y1] = x1;
		}
	}

	private static int find(int xE) {
		if (parents[xE] == xE) {
			return xE;
		} else {
			return parents[xE] = find(parents[xE]);
		}
	}

	private static void getEdgeCost(int index, Node node) {
		for (int i = index + 1; i < N; ++i) {
			double x_pow = Math.pow(node.x - nodes[i].x,2);
			double y_pow = Math.pow(node.y - nodes[i].y,2);
			double cost = Math.sqrt(x_pow + y_pow);

			list.add(new Edge(node.num, nodes[i].num, cost));
		}
	}

}
