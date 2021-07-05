package algorithm_2107;

public class 행렬의곱셈_Pro {
	public static void main(String[] args) {
		int[][] arr1 = { { 1, 4 }, { 3, 2 }, { 4, 1 } };
		int[][] arr2 = { { 3, 3 }, { 3, 3 } };
	
		int[][] answer = new int[arr1.length][arr2[0].length];
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2[0].length; j++) {
				int calc = 0;
				for (int k = 0; k < arr1[0].length; k++) {
					calc += arr1[i][k] * arr2[k][j];
				}
				answer[i][j] = calc;
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			for (int j = 0; j < answer[0].length; j++) {
				System.out.println(answer[i][j]);
			}
		}
	}
}
