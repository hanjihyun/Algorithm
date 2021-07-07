package algorithm_2107;

import java.util.Stack;

public class 올바른괄호_Pro {
	public static void main(String[] args) {
		String s = "(())()";
		boolean answer = true;
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if(s.charAt(i)=='(') {
				stack.add(s.charAt(i));
			}else {
				if(stack.isEmpty()) {
					answer = false;
					break;
				}else {
					stack.pop();
				}
			}
		}
		if(!stack.isEmpty()) {
			answer = false;
		}
		System.out.println(answer);
	}
}
