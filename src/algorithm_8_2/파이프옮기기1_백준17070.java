package algorithm_8_2;

import java.util.Scanner;

public class 파이프옮기기1_백준17070 {
	static int N,max;
	static int[][] room;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		max=0;
		room = new int[N+1][N+1];
		
		
		for (int i = 1; i < N+1; i++) {
			for (int j = 1; j < N+1; j++) {
				room[i][j] = sc.nextInt();
			}
		}

			dfs(1,2,0);

	
		System.out.println(max);
	}
	private static void dfs(int x, int y,int d) {
		
		    if (x == N  && y == N) {
		        max++;
		        return;
		    }
		    if (d == 0) { //방향이 오른쪽일 때,
		        if (y + 1 <= N && room[x][y + 1] == 0) { //만약 y좌표 +1한 곳이 N보다 같거나 작고 그 방이 0이면
		            dfs(x, y + 1, 0); //그 자리 재귀, 방향은 그대로
		        }
		        if (x + 1 <= N&&y + 1 <= N&& room[x + 1][y] == 0&&room[x][y + 1] == 0&&room[x+1][y + 1] == 0) {//만약 x좌표 +1한 곳이 N보다 같거나 작고, 그 방이 0이고, 그
		                dfs(x + 1, y + 1, 2);
		        }
		    }
		    else if (d == 1) {//방향이 아래쪽일 때,
		        if (x + 1 <= N && room[x + 1][y] == 0) {
		            dfs(x + 1, y, 1);
		        }   
		            if (x + 1 <= N&&y + 1 <= N&& room[x + 1][y] == 0&&room[x][y + 1] == 0&&room[x+1][y + 1] == 0) {
		                dfs(x + 1, y + 1, 2);
		        }
		    }
		    else {
		        if (y + 1 <= N && room[x][y + 1] == 0) dfs(x, y + 1, 0);
		        if (x + 1 <= N && room[x + 1][y] == 0) dfs(x + 1, y, 1);
		        if (x + 1 <= N && y + 1 <= N &&room[x + 1][y] == 0 && room[x][y + 1] == 0 && room[x + 1][y + 1] == 0)dfs(x + 1, y + 1, 2);
		    }
		    return;
		
	}

}
