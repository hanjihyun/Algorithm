package algorithm_8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 하나로_Prim_SWEA1251 {
	static int N;
	static long[] x,y;
	static double E;
	static long result;
	static class Edge{
		int y;
		long p;

		public Edge(int y, long p) {
			this.y = y;
			this.p = p;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			x = new long[N];
			y = new long[N];			
			ArrayList<Edge>[] adj = new ArrayList[N];
			for (int i = 0; i < N; i++) {
				adj[i] = new ArrayList<Edge>();
			}
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}
			E = sc.nextDouble();

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					long dis =Math.abs(x[i] - x[j]) * Math.abs(x[i] - x[j])
							+ Math.abs(y[i] - y[j]) * Math.abs(y[i] - y[j]);
					adj[i].add(new Edge(j, dis));
					adj[j].add(new Edge(i, dis));
				}
			}

			boolean[] v = new boolean[N];
			long[] dist = new long[N];
			Arrays.fill(dist, Long.MAX_VALUE);
			//임의의 정점 하나 선택해서 시작
			dist[0] = 0;
			//선택한 정점과 인접하는 정점들 중 최소 비용 간선이 존재하는 정점 선택
			//모든 정점이 선택될 때 까지 
			for (int i = 1; i <= N-1; i++) {
				int minIdx = -1;
				long minD = Long.MAX_VALUE;
				for (int j = 0; j < N; j++) {
					if(!v[j] && dist[j]<minD) {
						minD = dist[j];
						minIdx = j;
					}
				}
				v[minIdx] = true;
			
				for (int j = 0; j < adj[minIdx].size(); j++) {
					if(!v[adj[minIdx].get(j).y] && adj[minIdx].get(j).p<dist[adj[minIdx].get(j).y]) {
						dist[adj[minIdx].get(j).y] = adj[minIdx].get(j).p;
					}
				}
			}
			
			result = 0;
			for (int i = 0; i < dist.length; i++) {
				result += dist[i];
			}
			  System.out.println("#"+test_case+" "+Math.round(result*E));
		}
		
	}

}