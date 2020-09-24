package algorithm_IM_Review2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class 순열_백준9742 {
	static char[] perm, sel;
	static boolean[] v;
	static int N, order, total;
	

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = null,data;
		
		while ((line=in.readLine()) != null) {		
			StringTokenizer st = new StringTokenizer(line); //   abc  4 
			data = st.nextToken();
			
			perm = data.toCharArray();
			
			order = Integer.parseInt(st.nextToken()); 

			N = perm.length;
			sel = new char[N];
			
			v = new boolean[N];
			total = 0; // 순열처리횟수
			
			int fac = 1, i = N;
			while (i > 0) {
				fac *= i;
				--i;
			} // n자리수 순열의 경우의 수 계산

			if (order > fac) { // 순열 불가
				System.out.println(data + " " + order + " = No permutation");
			} else { // 순열 가능
				System.out.print(data + " " + order + " = ");
				perm(0);
				System.out.println();
			}
		}
	}

	private static boolean perm(int k) {
		
		if (N == k) {
			total++;
			if (total == order) {
				for (int i = 0; i < N; i++) {
					System.out.print(sel[i]);
				}
				return true;
			}
			return false;
		}

		for (int i = 0; i < N; i++) {
			if (!v[i]) {
				sel[k] = perm[i];
				v[i] = true;
				if (perm(k + 1) == true)
					return true;
				v[i] = false;
			}
		}
		return false;
	}
}
