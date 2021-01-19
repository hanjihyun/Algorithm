package algorithm_2101_03;

import java.util.Scanner;

public class 방번호_백준1475 {
	static int[] arr;
	static int Ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		arr = new int[10];
		String str = sc.next();
		int[] N = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			N[i] = str.charAt(i)-'0';
			if(N[i] == 6 || N[i] ==9) {
				if(arr[6] < arr[9]) {
					arr[6]++;
				}else if(arr[6] > arr[9]) {
					arr[9]++;
				}else {
					arr[N[i]]++;
				}
			}else {
				arr[N[i]]++;
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		Ans=0;
		int max = arr[0];
//		System.out.println("max " + max);
		
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]>= max) {
				max=arr[i];
				Ans = arr[i];
			}
		}
		System.out.println(Ans);
	}

}
