package algorithm_HW;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class 암호생성기_SWEA1225 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		int T;
//		T=sc.nextInt();
		for (int test_case = 1; test_case <= 10; test_case++) {
			Queue<Integer> queue = new LinkedList<Integer>();

			int count = -1;
			int tc = sc.nextInt();
			for (int i = 0; i < 8; i++) {
				queue.offer(sc.nextInt()); // 8개 입력받기
			}

			boolean loop = true;
			while (loop) {
				int p = queue.poll() + (count--);
				if (p <= 0) {
					queue.offer(0);
					loop = false;
				}
				queue.offer(p);
				if (count == -6) {
					count = -1;
				}
			}

			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++) {
				System.out.print(queue.poll()+" ");
			}
			System.out.println();
		}
	}

}
