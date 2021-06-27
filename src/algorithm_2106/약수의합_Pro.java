package algorithm_2106;

public class 약수의합_Pro {
	public static void main(String[] args) {
		int n = 12;
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if(i*j==n) {
					answer += (i+j);
				}
			}
		}
		System.out.println(answer/2);
	}
}
