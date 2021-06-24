package algorithm_2106;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 정수내림차순으로배치하기_Pro {

	public static void main(String[] args) {
		long n = 118372;
		long answer = 0;
		long temp = n;
		List<Integer> list = new ArrayList<Integer>();
		
		while(temp > 0) {
			list.add((int)(temp%10));
			temp = temp/10;
			
		}
		Collections.sort(list);
		String str = "";

		for (int i = list.size()-1; i >= 0; i--) {

			str += list.get(i);
		}
		answer = Long.parseLong(str);
		System.out.println(answer);
	}

}
