package algorithm_2110;

import java.util.Arrays;
import java.util.Scanner;

public class 블랙잭_백준2798 {
	static int N, M, Ans;
	static int[] arr,sel;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		sel = new int[3];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Ans = Integer.MIN_VALUE;
		combi(0,0);
		System.out.println(Ans);
	}
	private static void combi(int idx, int k) {
		if(sel.length == k) {
			int sum=0;
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < 3; i++) {
				sum += sel[i];
			}
			if(Ans < sum && sum<=M) {
				Ans = sum;
			}
//			System.out.println("Ans "+Ans);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = arr[i];	
				combi( idx + 1,  k + 1);
				v[i] = false;
			}
		}
	}
}
