package algorithm_2110;

import java.util.Scanner;

public class 바이러스_백준 {
	static int computer,pair,Ans;
	static int[][] arr;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();
		pair = sc.nextInt();
		arr = new int[computer+1][computer+1];
		v = new boolean[computer+1];
		for (int i = 0; i < pair; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = arr[b][a] = 1;
		}
		
		dfs(1);
		System.out.println(Ans);
	}
	private static void dfs(int i) {
		v[i] = true;
		
		for (int j = 1; j <= computer; j++) {
			if(arr[i][j] == 1 && !v[j]) {
				Ans++;
				dfs(j);
			}
		}
		
	}
}
