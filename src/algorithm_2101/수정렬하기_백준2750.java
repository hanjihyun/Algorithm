package algorithm_2101;

import java.util.Arrays;
import java.util.Scanner;

public class 수정렬하기_백준2750 {
	static int[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}
}
