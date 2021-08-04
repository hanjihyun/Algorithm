package algorithm_2108;

import java.util.HashSet;
import java.util.Scanner;

public class 카드놓기_백준5568 {
	static int[] arr;
	static int[] sel;
	static HashSet<String> hash = new HashSet<String>();
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();
		
		arr = new int[N];
		sel = new int[K];
		
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		cnt=0;
		permutation(0,0,new boolean[arr.length]);
		System.out.println(hash.size());
	}
	private static void permutation(int idx, int k, boolean[] check) {
		if(k == sel.length) {
			
//			System.out.println(Arrays.toString(sel));
			String str = "";
			for (int i = 0; i < sel.length; i++) {
				str += sel[i]+"";
			}
			hash.add(str);
			return;
		}

		for (int i = 0; i < arr.length; i++) {
			if(check[i]!=true) {
				check[i] =  true;
				sel[k] = arr[i];
				permutation(idx+1, k+1, check);
				check[i] = false;
			}
		}
	}
}
