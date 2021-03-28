package algorithm_2103;

import java.util.Scanner;
import java.util.Stack;

public class 괄호_백준9012 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Character> st = new Stack<Character>();

		for (int i = 0; i < T; i++) {
			
			String str = sc.next();
			st = new Stack<Character>();
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == '(') {
					st.add('(');
				} else if (str.charAt(j) == ')') {
					if (!st.isEmpty() && st.peek() == '(') {
						st.pop();
					} else {
						st.add(')');
					}
				}
			}
			if (st.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");

			}

		}
	}
}
