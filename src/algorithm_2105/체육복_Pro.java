package algorithm_2105;

import java.util.Arrays;

public class 체육복_Pro {
	public static void main(String[] args) {
		int n = 5;
		int[] lost = { 2, 3, 4 };
		int[] reserve = { 1, 2, 3 };
		int answer = 0;
		Arrays.sort(lost);
		boolean[] chk = new boolean[n + 1];
		boolean[] have = new boolean[n + 1];
		for (int i = 0; i < reserve.length; i++) {
			chk[reserve[i]] = true;
		}
		for (int i = 0; i < lost.length; i++) {
			have[lost[i]] = true;
		}

		for (int i = 0; i < lost.length; i++) {
			if (chk[lost[i]] == true) {
				have[lost[i]] = false;
				chk[lost[i]] = false;
			}
		}

		for (int index = lost.length - 1; index >= 0; index--) {

			if (lost[index] + 1 <= n) {
				if (chk[lost[index] + 1] == true) {
					have[lost[index]] = false;
					chk[lost[index] + 1] = false;
					continue;
				}

			}

			if (lost[index] - 1 > 0) {
				if (chk[lost[index] - 1] == true) {
					have[lost[index]] = false;
					chk[lost[index] - 1] = false;

				}
			}

		}
		for (int i = 1; i <= n; i++) {
			System.out.println(have[i]);
		}
		for (int i = 1; i < have.length; i++) {
			if (have[i] == false) {
				answer++;
			}
		}
		System.out.println(answer);

	}
}
