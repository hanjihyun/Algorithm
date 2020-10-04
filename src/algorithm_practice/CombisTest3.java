package algorithm_practice;

import java.util.Arrays;

public class CombisTest3 {

	static int N;
	static int R;
	static int[] num;
	static boolean[] v;

	public static void main(String[] args) {
		num = new int[] { 1, 2, 3, 4, 5 };
		N = num.length;
		R = 3;
		v = new boolean[N];
		nCr(0,0, new int[R]);
	}

	public static void nCr(int idx, int k, int[] a) {

		if(idx == N) {
			return;
		}

		if (k == R) {
			System.out.println(Arrays.toString(a));
			return;
		}

		a[k] = num[idx];
		// 파스칼의 삼각형
		// ncr=n-1Cr-1+n-1Cr
		nCr(idx+ 1, k+1, a);
		nCr(idx +1, k, a);

	}

}
