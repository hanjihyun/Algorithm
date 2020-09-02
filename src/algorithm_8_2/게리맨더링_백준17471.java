package algorithm_8_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 게리맨더링_백준17471 {
	static int N;
	static int[] popul;
	static boolean[] v;
	static int[][] edge;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		popul = new int[N + 1];
		v = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			popul[i] = sc.nextInt();
		}

		edge = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			int cnt = sc.nextInt();
			for (int j = 0; j < cnt; j++) {
				int e = sc.nextInt();
				edge[i][e] = 1;
				edge[e][i] = 1;
			}
		}

		powerSet(1);

		if (min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	private static void powerSet(int idx) {
		if (idx == popul.length) {

			
			if (check(v)) {
				// 두 선거수의 합! 구하기
				int sum1 = 0, sum2 = 0;
				for (int i = 1; i < edge.length; i++) {

					if (v[i]) {
						sum1 += popul[i];
					} else {
						sum2 += popul[i];
					}
				}
				min = Math.min(min, Math.abs(sum1 - sum2));

				return;
			}
			return;
		}

		v[idx] = true;
		powerSet(idx + 1);
		v[idx] = false;
		powerSet(idx + 1);
	}

	private static boolean check(boolean[] sel) {
		// 선거구 안의 구역들의 연결 여부 확인
		ArrayList<Integer> x = new ArrayList();
		ArrayList<Integer> y = new ArrayList();
		// 두 선거구의 구역들이 서로 연결되어 있는지 확인
		for (int i = 1; i < sel.length; i++) {
			if (sel[i]) {
				x.add(i);
			} else {
				y.add(i);
			}
		}
		if (x.size() == 0 || y.size() == 0) { // 두 선거구에 어디라도 선택된 구역이 없을 시
			return false;
		}
		boolean[] visit = new boolean[N + 1];
		dfs(x,x.get(0),visit);
		dfs(y,y.get(0),visit);
	
		for (int i = 1; i < visit.length; i++) {
			if(!visit[i]) return false;
		}
		return true;
	}

	private static void dfs(ArrayList<Integer> x, Integer idx, boolean[] visit) {
		visit[idx] = true;

		for (int i = 0; i < x.size(); i++) {
			if (edge[idx][x.get(i)] == 1 && !visit[x.get(i)]) {
				dfs(x, x.get(i),visit);
			}
		}
	}

}
