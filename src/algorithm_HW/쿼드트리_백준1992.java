package algorithm_HW;

import java.util.Scanner;

public class 쿼드트리_백준1992 {
	static int N,m;
	static int[][] video;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N=sc.nextInt();
		video = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				video[i][j] = str.charAt(j)-'0';
			}
		}
		exp(0,0,N);
	}
	private static void exp(int r, int c, int n) {
		if(chk(r, c, n)) System.out.print(m);
		else {
			System.out.print("(");
			int s = n/2;
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < 2; j++) {
					exp(r + s * i, c + s * j, s);
				}
			}
			System.out.print(")");
		}
	}
	private static boolean chk(int r, int c, int n) {
		int num = video[r][c];
		for (int i = r; i < r+n; i++) {
			for (int j = c; j < c+n; j++) {
				if(num != video[i][j]) {
					return false;
				}
			}
		}
		m = num;
		return true;
	}
}
