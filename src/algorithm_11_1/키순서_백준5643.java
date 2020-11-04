package algorithm_11_1;

import java.util.ArrayList;
import java.util.Scanner;


public class 키순서_백준5643 {
	static int N,M,Ans,sh,tall;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer>[] list_reverse;
	static boolean[] v,v1;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N=sc.nextInt();
			M=sc.nextInt();
			Ans = 0;
			list = new ArrayList[N + 1];
			list_reverse = new ArrayList[N + 1];
			
			for (int i = 1; i <= N; i++) {
				list[i] = new ArrayList<Integer>();
				list_reverse[i] = new ArrayList<Integer>();
			}
			
			for (int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				list[a].add(b);
				list_reverse[b].add(a);
			}
			for (int i = 1; i <= N; i++) {
				v1 = new boolean[N+1];
				v= new boolean[N+1];
				sh=-1;tall=-1;
				dfs(i);
				dfs_re(i);
				if(sh + tall == N-1) {
					Ans++;
				}
			}
			
			System.out.println("#"+test_case+" "+Ans);
		}
	}
	private static void dfs_re(int start) {
		v[start] = true;
		sh++;
		for (int i = 0; i < list_reverse[start].size(); i++) {
			Integer next = list_reverse[start].get(i);
			if(!v[next]) {
				dfs_re(next);
			}
		}
	}
	private static void dfs(int start) {
		v1[start] = true;
//		System.out.print(start+ " ");
		tall++;
		for (int i = 0; i < list[start].size(); i++) {
			Integer next = list[start].get(i);
			if(!v1[next]) {
				dfs(next);
			}
		}
	}
}
