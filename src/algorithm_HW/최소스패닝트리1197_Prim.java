package algorithm_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//임의 정점을 하나 선택해서 시작한다.
//
//선택한 정점과 인접하는 정점들 중의 최소 비용의 간선이 존재하는 정점을 선택한다.
//
//모든 정점이 선택될 때까지 1,2번 과정을 반복해서 실행한다.

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

		//정점 list
		for (int i = 0; i < E; i++) {
			//from, to, 가중치 입력 받아서 
			int s = sc.nextInt();
			int e = sc.nextInt();
			int p = sc.nextInt();
			//마주보는것 다 체크하기 위해
			//인접리스트
			edges[s].add(new Edge(e, p));
			edges[e].add(new Edge(s, p));
		}

		boolean[] v = new boolean[V+1]; //정점 방문체크 배열
		
		//정점 도달 비용
		int[] dist = new int[V+1]; //1~V까지, 어딘가의 정점부터 해당 인덱스(정점)까지 올 수 있는 최소 비용 입력
		
		//정점에게 도달하는 최소값으로 update을 할 수 있도록
		Arrays.fill(dist, Integer.MAX_VALUE); // 최대값으로 초기화

		// 임의 정점 하나 선택해서 시작, 스스로에게 오는 비용이 없으므로
		dist[1] = 0;//시작정점 0으로 초기화

		//최소 신장 트리는 정점 V-1개면 완성되므로 for문을 V-1만큼 돌림 
		for (int c = 1; c <= V - 1; c++) {
			// 신장 트리에 포함되지 않은 정점 중 최소 간선 비용의 정점 찾기
			//정점들 중 도달할 때까지 비용이 가장 작은 정점을 찾기 위함
			int minIdx = -1; //선택한 정점을 저장하기위한 변수
			int minD = Integer.MAX_VALUE; //dist의 최소값을 찾기 위해 - 값이 낮은 것부터 연결해야되기 때문에
			for (int j = 1; j <= V; j++) {
				if (dist[j] < minD && !v[j]) { //선택할 정점을 찾기 위한 for
					minD = dist[j];
					minIdx = j;
				}
			}
			//정점 방문 체크
			v[minIdx] = true;// 신장 트리에 포함 시킴.
			
			// 선택된 최소비용 정점 기준으로 신장 트리에 포함되지 않은 다른 정점으로의 비용 계산하여 최소값 갱신
			for (int i = 0; i < edges[minIdx].size(); i++) {
				//dist에 이미 들어가 있는 값과 비교해서 작은 값으로 update
				if (!v[edges[minIdx].get(i).e] && edges[minIdx].get(i).p < dist[edges[minIdx].get(i).e]) {
					dist[edges[minIdx].get(i).e] = edges[minIdx].get(i).p; //신장 트리 비용 누적
				}
			}
		}
		int result = 0;
		//dist에 최소값을 저장해 놓아서 다 더해주면 최소 비용 결과를 얻을 수 있다.
		for (int i = 1; i < dist.length; i++) {
			result += dist[i];
		}
		System.out.println(result);
	}
}
