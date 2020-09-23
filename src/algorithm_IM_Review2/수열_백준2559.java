package algorithm_IM_Review2;

import java.util.Scanner;

public class 수열_백준2559 {
	static int[] tem;
	static int N, K, count;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		tem = new int[100001];
		
		count = -100000000;
	
		tem[0] = 0;
		
		for (int i = 1; i <= N; i++) {
			tem[i] = sc.nextInt();
			tem[i] += tem[i-1];
		}


		 for(int i=0; i<=N-K; ++i) {
		        int sum = tem[i+K] - tem[i];
		        count = count < sum ? sum : count;
		    }
		System.out.println(count);
	}
	
}
