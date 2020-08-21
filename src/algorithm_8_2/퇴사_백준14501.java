package algorithm_8_2;

import java.util.Scanner;

public class 퇴사_백준14501 {
	static int N,max;
	static int[] time;
	static int[] money;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		max=0;
		time = new int[N];
		money = new int[N];

		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
			money[i] = sc.nextInt();
		}
		
		combination(0,0);
		System.out.println(max);
	}
	private static void combination(int idx,int totalPrice) {

		if(idx >= N) {
			if(max < totalPrice) {
				max = totalPrice;
			}
			return;
		}

		
		if(idx + time[idx] <= N) {
			combination(idx+time[idx], totalPrice+money[idx]);
		}
		if(idx + 1 <= N) {
			combination(idx+1, totalPrice);
		}
		
	}

}
