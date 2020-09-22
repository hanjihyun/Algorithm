package algorithm_IM_Review2;

import java.util.Arrays;
import java.util.Scanner;

public class 수열_백준2559 {
	static int[] tem;
	static boolean[] v;
	static int[] sel;
	static int N, K, count, max;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		tem = new int[N];
		sel = new int[100001];
		
		for (int i = 0; i < N; i++) {
			tem[i] = sc.nextInt();
		}

		count = 0;
		max = Integer.MIN_VALUE;
		int index = 0;

		for (int j = 0; j < K; j++) {
			count += tem[j];
		}

		sel[0] = count - tem[0];
		max = count;
		count = 0;
		for (int i = 0; i < N-K; i++) {
			count = sel[i] + tem[i + K];
			sel[i + 1] = count - tem[i + 1];
			max = Math.max(max, count);
			count = 0;
		}
		System.out.println(max);
	}
	
}
