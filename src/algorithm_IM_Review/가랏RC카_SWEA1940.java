package algorithm_IM_Review;

import java.util.Scanner;
//명령어에 따라 가속/ 감속(속도 조절)
//그 속도로 거리 이동
//감속시 그 값이 현재 속도보다 더 크면속도는 0으로 초기화
public class 가랏RC카_SWEA1940 {
	static int N, total, sp;
	static int[] speed;
	static int[] command;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			speed = new int[N];
			command = new int[N];
			for (int i = 0; i < N; i++) {
				command[i] = sc.nextInt();
				if (command[i] == 0) {
					speed[i] = 0;
				} else {
					speed[i] = sc.nextInt();
				}
			}
			total = 0;
			sp = 0;
			for (int i = 0; i < N; i++) {
				if (command[i] == 1) {
					sp += speed[i];
					total += sp;
				} else if (command[i] == 2) {
					if (speed[i] > sp) {
						sp = 0;
					} else {
						sp = sp - speed[i];
					}
					total += sp;
				} else {
					sp = sp;
					total += sp;
				}
			}
			System.out.println("#" + test_case + " " + total);
		}
	}
}