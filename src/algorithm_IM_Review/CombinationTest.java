package algorithm_IM_Review;

import java.util.Arrays;
import java.util.Scanner;

// nCr  n개중에 r개 선택하는 코드

public class CombinationTest {

	// 1,2,3
	// 3C2 = 3!/1!2! = 3
	static int N,R; //N전체 데이터 갯수, R선택 해야 되는 수의 갯수
	static int[] input,sel;
	//input : N개의 데이터가 들어갈 배열
	//numbers : R개의 선택된 데이터가 들어갈 배열
	static int totalCount;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		sel = new int[R];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		combination(0,0);
//		(선택 대상이 되는 데이터의 시작 위치,선택한 데이터 갯수)
		System.out.println("총 경우의 수 : "+totalCount);
	}

	private static void combination(int idx, int k) {
		if(sel.length == k) {
			//기저조건(종료조건)
			//문제 내용에 따라 수정되어야 함
			totalCount++;
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = idx; i < input.length; i++) {
			sel[k]=input[i];
			combination(i+1, k+1);
			
		}
	}

	
}
