package algorithm_2111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class 이장님초대_백준9237 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());

		Integer[] tree = new Integer[N];

		st = new StringTokenizer(br.readLine()," ");

		for (int i = 0; i < N; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(tree, Collections.reverseOrder());
		int Ans = 2;
		int max = 0;
		for (int i = 0; i < N; i++) {// 나무 자라는 일수+심는데 흐른 일수
			max = Math.max(max, tree[i]+Ans);
			Ans++;
		}

		System.out.println(max);
	}
}
