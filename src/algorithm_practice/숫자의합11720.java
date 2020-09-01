package algorithm_practice;

import java.util.Scanner;

public class 숫자의합11720 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		int[] arr = new int[count];
		String str = sc.next();
		for (int i = 0; i < count; i++) {	
			arr[i] = str.charAt(i)-'0';
		}
		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum+=arr[i];
		}
		System.out.println(sum);
	}
}
