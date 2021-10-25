package algorithm_2110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class 가운데를말해요_백준1655 {
	static int N;
	static PriorityQueue<Integer> maxPq = new PriorityQueue<Integer>(Collections.reverseOrder());
	static PriorityQueue<Integer> minPq = new PriorityQueue<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int n = Integer.parseInt(br.readLine());

			if (maxPq.size() == minPq.size()) {
				maxPq.add(n);

				if (!minPq.isEmpty() && maxPq.peek() > minPq.peek()) {
					minPq.add(maxPq.poll());
					maxPq.add(minPq.poll());
				}
			} else {
				minPq.add(n);
				if (maxPq.peek() > minPq.peek()) {
					minPq.add(maxPq.poll());
					maxPq.add(minPq.poll());
				}
			}
			System.out.println(maxPq.peek());
		}
	}
}
