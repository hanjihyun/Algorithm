package algorithm_2201;

import java.util.HashSet;

public class 방문길이_Pro {

	public static void main(String[] args) {
		String dirs = "ULURRDLLU";
		int answer = 0;

		HashSet<String> hash = new HashSet<String>();
		int curX = 0;
		int curY = 0;

		for (int i = 0; i < dirs.length(); i++) {
			int nextX = curX;
			int nextY = curY;
			String road = ""; // 경로 저장할 문자열
			if (dirs.charAt(i) == 'U') {
				nextY++;
				road += curX;
				road += curY;
				road += nextX;
				road += nextY;
			} else if (dirs.charAt(i) == 'D') {
				nextY--;
				road += nextX;
				road += nextY;
				road += curX;
				road += curY;
			} else if (dirs.charAt(i) == 'R') {
				nextX++;
				road += curX;
				road += curY;
				road += nextX;
				road += nextY;
			} else if (dirs.charAt(i) == 'L') {
				nextX--;
				road += nextX;
				road += nextY;
				road += curX;
				road += curY;
			}
			if (nextX < -5 || nextY < -5 || nextX > 5 || nextY > 5)
				continue;
			
			hash.add(road);
			curX = nextX;
			curY = nextY;
		}
		answer = hash.size();
		System.out.println(answer);
	}
}
