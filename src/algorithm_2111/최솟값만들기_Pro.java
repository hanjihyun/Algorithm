package algorithm_2111;

import java.util.Arrays;

public class 최솟값만들기_Pro {
	public static void main(String[] args) {
		int[] A = { 1, 4, 2 };
		int[] B = { 5, 4, 4 };
		int answer = 0;
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		for (int i = 0; i < A.length; i++) {
			answer+=A[i]*B[A.length-1-i];
		}
		System.out.println(answer);
	}



}
