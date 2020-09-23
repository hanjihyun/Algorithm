package algorithm_IM_Review2;

import java.util.Scanner;

public class 색종이_백준2563 {
	static int N,cnt;
	static int[][] paper;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[101][101];
		cnt=0;
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			for (int j = x; j < x+10; j++) {
				for (int k = y; k < y+10; k++) {
					if(paper[j][k] != 1) {
						paper[j][k] = 1;
					}
				}
			}
		}
		for (int i = 0; i < 101; i++) {
			for (int j = 0; j < 101; j++) {
				if(paper[i][j]==1) {
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
