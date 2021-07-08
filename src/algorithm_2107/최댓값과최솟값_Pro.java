package algorithm_2107;

import java.util.ArrayList;

public class 최댓값과최솟값_Pro {
	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		ArrayList<Integer> list = new ArrayList<Integer>();
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == ' ') {
				list.add(Integer.parseInt(str));
				str = "";
			} else {
				str += s.charAt(i);
//				System.out.println(str);
			} 
		}
		list.add(Integer.parseInt(str));
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i)<min) {
				min = list.get(i);
			}
			if(list.get(i)>max) {
				max = list.get(i);
			}
//			System.out.println(list.get(i));
		}
		String answer = min + " " + max;
		System.out.println(answer);
	}
}
