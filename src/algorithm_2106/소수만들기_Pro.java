package algorithm_2106;

import java.util.Arrays;

public class 소수만들기_Pro {

	static int[] sel = new int[3];
	static int answer = 0;

	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 6, 4 };
		boolean[] v = new boolean[nums.length];
		combination(0, 0, nums, v);
		System.out.println(answer);
	}

	private static void combination(int idx, int k, int[] nums, boolean[] v) {
		if (k == sel.length) {
			System.out.println(Arrays.toString(sel));
			int sum = 0;
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];

			}
			if (sum == 1) {
				answer = -1;
			}
			for (int i = 2; i * i <= sum; i++) {
				if (sum % i == 0) {
					return;
				}
			}
			answer++;
			System.out.println(sum);
			return;
		}
		if (idx == nums.length) {

			return;
		}
		sel[k] = nums[idx];
		combination(idx + 1, k + 1, nums, v);
		combination(idx + 1, k, nums, v);
	}

}
