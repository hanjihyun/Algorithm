package algorithm_8_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 하나로_Kruskal_SWEA1251 {
	static int N, total;
	static int[] x,y;
	static double E;
	static int[] parents;
	static List<Edge> list;

	static class Edge implements Comparable<Edge> {
		int x, y;
		double p;

		public Edge(int x, int y, double p) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
		}

		@Override
		public int compareTo(Edge o) {
			return Double.compare(this.p, o.p); 
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			x = new int[N];
			y = new int[N];
			E = 0.0;
			
		
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				y[i] = sc.nextInt();
			}
			E = sc.nextDouble();

			list = new ArrayList<>();

			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					double dis = (long)(Math.pow(Math.abs(x[i] - x[j]), 2) + Math.pow(Math.abs(y[i] - y[j]), 2));
					list.add(new Edge(i, j, dis));// 좌표랑 거리 저장
				}
			}
			
			Collections.sort(list); // sort
			
			parents = new int[N];
			
			for (int i = 0; i < N; i++) {
				makeSet(i);
			} // 처음 parents배열 초기화->자기 자신이 대표자

			long result = 0;
			total = 0;
			for(int i=0; i<(N*(N-1)/2); i++) {
				int v1 = find(list.get(i).x);
				int v2 = find(list.get(i).y);
				if(v1==v2) continue;
				result += list.get(i).p;
				Union(v1, v2);
				total++;
				if(total==N-1) break;
			}
			  System.out.println("#"+test_case+" "+Math.round(result*E));
		}
		
	}

	private static void makeSet(int i) {
		parents[i] = i;

	}

	private static int find(int x) {
		if (parents[x] == x) {
			return x;
		} else {
			return parents[x] = find(parents[x]); //중간중간 부모 갱신
		}
	}

	private static void Union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px < py) {
			parents[px] = py;

		}else {
			parents[py] = px;
		}

	}
}