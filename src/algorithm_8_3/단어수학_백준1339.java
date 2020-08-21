package algorithm_8_3;

import java.util.Scanner;

public class 단어수학_백준1339 {
	static int N, index, sum;
	static int[] alph = new int[26];
	static int[] sel;
	static String[] str;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		str = new String[N];
		sel = new int[11];
		for (int i = 0; i < N; i++) {
			String temp = sc.next();
			str[i] = temp;
		}
		index = 1;
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str[i].length(); j++) {
				int idx = str[i].charAt(j) - 'A';
				if (alph[idx] == 0) {
					alph[idx] = index;
					index++;
				}
			}
		}

//		for (int i = 0; i < alph.length; i++) {
//			System.out.print(alph[i]);
//		}
		permutation(1,new boolean[sel.length]);
		System.out.println(max);
	}
	public static void permutation(int k, boolean[] v) {
		
		if(k == index) {
			sum = 0;
			for (int i = 0; i < str.length; i++) {
				int temp=0;
				for (int j = 0; j < str[i].length(); j++) {
					temp = temp * 10 + sel[alph[str[i].charAt(j)-'A']];
				}
				sum += temp;
			}
			if(max<sum) {
				max = sum;
			}
			
			return;
		}
		for (int i = 0; i < 10; i++) {
			if(v[i]!=true) {
				v[i] = true;
				sel[k] = i;
				permutation(k+1, v);
				v[i] = false;
			}
		}
	}
}
