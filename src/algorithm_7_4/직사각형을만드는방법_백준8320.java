package algorithm_7_4;

import java.util.Scanner;

public class 직사각형을만드는방법_백준8320 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();//개수
		int count=0;
		for (int i = 1; i <= N; i++) {
			for (int j = i; j*i <= N; j++) {
				count++;
			}
		}
		System.out.println(count);
	}

}
