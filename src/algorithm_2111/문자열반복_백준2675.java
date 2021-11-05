package algorithm_2111;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 문자열반복_백준2675 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int i = 0; i < T; i++) {
			int R = sc.nextInt();
			String str = sc.next();
			List<String> list = new ArrayList<String>();
			for (int j = 0; j < str.length(); j++) {
				for (int k = 0; k < R; k++) {
					list.add(str.charAt(j) + "");
				}
			}
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
			}
			System.out.println();
		}

	}
}
