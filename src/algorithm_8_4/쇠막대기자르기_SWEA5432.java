package algorithm_8_4;

import java.util.Scanner;
import java.util.Stack;

public class 쇠막대기자르기_SWEA5432 {

	static Stack<Character> s = new Stack();
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			cnt = 0;
			String str = sc.next();
			str = str.replace("()", "0");
			int laser = 0;

			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '(') { 
					//(이면 stack에 push
					s.push(str.charAt(i));
				}else if(str.charAt(i) == ')') {
					//)이면 막대기 하나
					cnt++;
					s.pop();
				}else {
					//'0'이면 stack사이즈 만큼 +
					cnt+=s.size();
					//'('는 막대기 시작 점으로 
					// ')'를 만나기 이전에 레이저가 있으면 
					//stack에 쌓여있는 막대기에 모드 영향을 미치므로 stack.size()만큼 더해줘!!!
				}
			}
			System.out.println("#" + test_case + " " +cnt);
		}
	}
}