package algorithm_11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 분해합_백준2231 {

	static int N,Ans;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Ans=0;
		for (int i = 0; i < N; i++) {
			int num = i;
			int sum = 0;
			
			while(num != 0) {
				sum+=num%10;
				num /= 10;
			}
			if(sum + i == N) {
				Ans = i;
				break;
			}
		}
		System.out.println(Ans);
	}
}
