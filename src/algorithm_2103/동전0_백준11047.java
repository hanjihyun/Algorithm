package algorithm_2103;
import java.util.Scanner;

public class 동전0_백준11047 {
	static int N,K,arr[];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		int Ans = 0;
		int temp = K;
		
		for (int i = N-1; i >= 0; i--) {
			if(K/arr[i] != 0) {
				Ans += K/arr[i];
				K = K % arr[i];
			}
		}
		System.out.println(Ans);
	}
}
