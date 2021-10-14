package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 영역구하기_백준 {
	static int N, M, K,c, Ans;
	static int[][] arr;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Integer> list = new ArrayList<Integer>();
	static class Point {
		int x, y;

		Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();

		arr = new int[M][N];
		v = new boolean[M][N];

		for (int i = 0; i < K; i++) {
			int sX = sc.nextInt();
			int sY = sc.nextInt();
			int eX = sc.nextInt();
			int eY = sc.nextInt();

			for (int j = sX; j < eX; j++) {
				for (int j2 = sY; j2 < eY; j2++) {
					arr[j2][j] = 1;
				}
			}
		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (!v[i][j] && arr[i][j] == 0) {
					c=0;
					Ans++;
					dfs(i, j);
					list.add(c);
				}
			}
		}
		System.out.println(Ans);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	private static void dfs(int i, int j) {
		v[i][j] = true;
		c++;
		for (int k = 0; k < 4; k++) {
			int nr = i+dr[k];
			int nc = j +dc[k];
			
			if (nr < 0 || nr >= M || nc < 0 || nc >= N || v[nr][nc]) {
				continue;
			}
			if(!v[nr][nc] && arr[nr][nc]==0) {
				dfs(nr,nc);
				
			}
		}
		
	}
}
