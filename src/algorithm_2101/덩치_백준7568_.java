package algorithm_2101;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class 덩치_백준7568_ {
	static int[][] arr;
	static int N;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		arr = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
	
		for (int i = 0; i < N; i++) {
			int index = 1;
			for (int j = 0; j < N; j++) {
				if(i == j) continue;
				if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
					index++;
				}
			}
			System.out.print(index+" ");
		}
		
	}

}
