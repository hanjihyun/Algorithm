package algorithm_2110;


import java.util.PriorityQueue;

public class 더맵게_Pro {
	public static void main(String[] args) {
		int[] scoville = {1, 2, 3, 9, 10, 12};
		int K = 7;
		int answer = 0;
		int make = 0;

		   PriorityQueue<Integer> heap = new PriorityQueue<>();
	
		   for (int i = 0; i < scoville.length; i++) {
			   heap.offer(scoville[i]);
		}
		   
		   while(heap.peek()<K) {
			   if(heap.size()<2) {answer = -1;break;}
			   int f1 = heap.poll();
		       int f2 = heap.poll();
			 
			   make = f1 + (f2*2);
			   heap.offer(make);
			   answer++;
		   }


		System.out.println(answer);
	}
}
