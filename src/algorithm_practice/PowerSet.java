package algorithm_practice;

import java.util.Arrays;

public class PowerSet {
	static int[] arr = {1,2,3,4,5,6};
	static boolean[] v = new boolean[arr.length];
	
	public static void main(String[] args) {
		powerSet(0,0);
	}

	private static void powerSet(int idx, int sum) {
		if(idx == arr.length) {
			for (int i = 0; i < arr.length; i++) {
				if(v[i] == true) {
					System.out.print(arr[i]+" ");
				}
			}
			System.out.println();
			System.out.println(sum);
			return;
		}
		v[idx] = true;
		powerSet(idx+1, sum+arr[idx]);
		v[idx] = false;
		powerSet(idx+1, sum);
	}
}
