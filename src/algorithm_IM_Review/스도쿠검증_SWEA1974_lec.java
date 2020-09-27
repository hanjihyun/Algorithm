package algorithm_IM_Review;
import java.util.HashSet;
import java.util.Scanner;

public class 스도쿠검증_SWEA1974_lec {
	static int[][] map;//9*9
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();//test case
		
		for (int tc = 1; tc <= T; tc++) {
			map = new int[9][9];
			
			//1.data input
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
				
			//2. 수도쿠 검증
			int result = check();//결과값
			System.out.println("#" + tc + " " + result);
		}
	}

	//map안의 데이터가 맞는 수도쿠인지 검증해서 맞으면 1, 틀리면 0을 리턴
	private static int check() {
		//Set에 넣어 저장 후 체크(중복안됨)
		HashSet<Integer> set = new HashSet<Integer>();
		
		//1. 행단위 체크(가로방향): 0,0/0,1/0,2/0,3.. 1,0/1,1/1,2...
		for (int i = 0; i < 9; i++) {//행만큼 9번 반복 
			set.clear();//이전행 처리 때 담았던 데이터를 다 삭제
			
			for (int j = 0; j < 9; j++) {
				set.add(map[i][j]);
			}
			
			if(set.size() < 9)//중복값 있었음
				return 0;
		}
		
		//2. 열단위 체크 (세로방향):0,0/1,0/2,0....
		for (int i = 0; i < 9; i++) {//열만큼 9번 반복 
			set.clear();//이전열 처리 때 담았던 데이터를 다 삭제
			
			for (int j = 0; j < 9; j++) {
				set.add(map[j][i]);
			}
			
			if(set.size() < 9)//중복값 있었음
				return 0;
		}	
		
		
		//3. 작은 4각형(9개) 체크
		for (int i = 0; i <3; i++) {
			for (int j = 0; j < 3; j++) {
				//4각형1개 ->set을 초기화
				set.clear();
				
				//작은 4각형 1개처리 i->0, 0,1,2 / i->1, 3,4,5 /i->2, 6,7,8
				for (int k = 0; k < 3; k++) {//행
					for (int l = 0; l < 3; l++) {//열
						set.add(map[i*3 + k][j*3 + l]);
					}
				}
				if(set.size() < 9)//중복값 있었음
					return 0;				
			}
		}
		
		return 1;
	}

}












