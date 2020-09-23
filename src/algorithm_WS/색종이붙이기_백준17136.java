package algorithm_WS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 색종이붙이기_백준17136 {

	static int[][] map, cnt;
	static boolean[][] v;
	static int Ans = Integer.MAX_VALUE;
	static int[] papers = { 5,5,5,5,5 };
	static List<Point> list = new ArrayList<>();

	static class Point {
		int r, c;

		Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[10][10];
		v = new boolean[10][10];

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					list.add(new Point(i, j));
				}
			}
		}

		dfs(0, 0, 0);
		System.out.println(Ans == Integer.MAX_VALUE ? -1 : Ans);
	}

	private static void dfs(int i, int j,int k) {
		if (check(i, j)) {
			Ans++;
			return;
		} else {
			Point p = list.get(k);
			if(map[p.r][p.c] == 1) {
				for (int l = 0; l < 5; l++) {
					for (int m = 0; m < 5; m++) {
						if(map[l][m] != 1) {
							papers[l]--;
						}
					}
				}
			}

		}

	}

	private static boolean check(int x, int y) {
		int num = map[x][y];
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				if (num != map[i][j]) { // 숫자 달라지면,
					return false; // 다른 숫자를 가지므로 false
				}
			}
		}
		return true;
	}

}
