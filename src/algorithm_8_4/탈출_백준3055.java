package algorithm_8_4;

import java.util.Scanner;

public class 탈출_백준3055 {
	static int R, C, cnt;
	static String result;
	static char[][] arr;
	static int[] dir = { -1, 1, 0, 0 };
	static int[] dic = { 0, 0, -1, 1 };
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		
		arr = new char[R][C];
		cnt = 0;

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		
	}

}
