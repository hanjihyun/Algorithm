package com.algo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 택배_백준1719 {
	static int n, m;

	static final int INF = Integer.MAX_VALUE;
	static List<List<Edge>> list;
	static StringBuilder sb = new StringBuilder();
	
	static class Edge implements Comparable<Edge> {
		int v, w;

		public Edge(int v, int w) {
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
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		n =Integer.parseInt(st.nextToken()); // 집하장, 정점
		m = Integer.parseInt(st.nextToken());  // 집하장 간 경로 개수, 간선
		
	
		
		list = new ArrayList<>();
		list.add(new <Edge>ArrayList());
		for (int i = 1; i <= n; i++) {
			list.add(new ArrayList<Edge>());
		}
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(in.readLine());
			int u = Integer.parseInt(st.nextToken()); // 출발
			int v = Integer.parseInt(st.nextToken()); // 도착
			int w = Integer.parseInt(st.nextToken()); // 시간
			// 인접리스트
			list.get(u).add(new Edge(v, w));
			list.get(v).add(new Edge(u, w));

		}
		for (int i = 1; i <= n; i++) {
			dij(i);
		}
		
		System.out.println(sb.toString());
	}

	private static void dij(int i) {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		
		 int[] distance = new int[n+1]; 
		 int[] trace= new int[n+1]; 
		 boolean[] visit = new boolean[n+1];
		
		 Arrays.fill(distance, INF); //거리 저장 배열, 최대 값으로 초기화
		distance[i] = 0; //시작 위치 선택
		trace[i] = i;
		pq.add(new Edge(i,0));
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			if(visit[cur.v])continue;//방문 했으면 pass
			visit[cur.v] = true; //방문 체크
			
			for (Edge next :list.get(cur.v)) {
//				최소 비용이 갱신 될 때만 큐에 넣음
				if(distance[next.v] > distance[cur.v]+next.w) {
					//최소 거리 비용 갱신
					distance[next.v] = distance[cur.v]+next.w;
					//해당 정점 까지 가기 위해 현재를 거쳐야 하는거 표시?
					trace[next.v] = cur.v;
					pq.add(new Edge(next.v, distance[next.v]));
				}
			}
			
		}
		//경로 추적
		tracert(i,trace);
		
	}

	private static void tracert(int start, int[] trace2) {
		
		for (int k = 1; k <= n; k++) {
			if(k == start) {
				sb.append("- ");
				continue;
			}
			int ans = 0;
			for (int i = k; i != start; i=trace2[i]) {
				//가장 먼저 방문해야되는 정점이 되도록 
				ans = i;
			}
			sb.append(ans+" ");
		}
		sb.append("\n");
	}
}
