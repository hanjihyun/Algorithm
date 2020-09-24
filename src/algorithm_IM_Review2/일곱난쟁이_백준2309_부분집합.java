package algorithm_IM_Review2;

import java.util.Arrays;
import java.util.Scanner;

public class 일곱난쟁이_백준2309_부분집합 {
	static int[] arr = new int[9];
	static boolean[] sel = new boolean[9];
	static int[] members = new int[7];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		int[] ans = new int[7];

		powerset(0, 0, 0);
		for (int i = 0,j=0; i < 9; i++) {
			if(sel[i]) ans[j++] = arr[i];
		}
		Arrays.sort(ans);
		for (int i = 0; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
	}

	private static boolean powerset(int idx, int k,int sum) {
		if(k==7 && sum==100) {
			
			return true;
		}
		if(k==7 || idx==9 ||sum>100) {
			return false;
		}
		//선택
		sel[idx] = true;
		if(powerset(idx+1,k+1,sum+arr[idx])) return true;
		//비선택
		sel[idx] = false;
		return powerset(idx+1, k, sum);
	}
}
