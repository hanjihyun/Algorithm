package algorithm_2107;

import java.util.Stack;

public class 짝지어제거하기_Pro {
	public static void main(String[] args) {
		String s = "dada";
		Stack<Character> stack = new Stack<Character>();
		int answer = 0;
		
		for (int i = 0; i < s.length(); i++) {
			
			if(stack.isEmpty()) {
			stack.add(s.charAt(i));
			}else {
				if(stack.peek() == s.charAt(i)) {
					stack.pop();
				}else {
					stack.add(s.charAt(i));
				}
			}
		}
		if(stack.isEmpty()) {
			answer = 1;
		}else {
			answer=0;
		}
		System.out.println(answer);
	}
}
