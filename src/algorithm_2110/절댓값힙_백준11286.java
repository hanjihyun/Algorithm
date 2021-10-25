
package algorithm_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class 절댓값힙_백준11286 {
	static int N;
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->
	Math.abs(o1) == Math.abs(o2) ? 
			Integer.compare(o1,o2):Integer.compare(Math.abs(o1),Math.abs(o2))
			);

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());
			if (n != 0) {
				pq.add(n);
			} else if (n == 0) {
				if (!pq.isEmpty()) {
					System.out.println(pq.poll());
				} else {
					System.out.println(0);
				}
			}
		}
	}
}
