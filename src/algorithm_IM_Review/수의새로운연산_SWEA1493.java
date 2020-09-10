package algorithm_IM_Review;

import java.util.Scanner;

public class 수의새로운연산_SWEA1493 {
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		map = new int[301][301];
		int num=1;
		
		for (int i = 0; i <= 300; i++) {
			for (int j = i; j >= 0; j--) {
				map[i-j][j] = num++;
			}
			
		}
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result = 0;
			int p = sc.nextInt();
			int q = sc.nextInt();
			int px=0,py =0,qx=0,qy=0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == p) {
						px = i;
						py = j;
					}
					if(map[i][j] == q) {
						qx = i;
						qy = j;
					}
					
				}
			}
			
			int resultX = px+qx;
			int resultY = py+qy;
			result = map[resultX+1][resultY+1];
			System.out.println("#"+test_case+" "+result);
		
		}
	}
}