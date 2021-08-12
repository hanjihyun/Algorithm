package algorithm_2108;

import java.util.Scanner;

public class 시각_백준18312 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		int cnt = 0;
		int h=0,m=0,s=0;
		while(true) {
			String time = ((h<10)? "0"+h : "" + h) + ((m<10)?"0"+m:""+m) + ((s<10)?"0"+s:""+s); 
			if(time.indexOf(""+K)!= -1)cnt++;
			if(h==N && m==59 && s==59) break;
			s++;
			if(s == 60) {
				m++;
				s=0;
			}if(m==60) {
				m=0;
				h++;
			}
		}
//		for (int h = 0; h < N; h++) {
//
//			if (h / 10 == K || h % 10 == K) {
//				cnt++;
//				System.out.println("h"+h);
//				continue;
//			} else {
//				for (int m = 0; m < 60; m++) {
//					if (m / 10 == K || m % 10 == K) {
//						cnt++;
//						System.out.println("h"+h+"m"+m);
//						continue;
//					} else {
//						for (int s = 1; s < 60; s++) {
//							if (s / 10 == K || s % 10 == K) {
//								System.out.println("h"+h+"m"+m+"s"+s);
//								cnt++;
//							}
//						}
//					}
//				}
//			}
//		}
		System.out.println(cnt);
	}
}
