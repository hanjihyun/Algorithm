package algorithm_HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
//그래프 간선들을 가중치의 오름차순으로 정렬한다.
//
//정렬된 간선 리스트에서 순서대로 간선 선택(사이클이 형성되지 않는)한다.
//
//가중치가 제일 낮은 간선 선택
//
//사이클이 형성되면 다음 간선 선택
//
//해당간선을 집합에 추가한다, N-1개의 간선이 될 때까지 반복한다.
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
			//간선list기준
		}
		
		Collections.sort(edges); //가중치 오름차순으로!
//		for (int i = 0; i < edges.size(); i++) {
//			Edge edge = edges.get(i);
//			System.out.println("s : "+edge.e+"end : "+edge.s+" "+edge.p);
//		}
		
		for (int i = 1; i <= V; i++) {
			parents[i] = i;
		}
		
		int sum = 0;//가중치
		int cnt = 0;//간선 체크 V까지(1부터라_)
		
		for (int i = 0; i < E; i++) { //싸이클인지 판단!
			Edge edge = edges.get(i);
			if(find(edge.s) != find(edge.e)) { //싸이클이 아니면
				sum += edge.p; //둘의 가중치 더해줌
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