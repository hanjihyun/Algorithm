package algorithm_8_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 영역구하기_백준2583 {
	static int N,M,K,cnt,count;
	static boolean[][] v;
	static int[][] arr;
	static int dr[] = { -1, 1, 0, 0 };
	static int dc[] = { 0, 0, -1, 1 };
	static ArrayList<Integer> list = new ArrayList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		cnt=0;
		count=0;
		arr = new int[M+1][N+1];
		v = new boolean[M+1][N+1];
		int lX,lY,rX,rY;
		int[] change = new int[4];
		for (int k = 0; k < K; k++) {
			lX = sc.nextInt();
			lY = sc.nextInt();
			rX = sc.nextInt();
			rY = sc.nextInt();
			
			for (int i = lX; i < rX; i++) {
				for (int j = lY; j < rY; j++) {
					arr[j][i] = 1;
				}
			}
		}
//		for (int i = 0; i < M; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if(arr[i][j]==0 && !v[i][j]) {
					count++;
					cnt=0;
					dfs(i,j);
					
					list.add(cnt);
					
				}
			}
		}
		Collections.sort(list);
		System.out.print(count+"\n");		
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i));
			System.out.print(" ");
		}
	}
	private static void dfs(int i, int j) {
		arr[i][j] = 1;
		v[i][j] = true;
		cnt++;
		for (int k = 0; k < 4; k++) {
			int nr = i+dr[k];
			int nc = j+dc[k];
			
			if(nr<0 || nr >=M || nc<0 || nc>=N) {
				continue;
			}
			if(arr[nr][nc]==0 && !v[nr][nc]) {
				dfs(nr, nc);
			}
		}
	}
	
}

