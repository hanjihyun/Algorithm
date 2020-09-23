package algorithm_IM_Review2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 요세푸스문제0_백준11866 {
	static int N, K, cur,cnt;
	static Queue<Integer> q = new LinkedList<Integer>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		int[] arr = new int[N];
		cur = 0;
		cnt=0;
		for (int i = 0; i < N; i++) {
			q.offer(i+1);
		}
		StringBuilder sb = new StringBuilder();
		sb.append("<");
		while(!q.isEmpty()) {
			cur = q.poll();
			if(++cnt%K!=0) {
				q.offer(cur);
			}else {
				sb.append(cur).append(", ");
			}
		}
		sb.setLength(sb.length()-2);
		sb.append(">");
		
		System.out.println(sb.toString());
	}
}
