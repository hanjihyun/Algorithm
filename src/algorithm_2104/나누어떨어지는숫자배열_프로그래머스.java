package algorithm_2104;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 나누어떨어지는숫자배열_프로그래머스 {
	public static void main(String[] args) {
		int[] arr = { 2, 36, 1, 3};
		int divisor = 1;

		int[] answer = solution(arr, divisor);

		for (int i = 0; i < answer.length; i++) {

			System.out.println(answer[i]);

		}

	}

	public static int[] solution(int[] arr, int divisor) {
		int[] answer = {};
		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (arr[i] % divisor == 0) {
				list.add(arr[i]);
			}
		}

		Collections.sort(list);
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {

			answer[i] = list.get(i);

		}
		if (list.size() == 0) {
			answer = new int[1];
			answer[0] = -1;

		}
		return answer;

	}
}
