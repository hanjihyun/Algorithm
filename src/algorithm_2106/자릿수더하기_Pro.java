package algorithm_2106;

public class 자릿수더하기_Pro {
	public static void main(String[] args) {
		int n = 123;
		int answer = 0;
		int temp = n;
		while (temp > 0) {
			answer += temp%10;
			temp = temp/10;
		}
		System.out.println(answer);

	}
}
