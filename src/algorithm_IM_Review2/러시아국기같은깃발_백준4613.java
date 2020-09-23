package algorithm_IM_Review2;

import java.util.Arrays;
import java.util.Scanner;

public class 러시아국기같은깃발_백준4613 {
	static int N, M, cnt;
	static char[][] map;
	static int[] w,r,b;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			cnt = 0;
			map = new char[N][M];
			
			w = new int[N];
			r = new int[N];
			b = new int[N];
			
			for (int i = 0; i < N; i++) {
				String str = sc.next();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					//각 행별로 개수 저장
					if(map[i][j] == 'W') w[i]++;
					else if(map[i][j] == 'B') b[i]++;
					else r[i]++;
				}
			}
			
//			System.out.println(Arrays.toString(w));
//			System.out.println(Arrays.toString(b));
//			System.out.println(Arrays.toString(r));
//			for (int i = 0; i < N; i++) {
//				for (int j = 0; j < M; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			
			// 2~?에서 흰VS파랑 카운트 해서 더 많은 것에
			for (int i = 1; i <= N - 2; i++) {
				for (int j = i; j <= N-2; j++) {
					int bCnt = 0, rCnt = 0, wCnt = 0;
					//화이트 개수
					for (int k = 0; k < i; k++) {
						wCnt+=w[k];
					}
					//블루 개수
					for (int k = i; k <= j; k++) {
						bCnt+=b[k];
					}
					//레드 개수
					for (int k = j+1; k < N; k++) {
						rCnt+=r[k];
					}
					cnt = Math.max(cnt, (wCnt+bCnt+rCnt));
				}
			}
			cnt = N*M-cnt;
			System.out.println("#" + test_case + " " + cnt);
		}
	}
}