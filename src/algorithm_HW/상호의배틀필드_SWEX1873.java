package algorithm_HW;

import java.util.Scanner;

public class 상호의배틀필드_SWEX1873{

	private static int[] dr = { 0, -1, 0, 1 };
	private static int[] dc = { -1, 0, 1, 0 };
	private static int x, y, dir;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			int H = sc.nextInt();
			int W = sc.nextInt();

			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				String tool1 = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = tool1.charAt(j);
					if (map[i][j] == '<') {
						x = i;
						y = j;
						dir = 0;
						map[i][j] = '.';
					} else if (map[i][j] == '^') {
						x = i;
						y = j;
						dir = 1;
						map[i][j] = '.';
					} else if (map[i][j] == '>') {
						x = i;
						y = j;
						dir = 2;
						map[i][j] = '.';
					} else if (map[i][j] == 'v') {
						x = i;
						y = j;
						dir = 3;
						map[i][j] = '.';
					}
				}
			}
			int str = sc.nextInt();
			char[] direction = new char[str];
			String input = sc.next();
			for (int i = 0; i < str; i++) {
				direction[i] = input.charAt(i);
			}
		

			for (int i = 0; i < str; i++) {
				if (direction[i] == 'U') {
					dir = 1;
					int nr = x + dr[dir];
					int nc = y + dc[dir];
					if(!(nr>=0 && nr<H &&nc>=0&&nc<W)) {
						continue;
					}
					if(map[nr][nc] == '.') {
						x=nr;
						y=nc;
					}
				}
				if (direction[i] == 'D') {
					dir=3;
					int nr = x + dr[dir];
					int nc = y + dc[dir];
					if(!(nr>=0 && nr<H &&nc>=0&&nc<W)) {
						continue;
					}
					if(map[nr][nc] == '.') {
						x=nr;
						y=nc;
					}
				}
				if (direction[i] == 'L') {
					dir=0;
					int nr = x + dr[dir];
					int nc = y + dc[dir];
					if(!(nr>=0 && nr<H &&nc>=0&&nc<W)) {
						continue;
					}
					if(map[nr][nc] == '.') {
						x=nr;
						y=nc;
					}
				}
				if (direction[i] == 'R') {
					dir=2;
					int nr = x + dr[dir];
					int nc = y + dc[dir];
					if(!(nr>=0 && nr<H &&nc>=0&&nc<W)) {
						continue;
					}
					if(map[nr][nc] == '.') {
						x=nr;
						y=nc;
					}
				}
				
				if(direction[i] == 'S') {
					int nr = x + dr[dir];
					int nc = y + dc[dir];
					
					while(true) {
						
						if( nr>=0 && nr<H &&nc>=0&&nc<W) {
							if(map[nr][nc] == '*') {
								map[nr][nc] = '.';
								break;
							}else if(map[nr][nc] == '#') {
								break;
							}
						}else {
							break;
						}
						nr = nr + dr[dir];
						nc = nc + dc[dir];
						
					}
					
				}
				
			}
			if(dir == 0) {
				map[x][y] = '<';
			}else if(dir == 1) {
				map[x][y] = '^';
			}else if(dir == 2) {
				map[x][y] = '>';
			}else if(dir == 3) {
				map[x][y] = 'v';
			}

			System.out.print("#"+test_case +" ");
			for (int j = 0; j < H; j++) {
				for (int j2 = 0; j2 < W; j2++) {
					System.out.print(map[j][j2]);
				}
				System.out.println();
			}
		}
	}
}