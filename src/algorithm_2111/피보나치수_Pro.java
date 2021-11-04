package algorithm_2111;

public class 피보나치수_Pro {
	public static void main(String[] args) {
		int n = 3;
		
		int answer = fibo(n);
		System.out.println(answer);
	}

	private static int fibo(int n) {
		if(n==0)return 0%1234567;
		if(n==1)return 1%1234567;
		
		int first = 0;
        int second = 1;
        int fi = 0;
        for(int i=2; i<=n; i++) {
			fi = (first+second)%1234567;
			first = second%1234567;
			second = fi%1234567;
		}
		return fi;
	}
}
