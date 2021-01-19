package algorithm_2101;

import java.util.Scanner;

public class 제로_백준10773 {
	static int[] arr;
	static int K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		K = sc.nextInt();
		arr = new int[K];
		
		for (int i = 0; i < K; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == 0 && i > 0) {
				int index = i;
				while(arr[index] == 0) {
					index = index-1;
				}
				arr[index] = 0;
			}
		}
//		for (int i = 0; i < K; i++) {
//			System.out.print(arr[i]);
//		}
//		
		int total = 0;
		
		for (int i = 0; i < K; i++) {
			total += arr[i];
		}
		
		System.out.println(total);
	}
}
