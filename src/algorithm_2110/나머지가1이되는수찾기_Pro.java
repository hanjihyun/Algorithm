package algorithm_2110;

public class 나머지가1이되는수찾기_Pro {
	public static void main(String[] args) {
		int n = 10;
		int answer = 0;
		boolean chk = true;
		int min = 2;
		while (chk) {
			if (n % min == 1) {
				answer = min;
				break;
			}
			min++;
		}
		System.out.println(answer);
	}
}
