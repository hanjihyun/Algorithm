package algorithm_2104;
public class 같은숫자는싫어_프로그래머스 {
	public static void main(String[] args) {
		int[] arr = {4, 4, 4, 3, 3 };
		int[] ans = solution(arr);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	public static int[] solution(int[] arr) {
		int[] answer = {};
		int cnt = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] == arr[i + 1]) {
				arr[i] = -1;
				cnt++;
			}
		}
		answer = new int[arr.length - cnt];
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != -1) {
				answer[index] = arr[i];
				index++;
			}
		}
		return answer;
	}
}
