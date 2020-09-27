package algorithm_9_4;

import java.util.Scanner;

public class 타일채우기_백준2133 {
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
		if(x == 0)return 1;
		if(x == 1)return 0;
		if(x == 2)return 3;
		if(d[x] != 0) return d[x];
		int result = 3 * dp(x-2);
		for (int i = 3; i <= x; i++) {
			if(i%2==0) {
				result += 2 * dp(x-i);
			}
		}
		return d[x] = result;
	}
}
