package algorithm_2111;

import java.util.LinkedList;
import java.util.Queue;

public class 다리를지나는트럭_Pro {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = { 7, 4, 5, 6 };
		int answer = 0;
		int sum = 0;
		int time = 0;
		Queue<Integer> qu = new LinkedList<Integer>();

		for(int i : truck_weights){
            while(true){
            	if(qu.isEmpty()) {
            		qu.offer(i);
            		sum += i;
            		time++;
            		break;
            	}else if(qu.size() == bridge_length) {
            		sum-=qu.poll();
            	}else {
            		if(weight >= sum + i) {
            			qu.offer(i);
            			sum+=i;
            			time++;
            			break;
            		}else {
            			qu.offer(0);
            			time++;
            		}
            	}
            }
		}
		answer+=time+bridge_length;
		System.out.println(answer);
	}
}
