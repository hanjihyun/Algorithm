package algorithm_2110;

import java.util.Arrays;
import java.util.Scanner;

public class 숫자카드_백준10815 {
	static int N, M;
	static int[] A, B;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = sc.nextInt();
		}
		Arrays.sort(A);

		M = sc.nextInt();
		B = new int[M];
		for (int i = 0; i < M; i++) {
			int n = sc.nextInt();
			if (serah(n)) {
				B[i] = 1;
			} else {
				B[i] = 0;
			}
		}
		for (int i = 0; i < M; i++) {
			System.out.print(B[i]+" ");
		}
}

	private static boolean serah(int n) {
		int left = 0;
		int right = N-1;
		while(left<=right) {
			int mid = (left+right) / 2;
			if(A[mid]==n) {
				return true;
			}
			if(A[mid] < n) {
				left = mid+1;
			}else {
				right = mid - 1;
			}
		}
		return false;
	}
}
