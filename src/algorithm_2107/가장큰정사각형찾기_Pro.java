package algorithm_2107;

public class 가장큰정사각형찾기_Pro {
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };
	
		int[][] DP = new int[2][board[0].length];
		int answer = 0;
		int ans = 0;

		for (int i = 0; i < board[0].length; i++) {
			DP[0][i] = board[0][i];
			if (DP[0][i] > ans)
				ans = DP[0][i];
		}

		for (int i = 1; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {

				if (board[i][j] == 0)
					DP[1][j] = 0;
				else {
					if (j == 0)
						DP[1][j] = 1;
					else {
						DP[1][j] = 1;
						if (DP[1][j - 1] == 0 | DP[0][j] == 0 | DP[0][j - 1] == 0) // 셋 중에 하나라도 0이면
							DP[1][j] = 1;
						else if (DP[1][j - 1] == DP[0][j] && DP[0][j] == DP[0][j - 1]) // 셋 다 같으면
							DP[1][j] = DP[0][j] + 1;
						else { // 셋 다 다르면
							if (DP[1][j - 1] <= DP[0][j - 1] && DP[1][j - 1] <= DP[0][j])
								DP[1][j] = DP[1][j - 1] + 1;
							else if (DP[0][j - 1] <= DP[1][j - 1] && DP[0][j - 1] <= DP[0][j])
								DP[1][j] = DP[0][j - 1] + 1;
							else if (DP[0][j] <= DP[0][j - 1] && DP[0][j] <= DP[1][j - 1])
								DP[1][j] = DP[0][j] + 1;
						}
					}
				}

				if (DP[1][j] > ans)
					ans = DP[1][j];
			}

			for (int j = 0; j < board[0].length; j++) {
				DP[0][j] = DP[1][j];
			}

		}
		answer = ans * ans;
		System.out.println(answer);
	}
}
