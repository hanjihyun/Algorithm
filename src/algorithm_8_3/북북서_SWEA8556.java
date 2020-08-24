package algorithm_8_3;

import java.util.Scanner;

public class 북북서_SWEA8556 {
	static char[] arr;
	static int westA = 90, northA = 0, cnt,index;
	static double result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String str = sc.next();
			arr = new char[str.length()];
			for (int i = 0; i < str.length(); i++) {
				arr[i] = str.charAt(i);
			}

//			for (int i = 0; i < arr.length; i++) {
//				System.out.print(arr[i]);
//			}
//			System.out.println();
			result = 0;
			cnt = 0;
			index = arr.length-1;
			
			for (int index = arr.length - 1; index >= 0; index--) {
				if (arr[index] == 't') {
					if(cnt == 0) {
						result = westA;
					}else {
						result = result + (90/Math.pow(2, cnt));
					}
					index -= 3;
					cnt++;
				} else if (arr[index] == 'h') {
					if(cnt == 0) {
						result = northA;
					}else {
						result = result - (90/Math.pow(2, cnt));
						
					}
					index -= 4;
					cnt++;
				}
			}
		
			System.out.println("#" + test_case + " " +result);
		}
	}
}
