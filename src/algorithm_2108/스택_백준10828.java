package algorithm_2108;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 스택_백준10828 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cnt = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < cnt; i++) {
			String s = br.readLine();
			if(s.contains("push")) {
				String spt[] = s.split(" ");
				stack.push(Integer.parseInt(spt[1]));
			}else if(s.contains("pop")) {
				 System.out.println(stack.isEmpty()?-1:stack.pop());
			}else if(s.contains("size")) {
				System.out.println(stack.size());
			}else if(s.contains("empty")) {
				 System.out.println(stack.isEmpty()?1:0);
			}else if(s.contains("top")) {
				System.out.println(stack.isEmpty()?-1:stack.peek());
			}
		}
		
	}
}
