package Algorithm_base;

import java.util.Arrays;

public class PowerSet {

	// 부분집합 뽑기
	//언제 쓰이나? 예로, 다 조합해서, 두 분류로 나눠보자
	static int[] arr = { 1,2,3,4,5,6}; 
	static boolean[] v= new boolean[arr.length];
	public static void main(String[] args) {
		//int[] arr = { 1, 3, 5, 7, 9 }; 
		//전역으로/??? 빼면
		
		powerSet(0, 0);
	}

	// k는 자리수?
	private static void powerSet(int idx, int sum) {
		if (idx == arr.length) {
			//if (k == 3) {
				for (int i = 0; i < arr.length; i++) {
					if (v[i] == true) {
						System.out.print(arr[i] + " ");
					}

				}
				System.out.println();
				System.out.println(sum);
		//	}
			return;
		}

		v[idx] = true;
		powerSet(idx + 1,sum+arr[idx]);
		v[idx] = false;
		// 안뽑았을 때
		powerSet(idx + 1, sum);
	}

}
