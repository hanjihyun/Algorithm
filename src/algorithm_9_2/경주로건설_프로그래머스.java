package algorithm_9_2;

import java.util.LinkedList;
import java.util.Queue;

public class 경주로건설_프로그래머스 {

	static int[]dr = {-1,1,0,0};
	static int[]dc = {0,0,-1,1};
	
	static class Point{
		int x,y,d,c;
		//d : 상:0 하:1 좌:2 우:3
		Point(int x, int y, int d, int c) {
			super();
			this.x = x;
			this.y = y;
			this.d = d;
			this.c = c;
		}

		
	}
	private static int solution(int[][] board) {
		int answer = Integer.MAX_VALUE;
		int N = board.length;
		
		Queue<Point> q = new LinkedList<Point>();
		//0,0 주변부터 check
		if(board[0][1] == 0) {
			q.add(new Point(0,1,3,100));
			board[0][1] = 100;
		}
		if(board[1][0] == 0) {
			q.add(new Point(1,0,1,100));
			board[1][0] = 100;
		}
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			if(p.x == N-1 && p.y == N-1) {
				answer = Math.min(answer, p.c);
				 // break가 아닌 continue를 하는 이유: 이 bfs는 길의 길이가 긴 길이 더 비용이 짧을 수 있기 때문
				continue;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				
				if(nc<0 || nc>=N || nr<0 || nr>=N) {
					continue;
				}
				if(board[nr][nc] != 1) {
					int cost;
					if(p.d == i) {
						cost = p.c+100;
					}else {
						cost = p.c+600;
					}
					if(board[nr][nc] == 0) {
						board[nr][nc] = cost;
						q.offer(new Point(nr,nc,i,cost));
					}else if(board[nr][nc] >= cost) {
						board[nr][nc] = cost;
						q.offer(new Point(nr,nc,i,cost));
					}
				}
			}
		}
		
		
		return answer;
		
	}
	
	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
		
		int answer = solution(board);
		System.out.println(answer);
	}
}
