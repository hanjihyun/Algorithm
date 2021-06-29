package algorithm_2106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 문자열내림차순으로배치하기_Pro {
	public static void main(String[] args) {
		String s = "ZbcdeAfg";
		String answer = "";
		List<Character> list = new ArrayList<Character>();
		
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}
		Collections.sort(list);
		for (int i = s.length()-1; i >=0; i--) {
			answer += list.get(i);
		}
		System.out.println(answer);
	}
}
