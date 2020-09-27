package algorithm_9_4;

import java.util.Scanner;

public class 타일채우기3_백준14852 {
	static int N;
	static long[][] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new long[1000001][2];
		
		System.out.println(dp(N));
	}
	private static long dp(int x) {
		// TODO Auto-generated method stub
		d[0][0] = 0;
		d[1][0] = 2;
		d[2][0] = 7;
		d[2][1] = 1;
	
		for (int i = 3; i <= x; i++) {
			
			d[i][1] = (d[i-1][1] + d[i-3][0]) % 1000000007;
			d[i][0] = (3 * d[i-2][0] + 2 * d[i-1][0] + 2* d[i][1])%1000000007;
			
		}
		return d[x][0];
	}
}
