package algorithm_2106;

public class 콜라츠추측_Pro {
	public static void main(String[] args) {
		int num = 626331;
		int answer = 0;
		
		long n = (long)num;
		
		while (n != 1) {
			if (n % 2 == 0) {
				n = n / 2;
			} else {
				n = n * 3 + 1;
			}
			answer++;
//			System.out.println(n);

			if (answer > 500) {
				answer = -1;
				break;
//				return -1;
			}
		}
		
		System.out.println(answer);
		
	}
}
