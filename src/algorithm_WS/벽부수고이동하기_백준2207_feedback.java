package algorithm_WS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 벽부수고이동하기_백준2207_feedback {
	static int N, M, Ans;
	static int map[][];
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][][] v; //벽 부서진 상태

	static class Loc {
		int x, y, move, wallB;

		public Loc(int x, int y, int move, int wallB) {
			super();
			this.x = x;
			this.y = y;
			this.move = move; //이동거리
			this.wallB = wallB; //벽부순 확인
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		v = new boolean[N][M][2]; //마지맏 [] - 부시고,안부시고 2가지 방문체크 
		Ans = Integer.MAX_VALUE;
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
	
		Queue<Loc> queue = new LinkedList<>();
		queue.add(new Loc(0,0,1,0));
		v[0][0][0]=true;
		while (!queue.isEmpty()) {
			Loc p = queue.poll();
			if(p.x == N-1 && p.y == M-1) { //끝 지점 
				Ans = Math.min(Ans, p.move);
				break;
			}
			for (int i = 0; i < 4; i++) {
				int nr = p.x + dr[i];
				int nc = p.y + dc[i];
				int wallB = p.wallB;
				
				if (nr < 0 || nr >= N || nc < 0 || nc >= M) { //map나갓을 때
					continue;
				}
				
				if (map[nr][nc] == 0 && !v[nr][nc][wallB]) { //0일 때
					v[nr][nc][wallB] = true;
					queue.add(new Loc(nr, nc,p.move+1,p.wallB));
				}else if(map[nr][nc] == 1 && wallB==0) { //1인데, 한개 부수기ㅣ!!, wallB가 0일 때만 한번 할 수 있다
						v[nr][nc][1] = true;
						queue.add(new Loc(nr, nc, p.move+1, 1));
					}
				
			}
		}
		if(Ans == Integer.MAX_VALUE) {
			//초기화한 값 그대로면, 이동 불가
			System.out.println(-1);
		}else {
			System.out.println(Ans);
		}
	}


}
