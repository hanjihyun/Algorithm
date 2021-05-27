package algorithm_2105;

import java.util.ArrayList;
import java.util.List;

public class 제일작은수제거하기_Pro {
	public static void main(String[] args) {
		int[] arr = { 10 };
		List<Integer> list = new ArrayList();

		int[] answer = {};

		int min = arr[0];
		if (arr.length > 1) {
			for (int i = 1; i < arr.length; i++) {
				if (min > arr[i]) {
					min = arr[i];
				}
			}
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != min) {
					list.add(arr[i]);
				}
			}
		} else {
			list.add(-1);
		}
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(answer[i]);
		}
	}
}
