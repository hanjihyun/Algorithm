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
			//test_case 반복을 위한 초기화 필수
			row = false;
			col = false;
			room = false;
			for (int i = 0; i < 9; i++) {
				//num배열 재활용을 위한 초기화
				num = new int[10];
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
					//1. 행단위 체크(가로방향): 0,0/0,1/0,2/0,3.. 1,0/1,1/1,2...
					num[map[i][j]] = 1;
					
				}
				//1~9번 으로 num배열은 10칸으로 잡고 인덱스 1부터 사용
				for (int k = 1; k <= 9; k++) {
					//num배열에 1이 아닌 숫자가 있으면 1-9 중에 없는 숫자가 있다는 뜻!
					if(num[k] != 1) {
						row = true;
						break;
					}
				}
			}
			//2. 열단위 체크 (세로방향):0,0/1,0/2,0....
			for (int i = 0; i < 9; i++) {
				//num배열 재활용을 위한 초기화
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
			//3. 작은 4각형(9개) 체크
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					//num배열 재활용을 위한 초기화
					num = new int[10];
					//작은 4각형 1개처리 i->0, 0,1,2 / i->1, 3,4,5 /i->2, 6,7,8
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