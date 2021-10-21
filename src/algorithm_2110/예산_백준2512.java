package algorithm_2110;

import java.util.Arrays;
import java.util.Scanner;

public class 예산_백준2512 {
	static int N, M, answer;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];

		int sum = 0;
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		M = sc.nextInt();

		Arrays.sort(arr);
		int lef = 0, rig = arr[N - 1];

		if (sum <= M) {
			System.out.println(arr[N - 1]);
		} else {
			while (lef <= rig) {
				int Ans = 0;
				int mid = (lef + rig) / 2;
//				System.out.println(mid + " mid");
				for (int i = 0; i < arr.length; i++) {
					if (mid <= arr[i]) {
						Ans += mid;
					} else {
						Ans += arr[i];
					}
				}
				if (Ans > M) {

					rig = mid - 1;
				} else {
					lef = mid + 1;
					answer = Math.max(answer, mid);
				}
			}
			System.out.println(answer);
		}

	}
}
