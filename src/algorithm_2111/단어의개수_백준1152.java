package algorithm_2111;

import java.util.Scanner;

public class 단어의개수_백준1152 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.nextLine();
		int cnt = 1;

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == ' ') {
				cnt++;
			}
		}
		if (cnt == 0 || str.equals(" ")) {
			System.out.println(0);
		} else {
			System.out.println(cnt);
		}
	}
}
