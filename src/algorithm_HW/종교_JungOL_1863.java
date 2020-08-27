package algorithm_HW;

import java.util.Arrays;
import java.util.Scanner;

public class 종교_JungOL_1863 {
	static int[] parents;
	static int[] cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();// 학생 수
		int M = sc.nextInt();// 쌍

		parents = new int[N + 1];
		cnt = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			makeSet(i);
		}

		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			Union(x, y);
		}

		int[] visit = new int[N + 1];

		//print();

		int total = 0;

		for (int i = 1; i <= N; i++) {

			find(i);

			visit[parents[i]]++;

		}

		for (int i = 1; i <= N; i++) {
			if (visit[i] != 0) {
				total++;
			}
		}

		System.out.println(total);

	}

	private static void print() {
		System.out.println(Arrays.toString(parents));
	}

	private static void Union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if (px != py) {

			if (cnt[px] < cnt[py]) {// 더 작은 애를 바꿔줘야 시간초과 안남
				parents[px] = py;
				cnt[px] += cnt[py];
			}
			else {
				parents[py] = px;
				cnt[py] += cnt[px];

			}

		}
	}

	private static int find(int i) {
		if (parents[i] == i) {
			return i;
		} else {
			int p = find(parents[i]);
			parents[i] = p;
			cnt[p]++;
			return p;
		}
	}

	private static void makeSet(int i) {
		parents[i] = i;
		cnt[i] = 1;
	}

}
