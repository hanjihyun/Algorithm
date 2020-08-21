package algorithm_8_1;

import java.util.Scanner;

public class 안경이없어_SWEA7272 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();
		/*
		 * 여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		 */

		for (int test_case = 1; test_case <= T; test_case++) {
			char[] zero = { 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W', 'X', 'Y',
					'Z' };
			char[] one = { 'A', 'D', 'O', 'P', 'Q', 'R' };
			char two = 'B';
//			int[] count1 = new int[3];
//			int[] count2 = new int[3];

			String str1 = sc.next();
			char[] first = new char[str1.length()];
			String str2 = sc.next();
			char[] second = new char[str2.length()];

			for (int i = 0; i < str1.length(); i++) {
				first[i] = str1.charAt(i);
			}
			for (int i = 0; i < str2.length(); i++) {
				second[i] = str2.charAt(i);
			}

			String Ans = "";
			int compare1 = 0;
			int compare2 = 0;
			if (first.length != second.length) {
				Ans = "DIFF";
			} else {
				for (int k = 0; k < first.length; k++) {

					for (int i = 0; i < zero.length; i++) {
						if (first[k] == zero[i]) {
							compare1 = 1;
							break;
						} else if (i<one.length&&first[k] == one[i]) {
							compare1 = 2;
							break;
						} else if (first[k] == two) {
							compare1 = 3;
							break;
						}
					}
					for (int j = 0; j < zero.length; j++) {
						if (second[k] == zero[j]) {
							compare2 = 1;
							break;
						} else if (j<one.length&&second[k] == one[j] ) {
							compare2 = 2;
							break;
						} else if (second[k] == two) {
							compare2 = 3;
							break;
						}

					}
					if (compare1 != compare2) {
						Ans = "DIFF";
						break;
					}else {
						Ans = "SAME";
					}
				}
				
			}
			

			System.out.println("#" + test_case + " " + Ans);

		}
	}
}
