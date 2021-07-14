package algorithm_2107;

import java.util.ArrayList;

public class 프린터_Pro {
	public static void main(String[] args) {
		int[] priorities = {1, 1, 3, 2, 1, 4, 1, 1, 3, 1, 1, 1};
		int location = 8;
		int answer = 0;

		int loca = location;
		boolean chk = false;
		
		ArrayList<Integer> qu = new ArrayList<Integer>();
		for (int i = 0; i < priorities.length; i++) {
			int cnt = 0;
			for (int j = i + 1; j < priorities.length; j++) {
				if (priorities[i] < priorities[j]) {
					cnt++;
				}
			}
			if (cnt != 0) {
				qu.add(priorities[i]);
				if (i == location) {
					loca = qu.size() - 1;
				}

			} else {
				if (i == location) {
					answer++;
					chk = true;
					break;
				} else {
					answer++;
				}
			}

		}
		if (!chk) {
			for (int i = 0; i <= loca; i++) {
				answer++;
			}
		}
		System.out.println(answer);
	}
}
