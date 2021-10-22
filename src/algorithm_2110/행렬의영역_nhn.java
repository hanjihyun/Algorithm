package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 행렬의영역_nhn {
	static int c, Ans;
	static boolean[][] v;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static List<Integer> list;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		int sizeOfmatrix = sc.nextInt();
	

		int[][] matrix = new int[sizeOfmatrix][sizeOfmatrix];
		

		for (int i = 0; i < sizeOfmatrix; i++) {
			for (int j = 0; j < sizeOfmatrix; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}
		
		solution(sizeOfmatrix,matrix);
		
	}

	private static void solution(int sizeOfmatrix, int[][] matrix) {
		
		v = new boolean[sizeOfmatrix][sizeOfmatrix];
		list = new ArrayList<Integer>();
		
		Ans = 0;
		for (int i = 0; i < sizeOfmatrix; i++) {
			for (int j = 0; j < sizeOfmatrix; j++) {
				if (!v[i][j] && matrix[i][j] == 1) {
					c=0;
					Ans++;
					dfs(i, j,sizeOfmatrix,matrix);
					list.add(c);
				}
			}
		}
		System.out.println(Ans);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
		
	}

	private static void dfs(int x, int y,int N,int[][] matrix) {
		v[x][y] = true;
		c++;
		for (int k = 0; k < 4; k++) {
			int nr = x+dr[k];
			int nc = y +dc[k];
			
			if (nr < 0 || nr >= N || nc < 0 || nc >= N || v[nr][nc]) {
				continue;
			}
			if(!v[nr][nc] && matrix[nr][nc]==1) {
				dfs(nr,nc,N,matrix);
				
			}
		}
	}
}
