package algorithm_10_5;

import java.util.Scanner;

public class 수영장_SWEA1952 {
	static int[] pay;
	static int[] months;
	static int Ans;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			pay = new int[4];
			months = new int[12];
			
			for (int i = 0; i < pay.length; i++) {
				pay[i] = sc.nextInt();
			}
			for (int i = 0; i < months.length; i++) {
				months[i] = sc.nextInt();
			}
			Ans=Integer.MAX_VALUE;
			
			dfs(0,0);
			if(Ans > pay[3]) {
				Ans = pay[3];
			}
			System.out.println("#"+test_case+" "+Ans);
		}
	}
	private static void dfs(int idx, int sum) {
		 if(idx >= 12){
	            Ans = Ans > sum ? sum : Ans;
	            return;
	        }

	        // 이용일 수 0인 달은 비용을 더하지 않는다
	        if(months[idx] == 0){
	            dfs(idx+1, sum);
	        }
	        else{
	            dfs(idx+1, sum + (months[idx]*pay[0])); // 하루 이용권 사용
	            dfs(idx+1, sum + pay[1]);   // 한달 이용권 사용
	            dfs(idx+3, sum + pay[2]);   // 세달 이용권 사용
	        }
	}
}