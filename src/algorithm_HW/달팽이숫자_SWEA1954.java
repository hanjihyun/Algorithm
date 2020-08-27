package algorithm_HW;

import java.util.Scanner;

public class 달팽이숫자_SWEA1954 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			int[][] snail = new int[N][N];
			int num = 0;
			int sub=0;
			int r,c;

			
			  for(int i=N; i>0; i-=2){
				 
		            for(c=0; c<i; c++){
		            	num+=1;
		                snail[sub][sub+c]=num;        
		            }
		            for(r=1; r<i; r++){
		            	num+=1;
		                snail[sub+r][N-sub-1]=num;
		            }
		            for(c=1; c<i; c++){
		            	num+=1;
		                snail[sub+r-1][N-sub-c-1]=num;
		            }
		            for(c=1;c<i-1;c++){
		            	num+=1;
		                snail[N-sub-c-1][sub]=num;
		            }   
		            sub+=1;
		        }
			  System.out.println("#"+test_case);
			for(int i=0; i<N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(snail[i][j]+" ");
				}
				System.out.println();
			}
			
			
		}
	}

}
