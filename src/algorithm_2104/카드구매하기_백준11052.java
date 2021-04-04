package algorithm_2104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 카드구매하기_백준11052 {
	static int N, Ans;
	static List<Price> card;

	static class Price  {
		int num, pri;
		protected Price(int num, int pri) {
			super();
			this.num = num;
			this.pri = pri;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		card = new ArrayList<Price>();
		for (int i = 0; i < N; i++) {
			card.add(new Price(i + 1, sc.nextInt()));
		}

		Ans = 0;
		int count = 0;

		System.out.println(Ans);
	}

}
