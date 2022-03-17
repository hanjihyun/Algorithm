package algorithm_2203;

public class 쿼드압축후개수세기_Pro {
	static int[] answer;
	public static void main(String[] args) {
		int[][] arr = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };
	
		answer =new int[2];
		quad(arr.length, 0, 0, arr);
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void quad(int length, int y, int x, int[][] arr) {
		if(length == 1) {
			answer[arr[y][x]]++;
			return;
		}
		
		if(block(length, y, x, arr)) return;
		
		quad(length/2, y, x, arr);
		quad(length/2, y + length/2, x, arr);
		quad(length/2, y, x + length/2, arr);
		quad(length/2, y + length/2, x + length/2, arr);
		
	}

	private static boolean block(int length, int y, int x, int[][] arr) {
		for (int i = y; i < y + length; i++) {
			for (int j = x; j < x + length; j++) {
				if(arr[y][x] != arr[i][j]) return false;
			}
		}
		
		answer[arr[y][x]]++;
		return true;
	}
}
