package algorithm_IM_Review2;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_백준2309_조합 {
	static int[] arr = new int[9];
	static int[] members = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		combination(0, 0);
	}

	private static void combination(int idx, int k) {
		int sum = 0;
		if (members.length == k) {
			for (int i = 0; i < members.length; i++) {
				sum += members[i];
			}

			if (sum == 100) {
				Arrays.sort(members);
				for (int j = 0; j < members.length; j++) {
					System.out.println(members[j]);
				}
			}
			return;
		}
		if(idx == arr.length) {
			return;
		}
		members[k] = arr[idx];
		combination(idx + 1, k + 1);
		combination(idx + 1, k);
	}
}
