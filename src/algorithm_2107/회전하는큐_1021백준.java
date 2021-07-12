package algorithm_2107;

import java.util.LinkedList;
import java.util.Scanner;

public class 회전하는큐_1021백준 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		LinkedList<Integer> list = new LinkedList<>();
				
		for (int i = 0; i < N; i++) {
			list.add(i+1);
		}
		
		int ans = 0;
		
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			
			if(list.indexOf(num) <= list.size()/2 ) {
				while(num != list.getFirst()) {
					list.add(list.removeFirst());
					ans++;
				}
			}else {
				while(num != list.getFirst()) {
					list.addFirst(list.removeLast());
					ans++;
				}
			}
			list.removeFirst();
		}
		System.out.println(ans);
	}
}
