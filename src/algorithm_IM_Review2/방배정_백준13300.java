package algorithm_IM_Review2;

import java.util.Scanner;

public class 방배정_백준13300 {
	static int N, K, total;
	static int gender;
	static int[] grade1, grade2, grade3, grade4, grade5, grade6;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		total=0;
		grade1 = new int[2];
		grade2 = new int[2];
		grade3 = new int[2];
		grade4 = new int[2];
		grade5 = new int[2];
		grade6 = new int[2];

		for (int i = 0; i < N; i++) {
			gender = sc.nextInt();
			int gra = sc.nextInt();
			if (gra == 1) {
				if (gender == 1) {
					grade1[1] += 1;
				} else
					grade1[0] += 1;
			} else if (gra == 2) {
				if (gender == 1) {
					grade2[1] += 1;
				} else
					grade2[0] += 1;
			} else if (gra == 3) {
				if (gender == 1) {
					grade3[1] += 1;
				} else
					grade3[0] += 1;
			} else if (gra == 4) {
				if (gender == 1) {
					grade4[1] += 1;
				} else
					grade4[0] += 1;
			} else if (gra == 5) {
				if (gender == 1) {
					grade5[1] += 1;
				} else
					grade5[0] += 1;
			} else if (gra == 6) {
				if (gender == 1) {
					grade6[1] += 1;
				} else
					grade6[0] += 1;
			}

		}
		
		if (grade1[0] != 0) {
			// 0명이 아니면?
			if(grade1[0] % K != 0) {
				total += (grade1[0] / K) + 1;
			}else {
				total += (grade1[0] / K);
			}
		}
		if(grade1[1] != 0) {
			if(grade1[1] % K != 0) {
				total += (grade1[1] / K) + 1;
			}else {
				total += (grade1[1] / K);				
			}
		}

		if (grade2[0] != 0 ) { 
			if(grade2[0] % K != 0) {
				total += (grade2[0] / K) + 1;
			}else {
				total += (grade2[0] / K);
			}
		}
		if(grade2[1] != 0) {
			if(grade2[1] % K != 0) {
				total += (grade2[1] / K) + 1;
			}else {
				total += (grade2[1] / K);				
			}
		}
		if (grade3[0] != 0) {
			if(grade3[0] % K != 0) {
				total += (grade3[0] / K) + 1;
			}else {
				total += (grade3[0] / K);
			}
		}
		 if(grade3[1] != 0) {
			if(grade3[1] % K != 0) {
				total += (grade3[1] / K) + 1;
			}else {
				total += (grade3[1] / K);				
			}
		}
		if (grade4[0] != 0 ) {
			if(grade4[0] % K != 0) {
				total += (grade4[0] / K) + 1;
			}else {
				total += (grade4[0] / K);
			}
		}
		if(grade4[1] != 0) {
			if(grade4[1] % K != 0) {
				total += (grade4[1] / K) + 1;
			}else {
				total += (grade4[1] / K);				
			}
		}
		if (grade5[0] != 0) {
			if(grade5[0] % K != 0) {
				total += (grade5[0] / K) + 1;
			}else {
				total += (grade5[0] / K);
			}
		}
		if( grade5[1] != 0) {
			if(grade5[1] % K != 0) {
				total += (grade5[1] / K) + 1;
			}else {
				total += (grade5[1] / K);				
			}
		}
		if (grade6[0] != 0 ) {
			if(grade6[0] % K != 0) {
				total += (grade6[0] / K) + 1;
			}else {
				total += (grade6[0] / K);
			}
		}
		if(grade6[1] != 0) {
			if(grade6[1] % K != 0) {
				total += (grade6[1] / K) + 1;
			}else {
				total += (grade6[1] / K);				
			}
		}
		System.out.println(total);
	}
}
