package algorithm_IM_Review2;

import java.util.Scanner;

public class 직사각형네개의합집합의면적구하기_백준2669 {

	static int[][] map;
	 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		map = new int[101][101];
		int lx=0,ly=0,rx=0,ry=0,cnt=0;
		for (int i = 0; i < 4; i++) {
				lx = sc.nextInt();
				ly = sc.nextInt();
				rx = sc.nextInt();
				ry = sc.nextInt();
				for (int h = ly; h < ry ; h++) {
					for (int k = lx; k < rx; k++) {
						if(map[h][k] != 1) {
							map[h][k] = 1;
							cnt++;
						}
					}
				
			}
			
		}
		System.out.println(cnt);
	}
}
