package algorithm_2111;

import java.util.Scanner;

public class 단어공부_백준1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] alpha = new int[26];
		str = str.toLowerCase();
//		System.out.println(str);
		for (int i = 0; i < str.length(); i++) {
			alpha[str.charAt(i)-97]++;
		}
		int cnt = 0;
		char word = ' ';
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < alpha.length; i++) {
			if(alpha[i] > max) {
				max = alpha[i];
				cnt = 0;
				word = (char) (i+97);
			}else if(alpha[i] == max){
				cnt++;
			}
		}
		String Ans = word + "";
		if(cnt>0) {
			System.out.println("?");
		}else {
			System.out.println(Ans.toUpperCase());
		}
	}
}
