package algorithm_HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 최소스패닝트리1197_Kruskal {
	static int V,E;
	static int[] parents;
	
	static class Edge implements Comparable<Edge>{
		int s,e,p;

		public Edge(int s, int e, int p) {
			super();
			this.s = s;
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
		V = sc.nextInt();
		E = sc.nextInt();
		ArrayList<Edge> edges = new ArrayList<Edge>();
		
		parents = new int[V+1];
		
		for (int i = 0; i < E; i++) {
			
			int s = sc.nextInt();
			int e = sc.nextInt();
			int p = sc.nextInt();
			edges.add(new Edge(s, e, p));
			
		}
		
		Collections.sort(edges);
//		for (int i = 0; i < edges.size(); i++) {
//			Edge edge = edges.get(i);
//			System.out.println("s : "+edge.e+"end : "+edge.s+" "+edge.p);
//		}
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int sum = 0;
		int cnt = 0;
		
		for (int i = 0; i < E; i++) {
			Edge edge = edges.get(i);
			if(find(edge.s) != find(edge.e)) {
				sum += edge.p;
				union(edge.s,edge.e);
				cnt++;
				if(cnt == V) {
					break;
				}
			}
		}
		System.out.println(sum);
	}
	private static int union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		if(ps>=pe) {
			return parents[ps] = pe;
		}else {
			return parents[pe] = ps;
		}
	}
	private static int find(int x) {
		if(parents[x] == x) {
			return parents[x];
		}else {
			return find(parents[x]);
		}
	}
}