package algorithm_WS;

import java.util.Scanner;

public class 오목_백준2615 {

	static int map[][] = new int[20][20];
	static int[] dr = { -1, 0, 1, 1 }; //우상,우, 우하, 하
	static int[] dc = { 1, 1, 1, 0 }; 
	static boolean flag = false;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for (int i = 1; i <= 19; i++) {
			for (int j = 1; j <= 19; j++) {
				if((map[i][j] == 1 || map[i][j] == 2)) {
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];
						int cnt = 1;
						while(check(nr,nc) && map[nr][nc] == map[i][j]) {
							nr = nr + dr[k];
							nc = nc + dc[k];
							cnt++;
						}
						//오목이명
						if(cnt == 5) {
							int bCnt = 1;
							//뒤로 돌아가서 오목인지 확인
							nr = nr + (dr[k]*-1);
							nc = nc + (dc[k]*-1);
							while(check(nr,nc) && map[nr][nc]==map[i][j]) {
								nr += (dr[k]*-1);
								nc += (dc[k]*-1);
								bCnt++;
							}
							if(bCnt > 6) continue;
							flag = true;
							System.out.println(map[i][j]);
							System.out.println(i+" "+j);
						}
					}
				}
			}
		}
		if(!flag) {
			System.out.println(0);
		}
	}

	private static boolean check(int nr, int nc) {
		if(nr>0&&nr<=19&&nc>0&&nc<=19) {
			return true;
		}
		return false;
	}

}
