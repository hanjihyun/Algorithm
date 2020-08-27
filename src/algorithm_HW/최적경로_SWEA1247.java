package algorithm_HW;

import java.util.Scanner;

public class 최적경로_SWEA1247 {
	static int N;
	static int[] x;
	static int[] y;
	static int[] selX;
	static int[] selY;
	static int companyX,companyY,homeX,homeY;
	static int min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			
			x = new int[N];
			y = new int[N];
			selX = new int[N];
			selY = new int[N];
			
			companyX = sc.nextInt();
			companyY = sc.nextInt();
			homeX = sc.nextInt();
			homeY = sc.nextInt();
			
			for (int i = 0; i < N; i++) {
				x[i] = sc.nextInt();
				y[i] = sc.nextInt();
			}
			
			permutation(0,0,new boolean[N]);
			System.out.println("#"+test_case+" "+min);
		}
	}
	private static void permutation(int idx, int k,boolean[] v) {
		int path=0;
		int start =  Math.abs(selX[0]-companyX) + Math.abs(selY[0]-companyY);
		int end =  Math.abs(homeX-selX[N-1]) + Math.abs(homeY-selY[N-1]);
		
		if(k==selX.length) {
			//System.out.println("<"+start+" "+end+">");
			for (int i = 0; i < selX.length-1; i++) {
				path += Math.abs(selX[i+1]-selX[i]) + Math.abs(selY[i+1]-selY[i]);
				
				
//				System.out.println(selX[i]+" "+selY[i]);
			}
			path += start+end;
			int temp=0;
			if(min > path) {
				temp = min;
				min = path;
				path=min;
			}

			return;
		}
		
		for (int i = 0; i < N; i++) {
			if(v[i]==false) {
				v[i]=true;
				selX[k] = x[i]; 
				selY[k] = y[i]; 
				//path = Math.abs(selX[i+1]-selX[i]) + Math.abs(selY[i+1]-selY[i]);
				permutation(i+1, k+1, v);
				v[i]=false;
			}
		}
		
	}

}
