package algorithm_2103;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class 덱_백준10866 {
	static int N;
	static Deque<Integer> deq;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder answer = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		deq = new ArrayDeque<Integer>();

		for (int i = 0; i < N; i++) {
			String[] command = br.readLine().split(" ");
			switch (command[0]) {
			case "push_front":
				deq.offerFirst(Integer.parseInt(command[1]));
				break;
			case "push_back":
				deq.offerLast(Integer.parseInt(command[1]));
				break;
			case "pop_front":
				if (deq.size() > 0) {
					answer.append(deq.pollFirst()).append("\n");
				} else {
					answer.append("-1").append("\n");
				}
				break;
			case "pop_back":
				if (deq.size() > 0) {
					answer.append(deq.pollLast()).append("\n");
				} else {
					answer.append("-1").append("\n");
				}
				break;
			case "size":
				answer.append(deq.size()).append("\n");
				break;
			case "empty":
				if (deq.isEmpty()) {
					answer.append("1").append("\n");
				} else {
					 answer.append("0").append("\n");
				}
				break;
			case "front":
				if (deq.size() > 0) {
					answer.append(deq.peekFirst()).append("\n");
				} else {
					answer.append("-1").append("\n");
				}
				break;

			case "back":
				if (deq.size() > 0) {
					answer.append(deq.peekLast()).append("\n");
				} else {
					answer.append("-1").append("\n");
				}
				break;
			}
		}  
		bw.write(answer.toString()); 
		br.close();
        bw.flush();
        bw.close();
	}
}
