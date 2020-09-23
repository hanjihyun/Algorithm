package algorithm_IM_Review2;

import java.util.Scanner;

public class 딱지놀이_백준14696 {
	static int N;
	static int[] A,B;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			A = new int[a];
			int[] cntA = new int[5];
			for (int j = 0; j < a; j++) {
				A[j] = sc.nextInt();
				if(A[j]==1) {
					cntA[1]++;
				}else if(A[j]==2) {
					cntA[2]++;
				}else if(A[j]==3) {
					cntA[3]++;
				}else if(A[j]==4) {
					cntA[4]++;
				}
			}
//			for (int j = 0; j < cntA.length; j++) {
//				System.out.print(cntA[j]);
//			}
			int b = sc.nextInt();
			int[] cntB = new int[5];
			B = new int[b];
			for (int j = 0; j < b; j++) {
				B[j] = sc.nextInt();
				if(B[j]==1) {
					cntB[1]++;
				}else if(B[j]==2) {
					cntB[2]++;
				}else if(B[j]==3) {
					cntB[3]++;
				}else if(B[j]==4) {
					cntB[4]++;
				}
			}	
//			for (int j = 0; j < cntA.length; j++) {
//				System.out.print(cntB[j]);
//			}
			if(cntA[4] > cntB[4]) {
				System.out.println("A");
			}else if(cntA[4] < cntB[4]){
				System.out.println("B");
			}else {
				if(cntA[3] > cntB[3]) {
					System.out.println("A");
				}else if(cntA[3] < cntB[3]){
					System.out.println("B");
				}else {
					if(cntA[2] > cntB[2]) {
						System.out.println("A");
					}else if(cntA[2] < cntB[2]){
						System.out.println("B");
					}else {
						if(cntA[1] > cntB[1]) {
							System.out.println("A");
						}else if(cntA[1] < cntB[1]){
							System.out.println("B");
						}else {
							System.out.println("D");
						}
					}
				}
			}
		}
	}
}
