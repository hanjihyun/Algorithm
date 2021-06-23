package algorithm_2106;

import java.util.ArrayList;
import java.util.Arrays;
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
//		for (int i = list.size()-1; i >= 0; i--) {
//			System.out.println(list.get(i));
//		}
		for (int i = list.size()-1; i >= 0; i--) {
//			int ten = 1;
//			for (int j = 0; j < i; j++) {
//				ten *= 10;
//				if(i==0)ten=1;
//			}
//		
//			System.out.println(answer + "An");
//			System.out.println(ten + "ten");
//			answer += (ten * list.get(i));
			
			str += list.get(i);
		}
		answer = Long.parseLong(str);
		System.out.println(answer);
	}

}
