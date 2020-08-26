package algorithm_8_1;

import java.util.Scanner;

public class 보물상자비밀번호_SWEA5658NOT {
	static int N,k;
	static char arr[];
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt();
			k=sc.nextInt();
			arr = new char[N];
			
			String str = sc.next();
		
			for (int i = 0; i < N; i++) {
				arr[i] = str.charAt(i);
			}
			int N4 = N/4;
			
			for (int i = 0; i < args.length; i++) {
				
			}
			System.out.println("#" + test_case + " ");
		}
	}
}