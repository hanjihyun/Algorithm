package algorithm_2110;

import java.util.Stack;

public class 크레인인형뽑기게임_Pro {
	static int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
			{ 3, 5, 1, 3, 1 } };
	static int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
	static int answer = 0;
	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		for (int i = 0; i < moves.length; i++) {
			for (int j = 0; j < board.length; j++) {

				int num = board[j][moves[i] - 1];

				if (num != 0) {

					if (!stack.isEmpty()) {
						if (stack.peek() == num) {
							stack.pop();

							answer += 2;

						} else {
							stack.add(num);
						}
					} else {

						stack.add(num);

					}
					board[j][moves[i] - 1] = 0;
					break;
				}

			}
		}
		System.out.println(answer);
	}
}
