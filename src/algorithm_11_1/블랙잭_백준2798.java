package algorithm_11_1;

import java.util.Scanner;

public class 블랙잭_백준2798 {
	static int N,M,Ans;
	static int[] card;
	static int[] sel;
	static boolean[] v;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		card = new int[N];
		sel = new int[3];
		v = new boolean[N];
		for (int i = 0; i < N; i++) {
			card[i] = sc.nextInt();
		}
		
		Ans = Integer.MIN_VALUE;
		comb(0,0);
		System.out.println(Ans);
	}
	private static void comb(int idx, int k) {
		int sum=0;
		if(sel.length == k) {
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}
			if(sum>M) {
				return;
			}else {
				if(Ans<sum) {
					Ans = sum;
				}
			}
			return;
		}
		for (int i = idx; i < N; i++) {
			if(!v[i]) {
				v[i] = true;
				sel[k] = card[i];
				comb(idx+1, k+1);
				v[i] = false;
			}
		}
	}
}
