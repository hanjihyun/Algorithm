package algorithm_2108;

import java.util.Scanner;

public class 번데기_백준15721 {
	static int A, T, what;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		A = sc.nextInt();
		T = sc.nextInt();
		what = sc.nextInt();

		int Ans = sol();
		System.out.println(Ans);
	}

	private static int sol() {
		int bbun = 0;
		int degi = 0;
		int num = 2; // 1회차에 두번 반복

		while (true) {
			for (int i = 0; i < 4; i++) {
				if (i % 2 == 0)
					bbun++;
				else
					degi++;
				if (bbun == T && what == 0)
					return (bbun + degi - 1) % A;
				if (degi == T && what == 1)
					return (bbun + degi - 1) % A;
			}

			for (int i = 0; i < num; i++) {
				bbun++;
				if (bbun == T && what == 0)
					return (bbun + degi - 1) % A;
			}
			for (int i = 0; i < num; i++) {
				degi++;
				if (degi == T && what == 1)
					return (bbun + degi - 1) % A;
			}
			num++;
		}
	}
}
