package algorithm_11_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 경비원_백준2564 {
	static int M,N,S;
	static ArrayList<Point> list = new ArrayList<Point>();
	
	static class Point{
		int d,s;

		protected Point(int d, int s) {
			super();
			this.d = d;
			this.s = s;
		}

		
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); //가로 column
		N = Integer.parseInt(st.nextToken()); //세로 row
 		S = Integer.parseInt(br.readLine());
		for (int i = 0; i < S; i++) {
			st = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			list.add(new Point(d,s));
			
		}
		st = new StringTokenizer(br.readLine());
		int d = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		Point start = new Point(d, s);

		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			// 시계방향
			Point p = list.get(i);
			if(start.d == 1) {
				switch (p.d) {
				case 1:
					sum+=Math.abs(p.s - start.s);
					break;
				case 2:
					sum += Math.min(start.s + N + p.s, M-start.s + N + M-p.s);		
					break;
				case 3:
					sum += Math.min(start.s +p.s, M-start.s + N + M + N-p.s);		
					break;
				case 4:
					sum += Math.min((M-start.s) + p.s, start.s+ N + M + N-p.s);		
					break;
				default:
					break;
				}
			}else if(start.d == 2) {
				switch (p.d) {
				case 1:
					sum += Math.min(start.s + N + p.s, M-start.s + N + M-p.s);		
					break;
				case 2:
					sum+=Math.abs(p.s - start.s);
					break;
				case 3:
					sum += Math.min(start.s + N - p.s, M-start.s+ N + M+p.s);		
					break;
				case 4:
					sum += Math.min(start.s + N + M + p.s, M - start.s+ N - p.s);		
					break;
				default:
					break;
				}
			}else if(start.d == 3) {
				switch (p.d) {
				case 1:
					sum += Math.min(start.s + p.s, N-start.s + M + N + M-p.s);		
					break;
				case 2:
					sum += Math.min(start.s + M + N + M - p.s, N-start.s + p.s);		
					break;
				case 3:
					sum+=Math.abs(p.s - start.s);
					break;
				case 4:
					sum += Math.min(start.s + M + p.s, N - start.s+ M + N - p.s);		
					break;
				default:
					break;
				}
			}else if(start.d == 4) {
				switch (p.d) {
				case 1:
					sum += Math.min(N - start.s + M + N + p.s, start.s + M-p.s);		
					break;
				case 2:
					sum += Math.min(N - start.s + M - p.s, start.s + M + N + p.s);		
					break;
				case 3:
					sum += Math.min(start.s + M + p.s, N - start.s+ M + N - p.s);		
					break;
				case 4:
					sum+=Math.abs(p.s - start.s);
					break;
				default:
					break;
				}
			}
		}
		System.out.println(sum);
	}
}
