package algorithm_2202;

import java.util.ArrayList;
import java.util.List;

public class 뉴스클러스터링_Pro {
	public static void main(String[] args) {
		String str1 = "aa1+aa2";
		String str2 = "AAAA12";
		int answer = 0;

		str1 = str1.toLowerCase();
		str2 = str2.toLowerCase();

		List<String> arr1 = new ArrayList();
		List<String> arr2 = new ArrayList();
		List<String> inter = new ArrayList();
		List<String> comb = new ArrayList();

		for (int i = 0; i < str1.length() - 1; i++) {
			char first = str1.charAt(i);
			char second = str1.charAt(i + 1);
			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				arr1.add(first + "" + second);
			}
		}

		for (int i = 0; i < str2.length() - 1; i++) {
			char first = str2.charAt(i);
			char second = str2.charAt(i + 1);
			if (first >= 'a' && first <= 'z' && second >= 'a' && second <= 'z') {
				arr2.add(first + "" + second);
			}
		}

		for (String s : arr1) {
			if (arr2.remove(s)) {
				inter.add(s);
			}
			comb.add(s);
		}

		comb.addAll(arr2);

		double gong_len = inter.size();
		double hab_len = comb.size();
		if (hab_len == 0) {
			answer = 65536;
		}
		answer = (int) (gong_len / hab_len * 65536);
		System.out.println(answer);
	}
}
