package algorithm_2103;
import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기_백준10799 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		Stack<Character> st = new Stack<Character>();

		int cnt = 0;

		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (c == '(') {
				st.push(c);
			} else if (c == ')' && str.charAt(i - 1) == '(') {
				st.pop();
				cnt += st.size();

			} else {
				cnt++;
				st.pop();
			}
		}
		System.out.println(cnt);
	}
}
