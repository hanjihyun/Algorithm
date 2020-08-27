package algorithm_HW;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//import com.ssafy.hw200805.BaekJoon_1012_bfs_lec.Point;

public class 단지번호붙이기_백준2667 {
	
	static int N,count;
	static int[][] map;
	static int cnt=0;
	//static boolean[][] v;
	static int[] dr= {-1,1,0,0};
	static int[] dc= {0,0,-1,1};
	static ArrayList<Integer> list = new ArrayList<Integer>();
	static class Point{
		int x,y;
		Point(int x, int y){
			this.x = x;
			this.y = y;
			//this.comp = comp;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		map = new int[N][N];
		count = 0;
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		for (int i = 0; i < N; i++) {
			
			for (int j = 0; j < N; j++) {
				if(map[i][j] == 1) {
					count++;
					bfs(i, j);
					list.add(cnt);
					cnt=0;
					
				}
			}
			
		}
		Collections.sort(list);
		System.out.println(count);		
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	private static void bfs(int x, int y) {
		Queue<Point> Q = new LinkedList();		
		
		Q.add(new Point(x, y));
		
		map[x][y] = 0;
		while(!Q.isEmpty()) {
			Point p = Q.poll();
			cnt+=1;
			for (int k = 0; k < 4; k++) {
				int nr = p.x+dr[k];
				int nc = p.y+dc[k];
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
					continue;
				}
				if(map[nr][nc] ==1 ) {
					map[nr][nc]=0;
					Q.add(new Point(nr,nc));
					
					
				}
			}
			//list.add(cnt);
			
		}
		
//		System.out.println(list);
	}

}
