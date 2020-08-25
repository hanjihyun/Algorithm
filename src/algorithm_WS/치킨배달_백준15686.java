package algorithm_WS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class 치킨배달_백준15686 {
	static int N,M;
	static int Ans = Integer.MAX_VALUE;
	static int[] sel;
	static boolean[] v;
	static ArrayList<Point> home = new ArrayList<>();
	static ArrayList<Point> chicken = new ArrayList<>();
	
	static class Point{
		int r,c;

		Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[M];
		
		v = new boolean[chicken.size()];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int n = sc.nextInt();
				if(n == 1) {
					home.add(new Point(i,j));
				}else if(n == 2) {
					chicken.add(new Point(i,j));
				}
			}
		}
		
		//전체 치킨 가게 중에 M개의 갯수로 이루어진 조합을 구해
		//조합의 치킨 가게와 집들의 최소 거리의 합
		combination(0,0);
		
		System.out.println(Ans);
	}

	private static void combination(int idx, int k) {
		if(k==M) {
			//다 골랐어요
//			System.out.println(Arrays.toString(sel));
			//집과 골라진 치킨집들의 거리를 계산하여 그 중 가장 짧은 거리들의 합을 구합니다.
			int sum=0;
			for (int i = 0; i < home.size(); i++) {
				// |r1.r-r2.r|+|r1.c-r2.c|
				int dist = Integer.MAX_VALUE;
				for (int j = 0; j < M; j++) {
					dist = Math.min(dist, cal(home.get(i),chicken.get(sel[j])));
				}
				sum+=dist;
			}
			Ans = Math.min(Ans, sum);
			return; 
		}
		if(idx == chicken.size()) {
			//더 고를게 없어요
			return;
		}
		
		sel[k] = idx;
		combination(idx+1, k+1);
		combination(idx+1, k);
		
//		for (int i = idx; i < chicken.size(); i++) {
//			if(v[i]) continue;
//			
//			v[i] = true;
//			sel[k] = i;
//			combination(i, k+1);
//			v[i] = false;
//		}

	}

	private static int cal(Point point, Point point2) {
		return (Math.abs(point.r-point2.r)) + (Math.abs(point.c-point2.c));
	}
}
