package algorithm_practice;

import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation_combi {
	static int N,R;
	static int[] input,p;
	static int totalCount;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		p = new int[N];
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		int cnt=0;
		while(++cnt <= R) {
			p[N-cnt] = 1;
		}
		
		do {
			for (int i = 0; i < N; i++) {
				if(p[i] ==1 )System.out.print(input[i]+" ");
			}
		System.out.println();
		}while(nextPermCombi(p));
	}
	private static boolean nextPermCombi(int[] numbers) {
		//1. 꼭대기 찾기
		int i = N-1;
		while(i>0 && numbers[i-1]>=numbers[i]) --i; //바로 앞이랑 비교
		
		if(i==0) return false;//마지막 순열의 상태에는 다음 순열 없다
		
		//2. i-1 위치와 교환할 다음 단계 큰 수 찾기
		int j = N-1; //뒤부터
		while(numbers[i-1]>=numbers[j]) --j; 
		
		//3. i-1과 j위치 교환
		swap(numbers,i-1,j);
		
		//4. i부터 맨 뒤까지 오름 차순 정렬
		int k=N-1;
		while (i<k) {
			swap(numbers,i++,k--);
		}
		return true;
	}
	public static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}
}
