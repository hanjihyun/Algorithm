package algorithm_practice;

import java.util.Scanner;

public class 알파벳찾기10809 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] alpha = new int[26];
		
		String S = sc.next();
		int[] str = new int[S.length()];
		
		for (int i = 0; i < str.length; i++) {
			str[i] = S.charAt(i)-'A';
		}
		for (int i = 0; i < str.length; i++) {
			alpha[str[i]-1]++;
		}
		for (int i = 0; i < str.length; i++) {
			System.out.print(alpha[i]+" ");
		}
	}

}
