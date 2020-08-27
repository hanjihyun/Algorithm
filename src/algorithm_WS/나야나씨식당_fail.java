package algorithm_WS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 나야나씨식당_fail {
	static int R, C, cnt;
	static char[][] gas;
	static boolean[][] v;
	static int[] dr = { -1, 0, 1 };
	static int[] dc = { 1, 1, 1 };
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		gas = new char[R][];
		v = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			gas[i] = in.readLine().toCharArray();
		}
	
		makePipe();
		System.out.println(cnt);
	}

	private static void makePipe() {
		for (int r = 0; r < R; r++) {
			v[r][0] = true;
			go(r,0);
		}
	}
	
	private static boolean go(int x, int y) {
//		v[x][y] = true;
		if(y == C-1) {//나야나씨 식당까지 파이프가 연결된 상황
			++cnt;
			return true; //성공했다는 결과를 리턴
		}
		int nr = y+1;
		int nc = y+1;
		
//	현 위치에서 오른쪽 위, 오른쪽, 오른쪽 아래 순서적으로 파이프 연결 시도
		for (int k= 0; k < 3; k++) {
			nr = x + dr[k];
			nc = y + dc[k];
			
			if(nr<0 || nr>=R || v[nr][nc] || gas[nr][nc] == 'x') {
				continue;
			}
			v[nr][nc] = true; //파이프 놓기
			if(go(nr,nc)) { //다음 칸으로 이동 후 진행 결과가 끝까지 연결이 가능했다면
				return true; //현위치에서 다른 방향으로 파이프 놓기 시도를 중단하고 이전 위치로 돌아감
			}
			///////////////////////////////////////////
			v[nr][nc]=false; //파이프 실패시 흔적 돌리기??
			//이 한줄 때문에 시간 초과!!!!!!!!!!!!!!!
			///////////////////////////////////////////
		}
		return false;
	}
}
