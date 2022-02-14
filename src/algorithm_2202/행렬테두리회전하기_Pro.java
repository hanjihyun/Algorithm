package algorithm_2202;

public class 행렬테두리회전하기_Pro {
	public static void main(String[] args) {
		int rows = 6;
		int columns = 6;
		int[][] queries = { { 2, 2, 5, 4 }, { 3, 3, 6, 6 }, { 5, 1, 6, 3 } };
		int[] answer = new int[queries.length];

		int emp = 1;

		int[][] map = new int[rows + 1][columns + 1];
		for (int i = 1; i <= rows; i++) {
			for (int j = 1; j <= columns; j++) {
				map[i][j] = emp;
				emp++;
			}
		}

		for (int i = 0; i < queries.length; i++) {
			int r1 = queries[i][0];
			int c1 = queries[i][1];
			int r2 = queries[i][2];
			int c2 = queries[i][3];
			emp = map[r1][c1];
			int min = emp;

			for (int r = r1 + 1; r <= r2; r++) {
				min = Math.min(min, map[r][c1]);
				map[r - 1][c1] = map[r][c1];
			}
			for (int c = c1 + 1; c <= c2; c++) {
				min = Math.min(min, map[r2][c]);
				map[r2][c - 1] = map[r2][c];
			}
			for (int r = r2 - 1; r >= r1; r--) {
				min = Math.min(min, map[r][c2]);
				map[r + 1][c2] = map[r][c2];
			}
			for (int c = c2 - 1; c > c1; c--) {
				min = Math.min(min, map[r1][c]);
				map[r1][c + 1] = map[r1][c];
			}
			map[r1][c1 + 1] = emp;
			answer[i] = min;

		}
		
		  for(int h=0; h<answer.length; h++){
             
              System.out.println(answer[h]);
          }
	}

}
