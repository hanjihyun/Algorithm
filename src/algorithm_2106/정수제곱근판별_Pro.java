package algorithm_2106;
public class 정수제곱근판별_Pro {
	public static void main(String[] args) {
		long n = 121;
		long answer = 0;
		long val = (long) Math.sqrt(n);
		
//		if(n==1) {
//			answer = 4;
//		}else {
//			for (int i = 1; i <= n; i++) {
//				if (n/i == i && n%i == 0) {
//					answer = (i + 1) * (i + 1);
//				}
//			}
//		}
		
		System.out.println( (val*val) == n ? (val+1)*(val+1) : -1);
	}
}
