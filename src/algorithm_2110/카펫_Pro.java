package algorithm_2110;

public class 카펫_Pro {
	public static void main(String[] args) {
		int brown = 10;
		int yellow = 2;
		int[] answer = new int[2];
	
		for (int i = 1; i <= yellow; i++) {
			if (yellow % i == 0) {
				if (i * 2 + (2 * yellow /i) + 4 == brown) {
					answer[1] = yellow /i + 2;
					answer[0] = i + 2;
				}
			}
		}
		for (int i = 0; i < 2; i++) {
			System.out.println(answer[i]);
		}
	}
}
