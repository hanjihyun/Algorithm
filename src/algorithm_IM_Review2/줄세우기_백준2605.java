package algorithm_IM_Review2;

import java.util.Scanner;
import java.util.Stack;

public class 줄세우기_백준2605 {
	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	static int N, ticket;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		ticket = 0;
		for (int i = 1; i <= N; i++) {
			ticket = sc.nextInt();

			if (ticket == 0) {
				stack1.push(i);
			} else {
				for (int j = 0; j < ticket; j++) {
					if (!stack1.isEmpty()) {
						stack2.push(stack1.pop());
					}
				}
				stack1.push(i);
				while (!stack2.empty()) {
					stack1.push(stack2.pop());
				}
			}
		}

		int[] emp = new int[N];
		for (int j = 0; j < N; j++) {
			if (!stack1.isEmpty()) {
				emp[j] = stack1.pop();
			}
		}
		for (int i = N - 1; i >= 0; i--) {
			System.out.print(emp[i]);
			if (i != 0) {
				System.out.print(" ");
			}
		}
	}
}
