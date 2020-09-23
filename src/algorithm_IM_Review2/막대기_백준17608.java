package algorithm_IM_Review2;

import java.util.Scanner;
import java.util.Stack;

public class 막대기_백준17608 {
	static int N;
	static Stack<Integer> stick = new Stack<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int height = sc.nextInt();
			while(!stick.isEmpty() && stick.peek() <= height) stick.pop();
			stick.push(height);
		}
		System.out.println(stick.size());
	}
}
