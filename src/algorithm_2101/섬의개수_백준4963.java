package algorithm_2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 섬의개수_백준4963 {
	static int w,h,Ans;
	static int[][] area;
	static int[] dr = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dc = { -1, 0, 1, 1, 1, 0, -1, -1 };
	static boolean[][] v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		while(true){
			st = new StringTokenizer(br.readLine()," ");
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
//			System.out.println(w + " "+ h);
			if(w == 0 && h == 0) {
				break;
			}
			area = new int[h][w];
			v = new boolean[h][w];
			Ans = 0;
			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine()," ");
				for (int j = 0; j < w; j++) {
					area[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if(area[i][j] == 1 && !v[i][j]) {
						dfs(i,j);
						Ans++;
					}
				}
			}
		System.out.println(Ans);
		}
	}
	private static void dfs(int x, int y) {
		v[x][y] = true;
		for (int i = 0; i < 8; i++) {
			int nr = x + dr[i];
			int nc = y + dc[i];
			
			if(nr<0 || nr>=h || nc<0 || nc>=w || v[nr][nc]) {
				continue;
			}
			
			if(area[nr][nc] == 1 && !v[nr][nc]) {
				dfs(nr,nc);
			}
		}
	}
}
