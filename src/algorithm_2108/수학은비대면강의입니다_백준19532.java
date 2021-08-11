package algorithm_2108;

import java.util.Scanner;

public class 수학은비대면강의입니다_백준19532 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
//		int g = lcm(a, d);
//
//		int tmp1 = g / a;
//		int tmp2 = g / d;
//
//		a = a * tmp1;
//		b = b * tmp1;
//		c = c * tmp1;
//		d = d * tmp2;
//		e = e * tmp2;
//		f = f * tmp2;
//
////		System.out.println(a + " " + b + " " + c + " " + d + " " + e + " " + f);
//		int y = 1;
//		if (a >= d) {
//			y = (c - f) / (b - e);
//		} else {
//			y = (f - c) / (e - b);
//		}
//		int x = 1;
//		x = (c - (b * y)) / a;
//
//		System.out.println(x + " " + y);
		
		for (int i = -999; i < 1000; i++) {
			for (int j = -999; j < 1000; j++) {
				if(a*i+b*j==c && d*i+e*j==f) {
					System.out.println(i+" "+j);
					System.exit(0);
				}
			}
		}
	}

//	static int gcd(int a, int b) { // 최대공약수
//		while (b != 0) {
//			int r = a % b;
//			a = b;
//			b = r;
//		}
//		return a;
//	}
//
//	static int lcm(int a, int b) { // 최소 공배수
//
//		return a * b / gcd(a, b);
//	}
}
