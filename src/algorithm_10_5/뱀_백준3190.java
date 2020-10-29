package algorithm_10_5;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class 뱀_백준3190 {
	static int N,K,L;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 }; //상0하1좌2우3
	static int[] dc = { 0, 0, -1, 1 };
	
	static char[] time;
	static class Snake{
		int r,c;

		Snake(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		map = new int[N][N];
		time = new char[10001];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = 0;
			}
		}
		map[0][0] = 2;
		for (int h = 0; h < K; h++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			map[r-1][c-1] = 1;
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		L = sc.nextInt();
		for (int i = 0; i < L; i++) {
			int n = sc.nextInt();
			char ch = sc.next().charAt(0);
			time[n] = ch;
		}
		Deque<Snake> deQ = new ArrayDeque<>();
		deQ.addLast(new Snake(0, 0));
		int d = 3;//우
		for (int i = 0; i < 10001; i++) {
			if(time[i] == 'D') {
				switch(d) {
				case 0: d=3;
                break;
                case 1: d=2;
                break;
                case 2: d=0;
                break;
                case 3: d=1;
                break;
                }
			}else if(time[i] == 'L') {
				switch(d) {
				case 0: d=2;
                break;
                case 1: d=3;
                break;
                case 2: d=1;
                break;
                case 3: d=0;
                break;
                }
			}
			Snake head = deQ.peekFirst();
			int nr = head.r + dr[d];
			int nc = head.c + dc[d];
			
			if(nr<0 || nr>=N || nc<0 || nc>=N || map[nr][nc]==2) {
				System.out.println(i + 1);
				break;
			}
			if(map[nr][nc] != 1) {
				Snake tail = deQ.removeLast();
				map[tail.r][tail.c] = 0;
			}
			map[nr][nc] = 2;
			deQ.addFirst(new Snake(nr, nc));
		}
	}
}
