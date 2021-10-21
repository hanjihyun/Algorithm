package algorithm_2110;

import java.util.Arrays;

public class 예산_Pro {
	public static void main(String[] args) {
		int[] d = { 2,2,3,3 };
		int budget = 10;
		int answer = 0;

		Arrays.sort(d);

		int sum=0;
		for (int i = 0; i < d.length; i++) {
			sum+=d[i];
			if(sum>budget) {
				answer=i;
				break;
			}
		}
		if(sum <= budget) {
			answer = d.length;
		}
		System.out.println(answer);
	}
}
