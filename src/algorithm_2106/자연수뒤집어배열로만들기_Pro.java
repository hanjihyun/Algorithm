package algorithm_2106;

import java.util.ArrayList;
import java.util.List;

public class 자연수뒤집어배열로만들기_Pro {

	public static void main(String[] args) {
		long n = 12345;
		List<Integer> list = new ArrayList<Integer>();
		long temp =  n;
		while(temp>0) {
			list.add((int)(temp % 10));
			temp = temp/10;
		}
		 int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	       

	}

}
