package algorithm_2110;

public class 숫자의표현_Pro {
	public static void main(String[] args) {
		int n = 15;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			int sum = 0;
			for (int j = i; j <= n; j++) {
				sum += j;
				if (sum == n) {
					answer++;
					break;
				} else if (sum > n)
					break;
			}
		}
		System.out.println(answer);
	}
}
