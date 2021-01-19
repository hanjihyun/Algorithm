package algorithm_2101;

import java.util.Scanner;

public class 그룹단어체커_백준1316 {
	static int[] arr;
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		int cnt = N; 
		
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			arr = new int[26];
			int[] word = new int[str.length()];
			
			for (int j = 0; j < str.length(); j++) {

				word[j] = str.charAt(j)-'a';
				
				if(j>0 && word[j]!=word[j-1] && arr[word[j]]==0) {
					arr[word[j]]++;
				}else if(j==0){
					arr[word[j]]++;
				}else if(arr[word[j]]>0 &&word[j]!=word[j-1] && j>0) {
					cnt--;
					break;
				}
			}
		}
//		for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		System.out.println(cnt);
	}

}
