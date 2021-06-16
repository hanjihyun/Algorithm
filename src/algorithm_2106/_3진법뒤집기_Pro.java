package algorithm_2106;

import java.util.ArrayList;
import java.util.List;

public class _3진법뒤집기_Pro {
	public static void main(String[] args) {
		int n = 45;
		int answer = 0;
		List<Integer> list = new ArrayList<Integer>();
		
		int temp = n;
		while(n>0) {
			temp = n/3;
			list.add(n%3);
			n = temp;
		}
		int num = list.size()-1;
		
		for (int i = 0; i < list.size(); i++) {
			answer += list.get(i) * Math.pow(3, num) ;
			num--;
//			System.out.println(list.get(i));
		}
		
		System.out.println(answer);
	}
}
