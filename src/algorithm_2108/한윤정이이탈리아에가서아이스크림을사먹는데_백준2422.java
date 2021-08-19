package algorithm_2108;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 한윤정이이탈리아에가서아이스크림을사먹는데_백준2422 {
	static int N, M, Ans;
	static List<combiX> list;
	static int[] sel, arr;

	static class combiX {
		int a, b;

		combiX(int a, int b) {
			super();
			this.a = a;
			this.b = b;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();
		list = new ArrayList<>();
		arr = new int[N];
		sel = new int[3];

		for (int i = 0; i < N; i++) {
			arr[i] = i + 1;
		}
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list.add(new combiX(a, b));
		}
		combiO(0, 0);
		System.out.println(Ans);
	}

	private static void combiO(int idx, int k) {
		if (sel.length == k) {
			boolean chk = false;

			for (int j = 0; j < list.size(); j++) {
				int cnt = 0;
				for (int i = 0; i < sel.length; i++) {

					if (sel[i] == list.get(j).a) {
						cnt++;
					} else if (sel[i] == list.get(j).b) {
						cnt++;
					}
					if (cnt >= 2) {
						chk = true;
						break;
					}
				}
			}
			if (chk == false) {
				Ans++;
				System.out.println(Arrays.toString(sel));
			}
			return;
		}
		if (idx == arr.length) {
			return;
		}
		sel[k] = arr[idx];
		combiO(idx + 1, k + 1);
		combiO(idx + 1, k);
	}
}
