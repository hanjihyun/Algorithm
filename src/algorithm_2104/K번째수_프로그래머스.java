package algorithm_2104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class K번째수_프로그래머스 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 2, 6, 3, 7, 4 };
		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		int[] ar = solution(array, commands);

	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];
		
		List list = new ArrayList<Integer>();
		for (int i = 0; i < commands.length; i++) {
			list = new ArrayList<Integer>();

			for (int k = commands[i][0] - 1; k <= commands[i][1] - 1; k++) {
				list.add(array[k]);
			}
			Collections.sort(list);

			answer[i] = (int) list.get(commands[i][2]-1);
		
		}
	
		return answer;
	}
}
