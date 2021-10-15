package algorithm_2110;

import java.util.Scanner;

public class 개똥벌레_백준 {
	static int N, H;
	static int[] down, up;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		H = sc.nextInt();
		down = new int[H+1];
		up = new int[H+1];
		for (int i = 0; i < N; i++) {
			int n = sc.nextInt();
			if (i % 2 == 0) {
				down[n]++;
			} else {
				up[n]++;
			}
		}
//		for (int i = 0; i < H; i++) {
//			System.out.print(down[i]+" ");
//		}System.out.println();for (int i = 0; i < H; i++) {
//			System.out.print(up[i]+" ");
//		}System.out.println();
		for (int i = H-1; i > 0; i--) {
			down[i] +=down[i+1];
			up[i] += up[i+1];
		}
//		for (int i = 0; i < H; i++) {
//			System.out.print(up[i]+" ");
//		}
		int min = Integer.MAX_VALUE;
		int cnt = 0;
		for (int i = 1; i <= H; i++) {
			int full = down[i] + up[H-i+1];
			
			if (min > full) {
				min = full;
				cnt = 1;
			} else if (min == full) {
				cnt++;
			}

		}

		System.out.println(min + " " + cnt);
	}
}
