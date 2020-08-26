package algorithm_8_4;

import java.util.Scanner;

public class 행렬_백준1080 {
	static int N, M, result = 0, cnt;
	static int Ans = Integer.MAX_VALUE;
	static int[][] arrA, arrB;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arrA = new int[N][M]; //A배열
		arrB = new int[N][M]; //B배열
		cnt = 0;
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arrA[i][j] = str.charAt(j) - '0';
			}
		}
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arrB[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arrA[i][j] != arrB[i][j]) {
					if(change(i,j)) {
						result += 1;
					}else {
						System.out.println("-1");
						return;
					}
				}
			}
		}
		System.out.println(result);
	}

	private static boolean change(int r, int c) {
//		3*3행렬 원소 뒤집기
		if(r+3>N || c+3>M) { //행렬 벗어나지 않아야 하니까!!
			return false;
		}
		for (int i = r; i < r+3; i++) { //3*3
			for (int j = c; j < c+3; j++) {
				if(arrA[i][j] == 0) { //반대로 뒤집기
					arrA[i][j] = 1;
				}else {
					arrA[i][j] = 0;
				}
			}
		}
		return true;
	}

}
