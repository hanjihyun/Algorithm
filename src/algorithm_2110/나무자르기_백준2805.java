package algorithm_2110;

import java.util.Arrays;
import java.util.Scanner;

public class 나무자르기_백준2805 {
	static int N, M;
	static int[] tree;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		tree = new int[N];
		int le = 0;
		int ri = 0;

		for (int i = 0; i < N; i++) {
			tree[i] = sc.nextInt();
			ri = Math.max(ri, tree[i]);
		}
		Arrays.sort(tree);
		int Ans = 0;
		while (le <= ri) {
			long cnt = 0;
			int mid = (le + ri) / 2;

			for (int i = 0; i < N; i++) {
				if (mid < tree[i]) {
					cnt += tree[i] - mid;
				}
			}
			if (cnt >= M) {
				le = mid + 1;
				Ans = mid;
			} else {
				ri = mid - 1;
			}

		}
		System.out.println(Ans);
	}
}
