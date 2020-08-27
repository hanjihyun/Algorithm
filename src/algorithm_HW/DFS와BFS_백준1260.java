package algorithm_HW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS_백준1260 {
	static int N, M;
	static int from, to;
	static int max = 1000+1;
	static int[][] adj;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();// 정점
		M = sc.nextInt();// 간선
		int start = sc.nextInt();// 시작할 정점 번호
		 adj = new int[max][max];

		for (int i = 0; i < M; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			adj[from][to]=1;
			adj[to][from]=1;
		}
		

		dfs(adj,start,new boolean[N + 1]);
		System.out.println();
		bfs(adj,start);

	}

	private static void bfs(int[][] adj, int start) {
		boolean v[] = new boolean[N+1];
		Queue<Integer> Q = new LinkedList<Integer>();
		Q.add(start);
		v[start]=true;
		while(!Q.isEmpty()) {
			Integer p = Q.poll();
			System.out.print(p+" ");
			for (int i = 1; i <= N; i++) {
				if(adj[p][i]==1 && !v[i] ) {
					v[i]=true;
					Q.add(i);
				}
			}
		}
	}

	private static void dfs(int[][] adj, int start, boolean[] v) {
		v[start]=true;
		System.out.print(start + " ");
		for (int i = 1; i < N+1; i++) {
			if(adj[start][i]==1 && !v[i]) {
				dfs(adj,i,v);
			}
		}
	}


}
