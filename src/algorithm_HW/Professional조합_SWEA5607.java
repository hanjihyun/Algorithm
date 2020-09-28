package algorithm_HW;
import java.util.Scanner;

public class Professional조합_SWEA5607 {
	static int N,R,p;
	static long Ans;
	static long fac[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			Ans = 0;
			N = sc.nextInt();
			R = sc.nextInt();
			if(R == 0) {
				Ans = 1;
			}
			fac = new long[N+1];
			fac[0] = 1;
			
			
			p = 1234567891;
			
			for (int i = 1; i <= N; i++) {
				fac[i] = fac[i-1] * i % p;
			}
			
			long under = (fac[R] * fac[N-R]) % p;
			long fermat = power(under,p-2);
			Ans = (fac[N] * fermat) % p;
			System.out.println("#" + test_case + " "+Ans);
		}
	}
	private static long power(long n, int x) {
		if(x == 0) return 1;
		long temp = power(n, x/2);
		long ret = (temp * temp) % p;
		
		if(x % 2 == 0) {
			return ret;
		}
		else {
			return (ret * n) % p;
		}
	}

}