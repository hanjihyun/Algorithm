package Algorithm_base;

import java.util.Arrays;

public class Combination {
	static int arr[] = { 1, 3, 5 };
	static int sel[] = new int[2];

	// 조합 - 순서 상관 없음
	public static void main(String[] args) {
		combination(0, 0, new boolean[arr.length]);
	}

	private static void combination(int idx, int k, boolean[] v) {
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			if (v[i] != true) {
				v[i] = true;
				sel[k] = arr[i];
				combination(idx + 1, k + 1, v);
				v[i] = false;
			}
		}
	}
}
