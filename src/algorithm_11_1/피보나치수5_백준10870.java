package algorithm_11_1;

import java.util.Scanner;

public class 피보나치수5_백준10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		System.out.println(fibo(N));
		
	}

	private static int fibo(int n) {
		if(n==0) return 0;
		else if(n==1) return 1;
		return fibo(n-1) + fibo(n-2);
	}

}
