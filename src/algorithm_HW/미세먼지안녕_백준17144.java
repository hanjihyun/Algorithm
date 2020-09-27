package algorithm_HW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class 미세먼지안녕_백준17144 {
	static int[][] map;
	static int R, C, T, Ans;
	static int[][] TempMap;
	static ArrayList<Point> air = new ArrayList();
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		T = sc.nextInt();
		Ans = 0;
		map = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == -1) {
					air.add(new Point(i, j));
				}
			}
		}

		for (int i = 0; i < T; i++) {
			spreadDust();
			airTurnOn(air.get(0), air.get(1));
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					Ans += map[i][j];
				}
			}

		}
		System.out.println(Ans);
	}

	private static void spreadDust() {
		TempMap = new int[R][C];
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					int cnt = 0;
					// (r, c)에 있는 미세먼지는 인접한 네 방향으로 확산된다.
					for (int k = 0; k < 4; k++) {
						int nr = i + dr[k];
						int nc = j + dc[k];

						// 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
						if (nr < 0 || nr >= R || nc < 0 || nc >= C || map[nr][nc] == -1) {
							continue;
						}
						// 확산되는 양은 Ar,c/5이고 소수점은 버린다.
						if (map[i][j] >= 5) {
							TempMap[nr][nc] += map[i][j] / 5;
							cnt++;
						}
					}
					// (r, c)에 남은 미세먼지의 양은 Ar,c - (Ar,c/5)×(확산된 방향의 개수) 이다.
					TempMap[i][j] += map[i][j] - (map[i][j] / 5) * cnt;
				}
			}
		}

		for (int i = 0; i < R; i++) {
			map[i] = Arrays.copyOf(TempMap[i], C);
		}
//		for (int i = 0; i < R; i++) {
//			for (int j = 0; j < C; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//
//		System.out.println();

	}

	private static void airTurnOn(Point left, Point right) {
		// right : 시계방향, left : 반시계
		TempMap = new int[R][C];
		for (int i = 0; i <= left.x; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					// 왼쪽 끝
					if (i < left.x && j == 0) {
						if (i + 1 == left.x) {
							TempMap[i][j] = 0;
						} else {
							TempMap[i + 1][j] = map[i][j]; // 왼쪽 끝에 서 꺽기
						}
					}
					// 맨 위줗
					if (i == 0) {
						if (j == 0) {
							TempMap[i + 1][0] = map[i][j]; // 왼쪽 끝에 서 꺽기
						} else {
							TempMap[i][j - 1] = map[i][j];
						}
					}

					// 오른쪽 끝
					if (i != 0 && i != left.x && j == C - 1) {
						TempMap[i - 1][j] = map[i][j];
					}
					// 위 공기 청정기 라인
					if (i == left.x) {

						if (j == C - 1) {
							TempMap[i - 1][j] = map[i][j];// 오른쪽 끝에 서 꺽기
						} else {
							TempMap[i][j + 1] = map[i][j];
						}
					}
				
				}
				
			}
			TempMap[left.x][left.y + 1] = 0;
		}
		for (int i = right.x; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] > 0) {
					// 왼쪽 끝
					if (i > right.x && j == 0) {
						if (i - 1 == right.x) {
							TempMap[i][j] = 0;
						} else {
							TempMap[i - 1][j] = map[i][j]; // 왼쪽 끝에 서 꺽기
						}
					}
					// 맨 위줗
					if (i == right.x) {
						if (j == C - 1) {
							TempMap[i + 1][j] = map[i][j];// 오른쪽 끝에 서 꺽기
						} else {
							TempMap[i][j + 1] = map[i][j];
						}
					}

					// 오른쪽 끝
					if (i != R - 1 && i != right.x && j == C - 1) {
						TempMap[i + 1][j] = map[i][j];// 오른쪽 끝에 서 꺽기
					}
					// 위 공기 청정기 라인
					if (i == R - 1) {

						if (j == 0) {
							TempMap[i - 1][0] = map[i][j]; // 왼쪽 끝에 서 꺽기
						} else {
							TempMap[i][j - 1] = map[i][j];
						}
					}
					
				}
				
			}
			TempMap[right.x][right.y + 1] = 0; // 공기청정기 앞
		}

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(TempMap[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		// 내부 움직이지 않는 애들 옮기기
		for (int i = 1; i < left.x; i++) {
			for (int j = 0; j < C - 1; j++) {
				TempMap[i][j] = map[i][j];
			}
		}
		for (int i = right.x + 1; i < R - 1; i++) {
			for (int j = 0; j < C - 1; j++) {
				TempMap[i][j] = map[i][j];
			}
		}
		for (int i = 0; i < R; i++) {
			map[i] = Arrays.copyOf(TempMap[i], C);
		}

	}

}
