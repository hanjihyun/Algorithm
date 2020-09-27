package algorithm_IM_Review2;

import java.util.Scanner;

public class 스위치켜고끄기_백준1244 {
	static int[] swit;
	static int N,student;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		swit = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			swit[i] = sc.nextInt();
		}
		
		student = sc.nextInt();
		for (int i = 0; i < student; i++) {
			int gender = sc.nextInt();
			int num = sc.nextInt();
			
			if(gender == 1) {
				
				for (int j = 1; j <= N; j++) {
					if(j%num == 0) {
						swit[j] = swit[j]^1;
					}
				}
			}else {
				if(num == 1) {
					swit[num] = swit[num]^1;
				}else if(num == N) {
					swit[num] = swit[num]^1;
				}else {
					int idx = 1;
					while(num-idx>0 && num+idx<=N) {
						if(swit[num-idx] == swit[num+idx]) {
							swit[num-idx]=swit[num-idx]^1;
							swit[num+idx]=swit[num+idx]^1;
							idx++;
						}else {
							break;
						}
					}
					swit[num]=swit[num]^1;
				}
				
			}
		}
		for (int i = 1; i <= N; i++) {
			System.out.print(swit[i]);
			if(i!=N) {
				System.out.print(" ");
			}
			if(i%20 == 0) {
				System.out.println();
			}
		}
	}
}
