package algorithm_9_4;

import java.util.Scanner;

public class twoxn타일링_백준11727 {
	static int N;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[1001];
		
		System.out.println(dp(N));
	}
	private static int dp(int x) {
		// TODO Auto-generated method stub
		if(x == 1)return 1;
		if(x == 2)return 3;
		if(d[x] != 0) return d[x];
		
		return d[x] = (dp(x-1)+ 2*dp(x-2)) % 10007;
	}
}
