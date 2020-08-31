package algorithm_practice;

import java.util.Scanner;

public class 분할정복 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		System.out.println(exp(x,y));
	}

	private static int exp(int x, int y) {
		if(y == 1) return x;
		
		int result = exp(x,y/2);
		result *= result;
		
		if(y%2 != 0) {
			result *= x;
		}
		
		return result;
	}
}
