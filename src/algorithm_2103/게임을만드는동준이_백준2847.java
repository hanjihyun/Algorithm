package algorithm_2103;

import java.util.Scanner;

public class 게임을만드는동준이_백준2847 {
	static int N, res;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int[N];
		res = 0;

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
//		for (int i = 0; i < N; i++) {
//			System.out.println(arr[i]);
//		}
		for (int i = N-1; i > 0; i--) {
		
			while (arr[i] <= arr[i - 1]) {
				arr[i - 1]--;
				res++;
			}
			
		}
		System.out.println(res);
	}
}
