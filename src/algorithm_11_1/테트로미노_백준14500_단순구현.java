package algorithm_11_1;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class 테트로미노_백준14500_단순구현 {
	static int N,M,max;
	static int[][] map;
	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
//		map = new int[N][M];
		map = new int[N+6][M+6]; 
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		for(int i=0; i<N+3; i++){
			for(int j=0; j<M+3; j++){
				solve(i, j); 
			}
		}
		System.out.println(max);
	}
	private static void solve(int y, int x) {
		int sum=0;
		// 1-1. 직선 case (세로 놓기)
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y+2][x];
		sum += map[y+3][x];
		if(max<sum){
			max = sum;
		}
		// 1-2 직선 case (가로 놓기)
		sum=0;
		sum += map[y][x];
		sum += map[y][x+1];
		sum += map[y][x+2];
		sum += map[y][x+3];
		if(max<sum){
			max = sum;
		}
		// 2. 네모 case
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y+1][x+1];
		sum += map[y][x+1];
		if(max<sum){
			max = sum;
		}
		// 3-1. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y+2][x];
		sum += map[y+2][x+1];
		if(max<sum){
			max = sum;
		}
		// 3-1-2. ㄴ case // 왼상단시작 오른 하단 종료. (반시계방향)의 대칭.
		sum=0;
		sum += map[y][x+1];
		sum += map[y+1][x+1];
		sum += map[y+2][x+1];
		sum += map[y+2][x];
		if(max<sum){
			max = sum;
		}
		// 3-2. ㄴ case // 왼하단시작 오른 상단 종료.
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y][x+1];
		sum += map[y][x+2];
		if(max<sum){
			max = sum;
		}
		// 3-2-2. ㄴ case // 왼하단시작 오른 상단 종료. 의 대
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x+2];
		sum += map[y][x+1];
		sum += map[y][x+2];
		if(max<sum){
			max = sum;
		}
		// 3-3. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향)
		sum=0;
		sum += map[y][x];
		sum += map[y][x+1];
		sum += map[y+1][x+1];
		sum += map[y+2][x+1];
		if(max<sum){
			max = sum;
		}
		// 3-3-2. ㄴ case // 왼상단시작 오른 하단 종료 (시계방향) 의 대칭
		sum=0;
		sum += map[y][x];
		sum += map[y][x+1];
		sum += map[y+1][x];
		sum += map[y+2][x];
		if(max<sum){
			max = sum;
		}
		// 3-4. ㄴ case // 오른 상단시작 왼 하단 종료
		sum=0;
		sum += map[y][x+2];
		sum += map[y+1][x+2];
		sum += map[y+1][x+1];
		sum += map[y+1][x];
		if(max<sum){
			max = sum;
		}
		// 3-4-2. ㄴ case // 오른 상단시작 왼 하단 종료 의 대칭
		sum=0;
		sum += map[y+1][x+2];
		sum += map[y+1][x+1];
		sum += map[y+1][x];
		sum += map[y][x];
		if(max<sum){
			max = sum;
		}
		// 4-1. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄴㄱ)
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y+1][x+1];
		sum += map[y+2][x+1];
		if(max<sum){
			max = sum;
		}
		// 4-2. ㄴㄱ case // 오른 상단시작 하단 종료.
		sum=0;
		sum += map[y][x+2];
		sum += map[y][x+1];
		sum += map[y+1][x+1];
		sum += map[y+1][x];
		if(max<sum){
			max = sum;
		}
		// 4-3. ㄴㄱ case // 왼하단시작 오른 상단 종료.
		sum=0;
		sum += map[y+2][x];
		sum += map[y+1][x];
		sum += map[y+1][x+1];
		sum += map[y][x+1];
		if(max<sum){
			max = sum;
		}
		// 4-4. ㄴㄱ case // 왼상단시작 오른 하단 종료. (ㄱㄴ꼴)
		sum=0;
		sum += map[y][x];
		sum += map[y][x+1];
		sum += map[y+1][x+1];
		sum += map[y+1][x+2];
		if(max<sum){
			max = sum;
		}
		// 5-1. ㅗ case // ㅜ
		sum=0;
		sum += map[y][x];
		sum += map[y][x+1];
		sum += map[y][x+2];
		sum += map[y+1][x+1];
		if(max<sum){
			max = sum;
		}
		// 5-2. ㅗ case // ㅓ
		sum=0;
		sum += map[y][x+1];
		sum += map[y+1][x+1];
		sum += map[y+2][x+1];
		sum += map[y+1][x];
		if(max<sum){
			max = sum;
		}
		// 5-3. ㅗ case // ㅗ
		sum=0;
		sum += map[y+1][x];
		sum += map[y+1][x+1];
		sum += map[y+1][x+2];
		sum += map[y][x+1];
		if(max<sum){
			max = sum;
		}
		// 5-4. ㅗ case // ㅏ
		sum=0;
		sum += map[y][x];
		sum += map[y+1][x];
		sum += map[y+2][x];
		sum += map[y+1][x+1];
		if(max<sum){
			max = sum;
		}
		
	}
}
