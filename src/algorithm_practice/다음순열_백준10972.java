package algorithm_practice;

import java.util.Arrays;
import java.util.Scanner;

public class 다음순열_백준10972 {
	static int N;
	static int[] input;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

//		Arrays.sort(input);
		
		if(nextPerm(input)) {
			for (int i = 0; i < N; i++) {
				System.out.print(input[i]+" ");
			}
		}else {
			System.out.println("-1");
		}
		
//		do {
//			for (int i = 0; i < N; i++) {
//				System.out.print(input[i]+" ");
//			}
//			System.out.println();
//			return;
//		}while(nextPerm(input));
		
	}
	private static boolean nextPerm(int[] numbers) {
		//1. 꼭대기 찾기
		int i = N-1; //맨뒤에서 부터 올라간다
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		if(i<=0) return false; //마지막 순열 다음 순열은 없다.
		
		//2. i-1 보다 바로 큰 값 찾기
		int j = N-1; //맨 뒤부터
		while(numbers[i-1] >= numbers[j]) --j;
		
		//3. i-1과 j위치 값 바꾸기
		swap(numbers,i-1,j);
		
		//꼭대기 i 부터 마지막까지 오름차순으로 정렬
		int k = N-1;
		while(i<k) {
			swap(numbers,i++,k--);
		}
		
		return true;
		
	}
	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
		
	}

}
