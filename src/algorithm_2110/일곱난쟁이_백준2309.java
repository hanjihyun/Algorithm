package algorithm_2110;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_백준2309 {
	static int[] hei, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		hei = new int[9];
		sel = new int[7];
		
		for (int i = 0; i < hei.length; i++) {
			hei[i] = sc.nextInt();
		}
		combi(0, 0);
	}

	private static void combi(int idx, int k) {

		if (sel.length == k) {
			int sum = 0;
//			System.out.println(Arrays.toString(sel));
			for (int i = 0; i < sel.length; i++) {
				sum += sel[i];
			}

			if (sum == 100) {
				Arrays.sort(sel);
				for (int i = 0; i < sel.length; i++) {
					System.out.println(sel[i]);
				}

			}
			return;
		}
		if (idx == hei.length) {
			return;
		}
		sel[k] = hei[idx];
		combi(idx + 1, k + 1);
		combi(idx + 1, k);
	}
}
