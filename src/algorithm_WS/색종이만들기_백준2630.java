package algorithm_WS;

import java.util.Scanner;

public class 색종이만들기_백준2630 {
	static int N, wCnt, BCnt;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
		wCnt = 0;
		BCnt = 0;
		exp(0, 0, N);
		System.out.print(wCnt + "\n" + BCnt);
	}

	private static void exp(int x, int y, int n) {
		if (check(x, y, n)) {  //같은 색을 가지고 있나 check
			//true면 끝
			return;
		}else {//아니면 4분면으로 나눠서 재귀 호출
			exp(x, y, n / 2); //1
			exp(x, y + n / 2, n / 2); //2
			exp(x + n / 2, y, n / 2); //3
			exp(x + n / 2, y + n / 2, n / 2); //4
		}

	}

	private static boolean check(int x, int y, int n) {
		int num = map[x][y];
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (num != map[i][j]) { //숫자 달라지면,
					return false; //다른 숫자를 가지므로 false 
				}
			}
		}
		//범위 안에서 모두 같은 수 를 가지면 해당 숫자의 색상에 +1
		if (num == 1) {
			BCnt += 1;
		} else {
			wCnt += 1;
		}
		return true;
	}

}
