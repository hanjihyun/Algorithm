package algorithm_IM_Review;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*	
7
8
0 1
0 2	
1 3
1 4
2 4
3 5
4 5
5 6	
*/

public class DFSBFS {
	static String src = "7\r\n" + 
			"8\r\n" + 
			"0 1\r\n" + 
			"0 2	\r\n" + 
			"1 3\r\n" + 
			"1 4\r\n" + 
			"2 4\r\n" + 
			"3 5\r\n" + 
			"4 5\r\n" + 
			"5 6";
	static int N;
	static boolean map[][];
	private static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		N = sc.nextInt(); // 정점수
		int C = sc.nextInt(); // 간선수

		map = new boolean[N][N];
		visited = new boolean[N];

		for (int i = 0; i < C; ++i) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			map[to][from] = map[from][to] = true;
		}
		
		//System.out.println(Arrays.deepToString(map));

		System.out.println("=========dfs============");
		dfs(0);

		System.out.println("=========bfs============");
		bfs(0);

	}

	private static void dfs(int v) {// 번호 v로부터 시작하는 dfs
		visited[v] = true;		
		System.out.println(v);

		for (int i = 0; i < N; ++i) { 
			//v번째 행에서 탐색
			if (map[v][i] == true && !visited[i]) {
				//System.out.println(v + ":" + i);
				dfs(i);
			}
		}
	}

	
	private static void bfs(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean visited[] = new boolean[N];
		
		queue.offer(start); //처음에 0부터 시작
		visited[start] = true; 	// 들어갈때 방문 처리 !!!

		while (!queue.isEmpty()) {			
			int v = queue.poll();		
			System.out.println(v);
			//visited[v] = true; 
			
			for (int i = 0; i < N; ++i) {
				if (map[v][i] && !visited[i]) {
					queue.offer(i);
					visited[i] = true; 	//들어갈때 방문 처리!!!
				}
			}
		}
	}
}