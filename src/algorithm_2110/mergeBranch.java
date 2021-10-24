package algorithm_2110;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;


public class nhn1_mergeBranch {
	static int N, start;

	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	static List<Integer> oper;
	static int[] arr = new int[100001];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		start = 1;
		oper = new ArrayList<>();
		oper.add(start);
		for (int i = 1; i <= N; i++) {
			String str = sc.next();

			if (str.equals("branch")) {
				if (!pq.isEmpty()) {
					oper.add(pq.poll());
				} else {
					oper.add(start + i);
				}
			} else if (str.equals("merge")) {
				int c = sc.nextInt();

				for (int j = 0; j < oper.size(); j++) {
					if (oper.get(j) == c) {
						pq.add(oper.get(j));
						oper.remove(j);
					}
				}
			}
		}
		for (int i = 0; i < oper.size(); i++) {
			System.out.println(oper.get(i));
		}
	}
}
