package algorithm_2110;

import java.util.HashSet;
import java.util.Set;

public class 소수찾기_Pro {
	static int[] arr;
	static boolean[] v;
	static int answer;
	static Set<Integer> set = new HashSet<>();

	public static void main(String[] args) {
		String numbers = "17";
		answer = 0;
		int n = numbers.length();
		arr = new int[n];
		v = new boolean[n + 1];

		for (int i = 0; i < n; i++) {
			arr[i] = numbers.charAt(i) - '0';
		}

		for (int i = 0; i < n; i++) {
			perm("", i + 1, 0);
		}

		System.out.println(set.size());

	}

	public static boolean isPrime(int n) {
		if (n == 1 || n == 0) {
			return false;
		}
		if (n == 2 || n == 3) {
			return true;
		}
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	private static void perm(String str, int r, int k) {
		if (k == r) {

			int Ans = Integer.parseInt(str);
//			System.out.println(Ans);
			if (isPrime(Ans)) {
				set.add(Ans);
			}

			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (!v[i]) {
				v[i] = true;
				str = str + arr[i];
				perm(str, r, k + 1);
				str = str.substring(0, str.length() - 1);
				v[i] = false;
			}
		}
	}
}