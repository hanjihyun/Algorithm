package algorithm_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 최소스패닝트리1197_Prim {
	static int V, E;

	static class Edge implements Comparable<Edge> {
		int e, p;

		public Edge(int e, int p) {
			super();
			this.e = e;
			this.p = p;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return Integer.compare(this.p, o.p);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt(); // 정점
		E = sc.nextInt(); // 간선

		ArrayList<Edge> edges[] = new ArrayList[V+1];

		for (int i = 0; i < edges.length; i++) {
			edges[i] = new ArrayList<Edge>();
		}

		for (int i = 0; i < E; i++) {

			int s = sc.nextInt();
			int e = sc.nextInt();
			int p = sc.nextInt();
			edges[s].add(new Edge(e, p));
			edges[e].add(new Edge(s, p));
		}

		boolean[] v = new boolean[V+1];
		int[] dist = new int[V+1];
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 초기화

		// 임의 정점 하나 선택해서 시작
		dist[1] = 0;

		for (int c = 1; c <= V - 1; c++) {
			// 신장 트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기
			int minIdx = -1;
			int minD = Integer.MAX_VALUE;
			for (int j = 1; j <= V; j++) {
				if (dist[j] < minD && !v[j]) {
					minD = dist[j];
					minIdx = j;

				}
			}
			v[minIdx] = true;// 신장 트리에 포함 시킴.
			// 선택된 최소비용 정점 기준으로 신장 트리에 포함되지 않은 다른 정점으로의 비용 계산하여 최소값 갱신
			for (int i = 0; i < edges[minIdx].size(); i++) {
				if (!v[edges[minIdx].get(i).e] && edges[minIdx].get(i).p < dist[edges[minIdx].get(i).e]) {
					dist[edges[minIdx].get(i).e] = edges[minIdx].get(i).p; //신장 트리 비용 누적
				}
			}
		}
		int result = 0;
		for (int i = 1; i < dist.length; i++) {
			result += dist[i];
		}
		System.out.println(result);
	}
}
