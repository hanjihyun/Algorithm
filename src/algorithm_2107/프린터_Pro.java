package algorithm_2107;

import java.util.Collections;
import java.util.PriorityQueue;

public class 프린터_Pro {
	public static void main(String[] args) {
		int[] priorities = {2, 1, 3, 2};
		int location = 2;
		int answer = 0;
		PriorityQueue<Integer> prior = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int number:priorities){
            prior.offer(number);
        }
        while(!prior.isEmpty()){
            for(int i = 0; i < priorities.length; i++){
                if(prior.peek() == priorities[i]){
                    prior.poll();
                    answer++;
                    
                    if(location == i){
                        prior.clear();
                        break;
                    }
                }
            }
        }
		System.out.println(answer);
	}
}
