package algorithm_2112;

public class 예상대진표_Pro {
	public static void main(String[] args) {
		int n = 8;
		int a = 4;
		int b = 7;
		int answer = 0;

		while(a!=b) {
			a=(a+1)/2;
			b=(b+1)/2;
			answer++;
		}
		System.out.println(answer);
	}
}
