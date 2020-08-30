package algorithm_practice;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
	static int N;
	static int[] input;
	static int totalCount;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		}while(nextPerm(input));
	}

	private static boolean nextPerm(int[] numbers) {
		//1.꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i;
		
		//마지막 순열 
		if(i==0) return false;
		
		//2.i-1위치와 교환한 다음 단계 큰 수 뒤쪽에서 찾기
		int j = N-1;
		while(numbers[i-1] >= numbers[j]) --j;
		
		//3.i-1과 j위치 값 swap
		swap(numbers,i-1,j);
		
		//4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N-1; //맨뒤
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
