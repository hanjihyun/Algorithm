package algorithm_2108;

public class 부족한금액계산하기_Pro {
	public static void main(String[] args) {
		int price = 2500;
		int money = 500000;
		int count = 2500;
		long answer = 0;

		long total = 0;
		for (int i = 1; i <= count; i++) {
			total += i * price;

			System.out.println(i + "==" + total);
		}
		answer = total - money;
		
		if (answer <= 0) {
			answer = 0;
		} 
		System.out.println(answer);
	}
}
