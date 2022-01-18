package algorithm_2201;

import java.util.ArrayList;
import java.util.List;

public class 괄호회전하기_Pro {

	static List<Character> open = new ArrayList();

	public static void main(String[] args) {
		String s = "([{)}]";
		int answer = 0;

		List<Character> str = new ArrayList<Character>();
		int[] turn = new int[s.length()];

		int cnt = 0;
		if (s.length() % 2 != 0) {
			System.out.println(answer);
			return;
		}
		for (int i = 0; i < s.length(); i++) {
			str.add(s.charAt(i));
		}

		while (cnt < str.size()) {
			boolean fall = true;
			open = new ArrayList();
			for (int i = 0; i < str.size(); i++) {
				if (str.get(i) == '[' || str.get(i) == '(' || str.get(i) == '{') {
					open.add(str.get(i));
				} else {
					char ch = ' ';
					if (str.get(i) == ']') {
						ch = '[';
					} else if (str.get(i) == ')') {
						ch = '(';
					} else if (str.get(i) == '}') {
						ch = '{';
					}
					if (!check(ch)) {
						str.add(str.remove(0));
						fall = false;
						break;
					}
				}
			}
			if (fall == true) {
				turn[cnt] = 1;
				str.add(str.remove(0));
			}
			cnt++;
		}
		for (int i = 0; i < turn.length; i++) {
			if (turn[i] == 1) {
				answer++;
			}
		}
		System.out.println(answer);
	}

	private static boolean check(char ch) {
		if (open.size() != 0) {

			if (open.get(open.size()-1) == ch) {
				open.remove(open.size()-1);
				return true;

			}
		}
		return false;
	}
}
