package algorithm_2110;

import java.util.Scanner;

public class 한수_백준1065 {
static int N, Ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		if(N < 100) {
			System.out.println(N);
		}else {
			int res = 99;
			
			for (int i = 100; i <= N; i++) {
				res += chk(i);
			}
			if(N == 1000) {res--;}
			System.out.println(res);
		}
	
	}

	private static int chk(int i) {
		int a = i / 100 % 10;
		int b = i / 10 %10;
		int c = i % 10;
//		System.out.println(a+":"+b+":"+c);
		if(b * 2 == a+c) {
			return 1;
		}
		return 0;
	}
}
