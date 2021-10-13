package algorithm_2110;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DFS와BFS_백준 {
	static int N, M, V;
	static int[][] arr;
	static boolean[] visit;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		V = sc.nextInt();

		arr = new int[N+1][N+1];
		visit = new boolean[N+1];
		for (int i = 0; i < M; ++i) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		dfs(V);
		visit = new boolean[N+1];
		System.out.println();
		bfs();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(V);
		visit[V] = true;
		System.out.print(V + " ");
		while(!q.isEmpty()) {
			int n = q.poll();
			
			for (int i = 1; i <= N; i++) {
				if(arr[n][i] == 1 && !visit[i]) {
					q.offer(i);
					visit[i] = true;
					System.out.print(i + " ");
				}
			}
		}
	}

	private static void dfs(int i) {
		visit[i] = true;
		System.out.print(i+" ");
		for (int j = 1; j <= N; j++) {
			if (arr[i][j] == 1 && !visit[j]) {
				dfs(j);
			}
		}
	}
}
