package algorithm_IM_Review2;

import java.util.Scanner;

public class 체스판다시칠하기_백준1018 {
	static int[][] board, chessW, chessB;
	static int M, N, count;
	// 1.8*8이면
	// 바로 0,0 체크해서 칠할 것 카운트
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		board = new int[N][M];
		chessW = new int[8][8];
		chessB = new int[8][8];

		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				if (str.charAt(j) == 'W') {
					board[i][j] = 0;
				} else {
					board[i][j] = 1;
				}
			}
		}

		init();


		System.out.println(process());
	}

	private static void init() {
		int size = 64, r, c, v = 0;
		for (int i = 0; i < size; ++i) {
			// i = 10 : 1행 2열 i/8:행 i%8:열
			r = i / 8;
			c = i % 8;
			chessW[r][c] = v; // v:0
			chessB[r][c] = v ^ 1;// 0^1 : 1

			if (c < 7) {
				v = v ^ 1;
			}

		}

	}

	private static int process() {
		int min = Integer.MAX_VALUE;

		for (int i = 0; i <= N - 8; i++) {
			for (int j = 0; j <= M-8; j++) {
				//i,j왼쪽 상단 모서리로 해서  8*8 처리
				int cntB=0,cntW=0;
				for (int r = 0; r < i+8; r++) {
					for (int c = 0; c < j+8; c++) {
						//매 칸마다 chessW,chessB와 색이 몇개가 다른지 체크
						if(board[r][c] != chessW[r][c]) cntW++;
						if(board[r][c] != chessB[r][c]) cntB++;
					}
				}
//				int cnt = cntW<cntB?cntW:cntB;
				int cnt = Math.min(cntW,cntB);
				if(min<cnt) min = cnt;
			}
		}
		return min;
	}

}
