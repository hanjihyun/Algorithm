package algorithm_2107;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class 두개뽑아서더하기_Pro {
	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		int[] answer = {};
		ArrayList<Integer> list = new ArrayList<Integer>();
		HashSet<Integer> hashSet = new HashSet<>();
		for (int i = 0; i < numbers.length; i++) {
			for (int j = i+1; j < numbers.length; j++) {
//				System.out.println(numbers[i]+numbers[j]);
				list.add(numbers[i]+numbers[j]);
			}
		}
		for(int data : list){
		    hashSet.add(data);
		}
	
		list = new ArrayList<>(hashSet);
		answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		Arrays.sort(answer);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(answer[i]);
		}
	}
}
