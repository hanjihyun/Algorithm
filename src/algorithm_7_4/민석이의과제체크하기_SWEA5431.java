package algorithm_7_4;

import java.util.Scanner;

public class 민석이의과제체크하기_SWEA5431 {


	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();  //수강생
			int k = sc.nextInt(); //제출한 사람 수
			
			int[] done = new int[N];
			int ok=0;
			for(int i=0; i<k; i++) {
				ok = sc.nextInt();
				done[ok-1] = 1;
			}

			System.out.print("#"+test_case+" ");
			for(int i=0; i<N; i++) {
				if(done[i] != 1) {
					System.out.print(i+1);		
				}
			}
			System.out.println();
		}
	}

}
