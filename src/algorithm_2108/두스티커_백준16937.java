package algorithm_2108;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 두스티커_백준16937 {
	static int H, W, N, res, max = Integer.MIN_VALUE;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	
	static int[] v;
	static List<Point> sticker = new ArrayList();
	static List<Point> temp = new ArrayList();
	static class Point {
		int h,w;
		Point(int h, int w) {
			super();
			this.h = h;
			this.w = w;
		}
		public Integer getHeight() {
			return this.h;
		}
		public Integer getWidth() {
			return this.w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		H = sc.nextInt();
		W = sc.nextInt();
		N = sc.nextInt();
		v = new int[100];

		for (int i = 0; i < N; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			sticker.add(new Point(x, y));
		}
		dfs(2,0);
		
		System.out.println(max);
		
	}
	static boolean chkHeight(int h1, int w1, int h2, int w2) {		//위 아래로 붙였을 때 
		if(h1+h2 > H || Math.max(w1, w2) > W) return false;
		else return true;
	}
	static boolean chkWidth(int h1, int w1, int h2, int w2) {		//양옆으로 붙였을 때 
		if(Math.max(h1, h2) > H || w1 + w2 > W) return false;
		else return true;
	}
	
	static boolean chkHW(int h1, int w1, int h2, int w2) {
		if(chkHeight(h1,w1,h2,w2)==true || chkWidth(h1,w1,h2,w2)==true) return true;
		else return false;
	}
	private static void dfs(int pick, int start) {
		if(pick == 0) {
			int h1 = temp.get(0).getHeight();
			int w1 = temp.get(0).getWidth();
			
			int h2 = temp.get(1).getHeight();
			int w2 = temp.get(1).getWidth();
			
			//1번 그대로, 2번 그대로 
			boolean chk = false;
			if(chkHW(h1,w1,h2,w2) == true) {	
				int area = h1*w1 + h2*w2;
				if(max<area) max = area;
				chk = true;
			}
			else {
				for(int i = 0; i<3; i++) {
					int a,b,c,d;
					if(i==0) {				//1번 회전, 2번 그대로
						a = w1; b = h1;
						c = h2; d = w2;
					}
					else if(i==1) {			//1번 그대로, 2번 회전
						a = h1; b = w1;
						c = w2; d = h2;
					}
					else {					//1번 회전, 2번 회전 
						a = w1; b = h1;
						c = w2; d = h2;
					}
					if(chkHW(a,b,c,d)==true) {
						chk = true;
						int area = h1*w1 + h2*w2;
						if(max<area) max = area;
						return;
					}
				}
			}
			
			return;
		}
		for (int i = start; i < sticker.size(); i++) {
			if(v[i] == 0) {
				v[i] = 1;
				temp.add(sticker.get(i));
				dfs(pick-1, i);
				temp.remove(temp.size()-1);
				v[i] = 0;
			}
		}
	}
}
