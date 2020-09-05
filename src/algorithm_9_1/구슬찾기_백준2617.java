package algorithm_9_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 구슬찾기_백준2617 {
	static int N, M, cnt=0;
	static int[] small;
	static int[] big;
	static boolean[] v;
	static ArrayList<Integer>[] sList;
	static ArrayList<Integer>[] bList;

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		big = new int[N+1];
		small = new int[N+1];

		sList = new ArrayList[N + 1];
		bList = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			sList[i] = new ArrayList<>();
			bList[i] = new ArrayList<>();
		}
	
		v = new boolean[N+1];

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sList[x].add(y);
			bList[y].add(x);
		}
		int mid = (N+1)/2;
		for (int i = 1; i <= N; i++) {
			v = new boolean[N + 1];
			small[i] = dfs(i, sList);
			v = new boolean[N + 1];
			big[i] = dfs(i, bList);
			
			if (small[i] > mid || big[i] > mid) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}

	private static int dfs(int idx, ArrayList<Integer>[] list) {
		int sum = 0;
		v[idx] = true;
		for (int num : list[idx]) {
			if (!v[num]) {
				v[num] = true;
				sum += dfs(num, list) + 1;
			}
		}
		return sum;
	}

}
