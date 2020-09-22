package algorithm_IM_Review2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 빙고_백준2578 {
	static int[][] board;//철수 빙고판
	static int[] no; //사회자 숫자
	//상 좌 좌상 좌하 우상 우하 우 하
	static int[] dr = {-1,0,-1,1,-1,1,0,1};
	static int[] dc = {0,-1,-1,-1,1,1,1,0};
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		board = new int[5][5];
		no = new int[25];
		
		StringTokenizer st = null;
		
		for (int i = 0; i < 5; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < 5; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0,k=0; i < 5; i++) {
			st = new StringTokenizer(in.readLine()," ");
			for (int j = 0; j < 5; j++) {
				no[k++] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(play());
	}
	//빙고 게임을 진행하고 빙고가 완성된 숫자 호출 횟수 반환
	private static int play() {
		
		int cnt = 0;//빙고 라인의 누적 수
		//차례로 사회자가 숫자 부른다 --> 반복 돌려서 처리
		for (int i = 0; i < 25; i++) {
			//사회자가 부른 숫자를 빙고판에서 지운다.
			int[] pos = mark(no[i]);
			//현재 숫자로 인해 빙고라인이 몇개 형성되는지 체크
			cnt += check(pos[0],pos[1]);
			if(cnt>=3) {
				return i+1;
			}
		}
		
		//현재까지 형성된 빙고라인 수가 3개 이상일 때 게임 끝
		//-> 사회자가 숫자를 몇번째 것을 불럿는지 출력한다
		return 0;
	}
	//현재 위치의 8방을 체크하여 새롭게 추가되는 빙고라인 수를 반환
//	private static int check(int row, int col) {
//		int r=row,c=col;
//		int count = 0,res=0;
//		//상
//		while(--r>=0 && board[r][c]==0) {
//			++count;
//		}
//		//하
//		r=row;
//		c=col;
//		while(++r<5 && board[r][c]==0) {
//			++count;
//		}
//		if(count == 4) {
//			res++;
//		}
//		return res;
//	}
	private static int check(int row, int col) {
		int count = 0;
		for (int i = 0; i < 4; i++) {
			//i:0, i:7 - 현재 방향의 반대방향으로 라인 함계 체크
			if(checkLine(row, col,i)+checkLine(row,col,7-i)==4) ++count;
		}
		return count;
	}
	//현재 위치에서 지정된 방향으로만 연속성 체크하여 연속 지워진 개수 리턴
	private static int checkLine(int row, int col, int i) {
		int nr = row,nc = col,temp=0;
		while(true) {
			nr += dr[i];
			nc += dc[i];
			if(nr>=0 && nr<5 && nc>=0 && nc<5 && board[nr][nc] ==0) {
				temp++;
			}else break;
		}
		return temp;
	}
	//받은 숫자를 빙고판에서 지운다., 해당 좌표를 배열로 리턴
	private static int[] mark(int value) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] == value) {//숫자 찾으면 0으로
					board[i][j]=0;
					return new int[] {i,j};
				}
			}
		}
		return null;
	}
	

}
