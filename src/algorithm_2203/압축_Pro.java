package algorithm_2203;

import java.util.ArrayList;
import java.util.HashMap;

public class 압축_Pro {
	public static void main(String[] args) {
		
		String msg = "KAKAO";
		
		ArrayList<Integer> com = new ArrayList<>();
		HashMap<String, Integer> dic = new HashMap<>();

		initDic(dic);

		int dicIdx = 27;
		boolean isEnd = false;

		for (int idx = 0; idx < msg.length(); ++idx) {
			String word = msg.charAt(idx) + "";

			while (dic.containsKey(word)) {
				idx++;
				if (idx == msg.length()) {
					isEnd = true;
					break;
				}
				word += msg.charAt(idx);
			}

			if (isEnd) {
				com.add(dic.get(word));
				break;
			}

			com.add(dic.get(word.substring(0, word.length() - 1)));
			dic.put(word, dicIdx++);

			idx--;
		}

		int[] answer = new int[com.size()];
		for (int i = 0; i < answer.length; ++i) {
			answer[i] = com.get(i);
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

	private static void initDic(HashMap<String, Integer> dic) {
		char ch = 'A';

		for (int i = 1; i < 27; ++i) {
			dic.put(ch + "", i);
			ch += 1;
		}

	}
}
