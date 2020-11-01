package algorithm_10_5;

import java.util.Scanner;

public class 활주로건설_SWEA4014{
	static int N,X,Ans;
	static int[][] road1,road2;
	
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			X = sc.nextInt();
			
			road1 = new int[N][N];
			road2 = new int[N][N];
			Ans = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					road1[i][j] = sc.nextInt();
					road2[j][i] = road1[i][j];
				}
			}
		
			for (int i = 0; i < N; i++) {
				if (cal(road1, i)) {
					Ans++;
				}
				if (cal(road2, i)) {
					Ans++;
				}
			}


			System.out.println("#"+test_case+" "+Ans);
		}
	}
	private static boolean cal(int[][] map, int idx) {
		int cnt = 1;
		int height = map[idx][0];

		for (int i = 1; i < N; i++) {
			if (height == map[idx][i]) {
				cnt++;
			} else if (map[idx][i] - height == 1) {
				if (cnt < X) {
					return false;
				} else {
					cnt = 1;
					height = map[idx][i];
				}
			} else if (height - map[idx][i] == 1) {
				if (N < X + i) {
					return false;
				}
				for (int j = 1; j < X; j++) {
					if (height - map[idx][++i] != 1) {
						return false;
					}
				}
				height = map[idx][i];
				cnt = 0;
			} else {
				return false;
			}
		}
		return true;
	}
}