package algorithm_IM_Review;

import java.util.Scanner;

public class Intermediate {
	static int N, cnt;
	static int[] dir = { -1, 1, 0, 0 };
	static int[] dic = { 0, 0, -1, 1 };
	static char[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			map = new char[N + 1][N];
			
			cnt=0;
			for (int i = 0; i < N + 1; i++) {
				String str = sc.next();
				for (int j = 0; j < N; j++) {
					map[i][j] = str.charAt(j);
				}
			}
			
			
			int tower = 0;
			int nc,nr;
			for (int i = 0; i <N+1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'A') {
						tower=1;
						for (int k = 0; k < 4; k++) {
							nr = i+dir[k]*tower;
							nc = j+dic[k]*tower;
		
							if(map[nr][nc]=='H') {
								map[nr][nc] = 'X';
							}
						}
					}else if(map[i][j] == 'B') {
						tower=2;
						for (int k = 0; k < 4; k++) {
							nr = i+dir[k]*tower;
							nc = j+dic[k]*tower;
						
							if(map[nr][nc]=='H') {
								map[nr][nc] = 'X';
							}
						}
					}else if(map[i][j] == 'C') {
						tower=3;
						for (int k = 0; k < 4; k++) {
							nr = i+dir[k]*tower;
							nc = j+dic[k]*tower;
						
							if(map[nr][nc]=='H') {
								map[nr][nc] = 'X';
							}
						}
					}
				}
			}
			
//			for (int i = 0; i <N+1; i++) {
//				for (int j = 0; j < N; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			for (int i = 0; i <N+1; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'H') {
						cnt += 1;
					}
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
	}

}
