package algorithm_2111;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class 기능개발_Pro {
	public static void main(String[] args) {
		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

	
		
		Queue<Integer> qu = new LinkedList<Integer>();
		
		for (int i = 0; i < progresses.length; i++) {
			qu.add(
					(100-progresses[i])%speeds[i] == 0?
					(100-progresses[i])/speeds[i]:
					(100-progresses[i])/speeds[i]+1
				  );
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		int pre = qu.poll();
		int num = 1;
		
		while(!qu.isEmpty()) {
			int cur = qu.poll();
			if(pre >= cur) {
				num++;
			}else {
				list.add(num);
				num=1;
				pre = cur;
			}
		}
		list.add(num);
		int[] answer = new int[list.size()];
		
		for (int i = 0; i < list.size(); i++) {
			answer[i] = list.get(i);
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
