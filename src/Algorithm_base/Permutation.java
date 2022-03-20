package Algorithm_base;

import java.util.Arrays;
//순열 - 순서 상관 있고, 중복허용 안함
public class Permutation {
	static int arr[] = {1,3,5};
	static int sel[] = new int[2]; 
	public static void main(String[] args) {
		Permutation(0,0,new boolean[arr.length]);
	}
	//k 뽑을 인덱스
	private static void Permutation(int idx, int k, boolean[] c) {
		if(k == sel.length) {
			System.out.println(Arrays.toString(sel));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if(c[i] != true) {
				c[i] = true;
				sel[k] = arr[i];
				Permutation(idx+1,k+1,c);
				c[i] = false;
			}
		}
	}
	
}
