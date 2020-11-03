package algorithm_11_1;

import java.util.Scanner;

public class 팩토리얼_백준10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
	
		System.out.println(factorial(N));
	}

	private static int factorial(int n) {
		int fac = 1;
		if(n>1) {
			fac = n * factorial(n-1);
		}
		return fac;
	}
}
