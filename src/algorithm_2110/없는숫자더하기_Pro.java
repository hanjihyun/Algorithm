package algorithm_2110;

public class 없는숫자더하기_Pro {
	public static void main(String[] args) {
		int[] numbers = { 1, 2, 3, 4, 6, 7, 8, 0 };
		int answer = 0;
		int[] chk = new int[10];
		for (int i = 0; i < numbers.length; i++) {
			chk[numbers[i]] = 1;
		}
		
		for (int i = 0; i < chk.length; i++) {
			if(chk[i] != 1) {
				answer+=i;
			}
		}
		System.out.println(answer);
	}
}
