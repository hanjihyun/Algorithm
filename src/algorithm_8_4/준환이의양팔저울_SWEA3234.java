package algorithm_8_4;

import java.util.Arrays;
import java.util.Scanner;

public class 준환이의양팔저울_SWEA3234 {
	static int N, cnt;
	static int[] arr;
	static boolean[] v;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			arr = new int[N];
			v = new boolean[N];
			cnt=0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			//순열,dfs
			permutation(0, 0, 0);
		
			System.out.println("#" + test_case + " " + cnt);
		}
	}

	private static void permutation(int dep, int left, int right) {

		if(dep == N-1) {
			cnt++;
			for (int i = 0; i < N; i++) {
				//v처리가 안된 추를 더해보고 left가 더 크면 횟수를 증가시킨다.
				if(!v[i] && left >= right+arr[i]) {
					cnt++;
				}
			}
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
//				sel[k] = arr[i];
				permutation(dep+1, left+arr[i],right);
				if(left >= right+arr[i]) {
					permutation(dep+1, left,right+arr[i]);	
				}
				v[i] = false;
			}
				
		}
	}
}