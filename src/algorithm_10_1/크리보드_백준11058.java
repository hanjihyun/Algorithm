package algorithm_10_1;

import java.util.Scanner;

public class 크리보드_백준11058 {
	static int N;
	static int[] d;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		d = new int[101];
		d[0] = 0;
		d[1] = 1;
		d[2] = 2;
		d[3] = 3;
		d[4] = 4;
		d[5] = 5;
		d[6] = 6;
		
		for (int i = 7; i <= N; ++i) { ///7부터
			for (int j = 3; i-j > 0; ++j) { //초기값 (전체 복사 붙여넣기 한세트)로 시작
//				인덱스가 1보다 커야되니까 i-j>0조건
				//다음 부턴 붙여 넣기로 +1씩
				//(j단계-1) * d[j단계 전의 값 복사(i-j)]
				d[i] = Math.max(d[i],(j-1)*d[i-j]);
			}
		}
		
		System.out.println(d[N]);
	}

}
