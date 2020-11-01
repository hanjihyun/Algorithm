package algorithm_10_5;

import java.util.Scanner;

public class 활주로건설{
	static int N,X,Ans;
	static int[][] road;
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			N = sc.nextInt();
			X = sc.nextInt();
			
			road = new int[N][N];
			Ans = 0; //건설 가능한 활주로의 겨우의 수
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					road[i][j] = sc.nextInt();
				}
			}
			process();
			System.out.println("#"+test_case+" "+Ans);
		}
	}
	private static void process() {
		for (int i = 0; i < N; i++) {
			if(calR(i)) ++Ans;
			if(calC(i)) ++Ans;
		}
	}
	//행
	private static boolean calR(int i) {
		int beforeHeight, size;
		beforeHeight = road[i][0];
		size = 1;
		for (int j = 1; j < N; j++) {
			//높이가 같을 때
			if(beforeHeight == road[i][j]) {
				++size;
			}else if(beforeHeight+1 == road[i][j]) {
				//이전칸보다 1 높은 경우 - 오르막 경사로 설치 가능한지 체크
				if(size<X) return false;
				beforeHeight++;
				size = 1;
			}else if (beforeHeight-1 == road[i][j]) {
				//이전칸보다 1 낮은 경우 - 내리막 경사로 설치 가능한지 체크
				int count = 0;
				for (int k = j; k < N; k++) {
					if(road[i][k] != beforeHeight-1) break;
					count++; //이전칸의 높이와 1차이 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if(count < X) return false;
				j+=X-1;//경사로 다음칸의 위치로 제어
				beforeHeight--;
				size=0;
			}else {
				//높이 2이상 차이 나는 경우
				return false;
			}
		}
		return true;
	}
	//열
	private static boolean calC(int i) {
		int beforeHeight, size;
		beforeHeight = road[0][i];
		size = 1;
		for (int j = 1; j < N; j++) { //행첨자
			//높이가 같을 때
			if(beforeHeight == road[j][i]) {
				++size;
			}else if(beforeHeight+1 == road[j][i]) {
				//이전칸보다 1 높은 경우 - 오르막 경사로 설치 가능한지 체크
				if(size<X) return false;
				beforeHeight++;
				size = 1;
			}else if (beforeHeight-1 == road[j][i]) {
				//이전칸보다 1 낮은 경우 - 내리막 경사로 설치 가능한지 체크
				int count = 0;
				for (int k = j; k < N; k++) {
					if(road[k][i] != beforeHeight-1) break;
					count++; //이전칸의 높이와 1차이 낮은 연속된 평탄화 지형의 길이를 카운트
				}
				if(count < X) return false;
				j+=X-1;//경사로 다음칸의 위치로 제어
				beforeHeight--;
				size=0;
			}else {
				//높이 2이상 차이 나는 경우
				return false;
			}
		}
		return true;
	}
}