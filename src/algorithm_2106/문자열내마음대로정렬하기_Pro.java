package algorithm_2106;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 문자열내마음대로정렬하기_Pro {
	public static void main(String[] args) {
		String[] strings = {"aooc", "coob", "cooa"};
		int n = 1;
		String[] answer = new String[strings.length];

//		Arrays.sort(strings);
//
//		for (int i = 0; i < strings.length; i++) {
//			for (int h = i; h < strings.length; h++) {
//				if (strings[i].charAt(n) > strings[h].charAt(n) && i != h) {
//					String temp = strings[i];
//					strings[i] = strings[h];
//					strings[h] = temp;
//				} else if (strings[i].charAt(n) == strings[h].charAt(n) && i != h) {
//					int size = 0;
//					if (strings[i].length() < strings[h].length()) {
//						size = strings[i].length();
//					} else {
//						size = strings[h].length();
//					}
//					for (int k = n + 1; k < size; k++) {
//
//						if (strings[i].charAt(k) > strings[h].charAt(k)) {
//							String temp = strings[i];
//							strings[i] = strings[h];
//							strings[h] = temp;
//						
//						}
//					}
//
//				}
//			}
//
//		}
//
//		for (int i = 0; i < strings.length; i++) {
//			answer[i] = strings[i];
//		}
		ArrayList<String> list = new ArrayList<String>();
		
		for (int i = 0; i < strings.length; i++) {
			list.add(strings[i].charAt(n) + strings[i]);
		}
		Collections.sort(list);
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i).substring(1);
		}
		for (int i = 0; i < strings.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
