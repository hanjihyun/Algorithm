package algorithm_2104;
public class 영어끝말잇기_프로그래머스 {
	public static void main(String[] args) {
		int n = 2;
		String[] words = { "land", "dream", "mom", "mom", "ror"};

		int[] ans = solution(n, words);

		System.out.println(ans[0]);
		System.out.println(ans[1]);

	}

	public static int[] solution(int n, String[] words) {
		int[] answer = new int[2];
		answer[0] = 0;
		answer[1] = 0;
		out:for (int i = 1; i < words.length; i++) {

			char last = words[i - 1].charAt(words[i - 1].length() - 1);
			char first = words[i].charAt(0);
			if (last != first) {
				answer[0] = (i % n) + 1;
				answer[1] = (i / n) + 1;
				break;
			}
			for (int j = 0; j < i; j++) {
				String str = words[i];
				if (words[j].equals(str)) {
					answer[0] = (i % n) + 1;
					answer[1] = (i / n) + 1;
					 break out;
				}
			}
			
		}
		return answer;
	}
}
