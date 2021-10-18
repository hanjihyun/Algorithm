package algorithm_2110;

import java.util.Scanner;

public class 분해합_백준2231 {
	static int N, Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		Ans = 0;
		for (int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			while(num != 0) {
				sum += num %10;
				num = num / 10;
			}
			System.out.println(num + ":"+sum+":"+i);
			if(sum + i == N) {
				Ans = i;
				break;
			}
		}
		
		System.out.println(Ans);
	}
}
