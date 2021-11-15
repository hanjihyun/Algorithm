package algorithm_2111;

import java.util.Arrays;

public class HIndex_Pro {
	public static void main(String[] args) {
		int[] citations = { 3, 0, 6, 1, 5 };
		int answer = 0;
		
		Arrays.sort(citations);
		
		int h;
		for (int i = 0; i < citations.length; i++) {
			h = citations.length-i;
			
			if(citations[i]>=h) {
				answer = h;
				break;
			}
		}
		System.out.println(answer);
	}
}
