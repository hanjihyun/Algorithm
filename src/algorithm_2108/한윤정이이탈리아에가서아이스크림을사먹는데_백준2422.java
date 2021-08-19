package algorithm_2108;

import java.util.Arrays;
import java.util.Scanner;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_백준2422 {
	static int N, M, Ans;
	static int[] sel;
	static boolean[][] pairs;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[3];
		pairs = new boolean[N][N];
		v = new boolean[N];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			pairs[a][b] = true;
			pairs[b][a] = true;
		}
		Ans = 0;
		combiO(0, 0);

		System.out.println(Ans);
	}

	private static void combiO(int idx, int k) {
		if (k == 3) {
			boolean chk = true;

			for (int i = 0; i < 2; i++) {
				for (int j = i + 1; j < 3; j++) {
					if (pairs[sel[i]][sel[j]])
						chk = false;
				}
			}

			if (chk == true) {
				Ans++;
				System.out.println(Arrays.toString(sel));
			}
			return;
		}

		for (int i = idx; i < N; i++) {
			if (!v[i]) {
				v[i] = true;
				sel[k] = i;
				combiO(i, k + 1);
				v[i] = false;
			}
		}
	}
}
