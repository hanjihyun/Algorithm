package algorithm_2111;

import java.util.Scanner;

public class 알파벳찾기_백준10809 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] procedure = new int[26];
		String str = sc.next();
		int cnt = 0;

		for (int j = 0; j < procedure.length; j++) {
			procedure[j] = -1;
		}
		for (int j = 0; j < str.length(); j++) {
			if (procedure[(str.charAt(j)) - 97] == -1) {
				procedure[(str.charAt(j)) - 97] = cnt;
			}
			cnt++;
		}
		for (int i = 0; i < procedure.length; i++) {
			System.out.print(procedure[i]+" ");
		}
	}
}
