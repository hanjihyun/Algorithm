package algorithm_2106;

public class 소수찾기_Pro {
	public static void main(String[] args) {
		int n = 10;
		int answer = 0;
		for (int i = 2; i <= n; i++) {
			boolean flag = true;
			for (int j = 2; j <=Math.sqrt(i); j++) { 
				if (i % j == 0) {
					flag = false;
					break;
				}
			} if(flag==true) answer++;
		}
		System.out.println(answer);
	}
}
