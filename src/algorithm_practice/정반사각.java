package algorithm_practice;

import java.util.Scanner;

public class 정반사각 {
	static int N = 90;
	static int D; //입사각
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		D = sc.nextInt();
		
		int result = ( 2 * (-D * N) / (N * N)) * N + D;
		
		System.out.println(result);
	}
}
