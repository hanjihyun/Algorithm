package algorithm_IM_Review;

import java.util.Scanner;

public class 스도쿠검증_SWEA1974 {
	static int map[][];
	static int Ans;
	static boolean row,col,room;
	static int[] num;
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	

		for(int test_case = 1; test_case <= T; test_case++)
		{
			map = new int[9][9];
			num = new int[10];
			Ans = 0;
			row = false;
			col = false;
			room = false;
			for (int i = 0; i < 9; i++) {
				num = new int[10];
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
					num[map[i][j]] = 1;
					
				}
				for (int k = 1; k <= 9; k++) {
					if(num[k] != 1) {
						row = true;
						break;
					}
				}
			}
			
			for (int i = 0; i < 9; i++) {
				num = new int[10];
				for (int j = 0; j < 9; j++) {
					num[map[j][i]] = 1;	
				}
				for (int k = 1; k <= 9; k++) {
					if(num[k] != 1) {
						col = true;
						break;
					}
				}
			}
		
			for (int i = 0; i < 3; i++) {
				
				for (int j = 0; j < 3; j++) {
					num = new int[10];
					for (int k = 0; k < 3; k++) {
						for (int l = 0; l < 3; l++) {
							num[map[i*3+k][j*3+l]] = 1;
						}
					}
					for (int k = 1; k <= 9; k++) {
						if(num[k] != 1) {
							room = true;
							break;
						}
					}
				}
				
			}
			
			if(!row && !col && !room) {
				Ans = 1;
			}else {
				Ans = 0;
			}
//			System.out.println(test_case+" " +row + " " + col+" "+ room);
			System.out.println("#"+test_case+" "+Ans);
		}
	}
}