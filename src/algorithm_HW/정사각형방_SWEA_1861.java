package algorithm_HW;

import java.util.Scanner;

public class 정사각형방_SWEA_1861 {
	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int N;
	static int max=0,start=0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			
			N = sc.nextInt();
			arr = new int[N][N];

			for (int i = 0; i < N; i++) {	
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			max = 0;
			start = arr[0][0];
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					find(i,j,1,arr[i][j]);
				}
			}

			System.out.println("#" + test_case + " " + start + " " + max);
		}

	}

	public static void find(int x, int y, int cnt, int locate) {

		for (int k = 0; k < 4; k++) {
			
			int nr = x + dr[k];
			int nc = y + dc[k];

			if (nr < 0 || nr > N-1 || nc < 0 || nc > N-1) {
				continue;
			}
			if (arr[nr][nc] == arr[x][y] + 1) {
				find(nr,nc,++cnt,locate);//더 이동할 곳이 있는지
			}
			if(max == cnt) {
				if(start>locate) {
					//최대값 같으면 작은값 저장
					start = locate;
				}
			}
			if(max<cnt) {
				max = cnt;
				//최대값 찾으면, 저장하고 
				//위치도 저장하고, 거기 부터 다시 시작
				start=locate;
			}
		}
		
	}
}