package algorithm_10_1;

import java.util.Scanner;

public class 크리보드_백준11058 {
	static int N;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[N];
	
		System.out.println(dp(N));
	}
	private static int dp(int x) {
		if(x==0) return 0;
		if(x==1) return 1;
		if(x==2) return 2;
		if(x==3) return 3;
		
		if(d[x] != 0) return d[x];
		
		for (int i = 0; i < N; i++) {
			
		}
		return 0;
	}

}
