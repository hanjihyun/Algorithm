package com.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class 나무재테크_백준16235 {
	static int N, M, K, Ans;
	static int[][] map, nutri;
	static int[][] age;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 }; // 왼쪽 대각선부터, 시계방향
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static ArrayList<Point> list[][];

	static class Point implements Comparable<Point> {
		int z;

		protected Point(int z) {
			super();
			this.z = z;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.z - o.z;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt(); // 나무 개수
		K = sc.nextInt();

		map = new int[N + 1][N + 1];
		nutri = new int[N + 1][N + 1];

		list = new ArrayList[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				// 겨울에 줄 양분 저장
				map[i][j] = sc.nextInt();
				nutri[i][j] = 5;
			}
		}
		for (int r = 1; r <= N; r++) {
			for (int c = 1; c <= N; c++) {
				list[r][c] = new ArrayList<Point>();
			}
		}

		// 겨울에 양분을 추가 --> map[x][y] = z(나이)
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int z = sc.nextInt(); // 나이
			list[x][y].add(new Point(z));
		}

		ArrayList<Point> temp;
		for (int h = 0; h < K; h++) {
			// 봄 - 자신의 나이만큼 양분으로 먹고, 나이가 + 1
			// 1*1 크기에 있는 양분만 먹을 수 있다.
			// 한칸에 여러개의 나무가 있으면 어린애 부터 양분
			// 죽은애들 처리
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {

					temp = new ArrayList<>();
					int death = 0;
					Collections.sort(list[r][c]); // 나이 순서로 sort
					for (int i = 0; i < list[r][c].size(); i++) {
						Point p = list[r][c].get(i);
						if (nutri[r][c] < p.z) {
							// 양분이 부족하면 바로 죽음
							// 여름
							// 봄에 죽은 나무가 양분으로 , 죽은 나무 나이 / 2 양분으로 추가
							death += (p.z / 2); 
						} else {
							nutri[r][c] -= p.z; // 양분 나이만큼 먹음
							p.z += 1; // 나이 1 증가
							temp.add(p);
						}
					}
					list[r][c] = temp;
					nutri[r][c] += death;
				}
			}
			
			// 가을
			// 나무 번식, 나이가 5의 배수 이면 번식
			for (int r = 1; r <= N; r++) {
				for (int c = 1; c <= N; c++) {
					for (int i = 0; i < list[r][c].size(); i++) {
						Point p = list[r][c].get(i);
						if (p.z % 5 == 0) {
							for (int j = 0; j < 8; j++) {
								int nr = r + dr[j];
								int nc = c + dc[j];

								if (nr > N || nr < 1 || nc > N || nc < 1)
									continue;

								list[nr][nc].add(new Point(1));

							}
						}

					}
				}
			}
			// 겨울 - 땅의 영양분 더함
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					nutri[i][j] += map[i][j];
				}
			}
		}
		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				ans += list[i][j].size();
			}
		}
		System.out.println(ans);

	}

}
