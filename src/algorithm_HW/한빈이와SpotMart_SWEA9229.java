package algorithm_HW;

import java.util.Arrays;
import java.util.Scanner;

public class 한빈이와SpotMart_SWEA9229 {
	static int[] snackW;
	static int[] sel = new int[2];
	static int N, M, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			max = Integer.MIN_VALUE;
			N = sc.nextInt();
			M = sc.nextInt();
			snackW = new int[N];

			for (int i = 0; i < N; i++) {
				snackW[i] = sc.nextInt();
			}

			combination(0, 0, new boolean[snackW.length]);

			if (max <= 0 || max > M) {
				max = -1;
				System.out.print("#" + test_case + " " + max);
			} else {
				System.out.print("#" + test_case + " " + max);

			}
			System.out.println();
		}
	}

	private static void combination(int idx, int k, boolean[] v) {
		int sum = 0;
		if (k == sel.length) {
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			//System.out.println("sum" + sum);
			int temp = 0;
			if (max < sum && sum <= M) {
				temp = max;
				max = sum;
				sum = max;
			}
		//	System.out.println(Arrays.toString(sel));
			return;
		}

		for (int i = idx; i < snackW.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				sel[k] = snackW[i];
				combination( i + 1, k + 1, v);
				v[i] = false;
			}
		}
	}
}