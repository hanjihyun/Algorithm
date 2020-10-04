package algorithm_practice;

import java.util.Arrays;

public class CombisTest {
	static int N;
	static int R;
	static int[] num;
	static boolean[] v;
	static int[] sel;
	public static void main(String[] args) {
		num = new int[] {1,2,3,4,5};
		N = num.length;
		R=3;
		sel = new int[R];
		v = new boolean[N];
		nCr(0,0);
	}
	private static void nCr(int idx, int k) {
		if(sel.length == k) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if(idx == N) {
			return;
		}
		for (int i = idx; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = num[i];
				nCr(i+1, k+1);
				v[i] = false;
			}
		}
	}
}
