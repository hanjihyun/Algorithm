package algorithm_WS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 최단경로_백준1753 {
	static int V, E, K;
	static int[] distance;
	static boolean[] visit;
	static final int INF = Integer.MAX_VALUE;

	static class Edge implements Comparable<Edge>{
		int v, w;

		Edge(int v, int w) {
			this.v = v;// 도착
			this.w = w;// 가중치
		}
		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.w, o.w);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		
		V = Integer.parseInt(st.nextToken()); // 정점의 개수
		E = Integer.parseInt(st.nextToken()); // 간선의 개수
		K = Integer.parseInt(in.readLine()); // 시작 정점
		
		distance = new int[V+1]; 
		visit = new boolean[V+1];
		
		ArrayList<Edge> list[] = new ArrayList[V+1];
		
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<Edge>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			int u = Integer.parseInt(st.nextToken()); // 출발
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 가중치
			//인접리스트
			list[u].add(new Edge(v, w));

		}
		Arrays.fill(distance, INF); //거리 저장 배열, 최대 값으로 초기화

		distance[K] = 0; //시작 위치 선택
		
		int min = 0, curIdx=0;
		for (int i = 1; i <= V; i++) {
			min = INF;
			//방문하지 않았고, 정점들 중 출발지에서 자신까지 오는 모든 비용이 최단인 정점을 고려해 경유지로 선택
			for (int j = 1; j <= V; j++) {
				if(!visit[j] && min >distance[j]) { 
					min = distance[j]; //최소인 최단거리 값 선택
					curIdx = j; //현재 위치 저장
				}
			}
			visit[curIdx] = true; // 방문체크
			
			for (int j = 0; j < list[curIdx].size(); j++) {
				Edge ed = list[curIdx].get(j);
				if(!visit[ed.v] &&  distance[ed.v] > min + ed.w) {
					distance[ed.v] = min + ed.w;
				}
			}
		}
		for (int i = 1; i <= V; i++) {
			if(distance[i] == INF) {
				System.out.println("INF");
			}else {
				System.out.println(distance[i]);
			}
		}
	}
}
