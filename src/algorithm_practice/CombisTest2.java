package algorithm_practice;

import java.util.Arrays;

public class CombisTest2 {

	static int N;
	static int R;
	static int[] num;
	static boolean[] v;
	
	public static void main(String[] args) {
		num=new int[]{1,2,3,4,5};
		N=num.length;
		R=3;
		v=new boolean[N];
		nCr(0,0, new int[R]);
	}

	public static void nCr(int idx, int k, int [] a) {
		
		if(k==R){
			System.out.println(Arrays.toString(a));
		    return ;
		}
		for (int i = idx; i < N; i++) {

			a[k]=num[i];
			nCr(i+1, k+1, a);
			
		}
		
	}

}
