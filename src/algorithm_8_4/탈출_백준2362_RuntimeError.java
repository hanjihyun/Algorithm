package algorithm_8_4;

import java.util.Scanner;

public class 탈출_백준2362_RuntimeError {
	static int N, K, cnt;
	static String result;
	static char[][] arr;
	static int[] dir = { -1, 1, 0, 0 };
	static int[] dic = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new char[N][N];
		cnt = 0;

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 'O') {
					for (int k = 0; k < 4; k++) {

						int nr = i + dir[k];
						int nc = j + dic[k];
						if(nr<0 || nr >=N || nc<0 || nc>=N) {
							continue;
						}
						if (arr[nr][nc] == 'X') {
							result = "No";
						} else {
							result = "Yes";
							cnt += 1;
						}
					}
				}
			}
		}
		System.out.println(result);
		System.out.println(cnt);
	}

}
