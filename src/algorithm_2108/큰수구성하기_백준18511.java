package algorithm_2108;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 큰수구성하기_백준18511 {
	static int N, K, Ans;
	static int[] kList, sel;
	static List<Integer> nList;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		K = sc.nextInt();
		kList = new int[K];

		Ans = 0;

		for (int i = 0; i < K; i++) {
			kList[i] = sc.nextInt();
		}

		Arrays.sort(kList);
		dfs(0);
		System.out.println(Ans);
	}

	private static void dfs(int now) {
		if (now > N) {
			return;
		}
		if (Ans < now) {
			Ans = now;
		}
		for (int i = K - 1; i > -1; i--) {
			dfs(now * 10 + kList[i]);
		}
	}

}
