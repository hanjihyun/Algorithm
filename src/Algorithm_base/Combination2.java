package Algorithm_base;

import java.util.Arrays;

public class Combination2 {
	static int[] arr = { 1, 3, 5 };
	static int[] sel = new int[2];

	public static void main(String[] args) {
		combination(0, 0);

	}

	private static void combination(int idx, int k) {
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		if (idx == arr.length) {
			return;
		}
		sel[k] = arr[idx];
		combination(idx + 1, k + 1);
		combination(idx + 1, k);
	}

}
