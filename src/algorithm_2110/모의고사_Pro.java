package algorithm_2110;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_Pro {
	public static void main(String[] args) {
		int[] answers = { 1,2,3,4,5 };
		
		List<Integer> list = new ArrayList<Integer>();
		int n = answers.length;
		// System.out.println(n);

		int[] num1 = { 1, 2, 3, 4, 5 };
		int[] num2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] num3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
		int cnt1 = 0, cnt2 = 0, cnt3 = 0;

		for (int i = 0; i < answers.length; i++) {
			if (num1[i % num1.length] == answers[i]) {
				cnt1++;
			}
			if (num2[i % num2.length] == answers[i]) {
				cnt2++;
			}
			if (num3[i % num3.length] == answers[i]) {
				cnt3++;
			}
		}
//		System.out.println(cnt1 + " " + cnt2 + " " + cnt3);
		int max = cnt1;
		list.add(1);
		if (max < cnt2) {
			list.clear();
			list.add(2);
			max = cnt2;
		} else if (max == cnt2) {
			list.add(2);
		}
		if (max < cnt3) {
			list.clear();
			list.add(3);
			max = cnt3;
		} else if (max == cnt3) {
			list.add(3);
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	
	}
}
