package algorithm_2108;

import java.util.Scanner;

public class A와B2_백준12919 {
	static String S, T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		S = sc.nextLine();
		T = sc.nextLine();

		System.out.println(dfs(S, T));

	}

	private static int dfs(String s, String t) {
		if (s.length() == t.length()) {
			if (s.equals(t)) {
				return 1;
			}
			return 0;
		}
		int Ans = 0;
		if (t.charAt(t.length() - 1) == 'A') {
			Ans += dfs(s, t.substring(0, t.length() - 1));
		}
		if(t.charAt(0) == 'B') {
			String temp = new StringBuffer(t.substring(1,t.length())).reverse().toString();
			Ans += dfs(s, temp);
		}
		return Ans > 0 ? 1 : 0;
	}

}
