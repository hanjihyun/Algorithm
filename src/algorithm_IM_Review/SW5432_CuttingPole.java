package algorithm_IM_Review;

import java.util.Scanner;

public class SW5432_CuttingPole {
	static String src = "2\r\n" + 
			"()(((()())(())()))(())\r\n" + 
			"(((()(()()))(())()))(()())";
	
	//	#1 17	#2 24
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc = new Scanner(src);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			String s = sc.next();//한줄

			char[] ch = s.toCharArray();
			
			char front = 'x';//)나오면 앞의 글자 체크
			char current = 'y';// 지금 읽은 글자
			
			int pole = 0, tot = 0;// 원래 긴 막대수, 잘려진 막대수(조각수)			

			for (int i = 0; i < ch.length; i++) {
				current = ch[i];// 한 글자 읽고					
			
				if (current == '(') {// 막대기. 레이저 였다면 나중에 --
					pole++;

				} else if (current == ')') {//레이저나 막대기 끝
					if (front == '(') {//레이저. 바로 앞이 레이저였음
						pole--;//막대기 갯수 하나 빼주기
						tot += pole;//막대 갯수만큼 조각들이 생김
						
					}else if(front == ')') {//막대기끝
						pole--;//막대갯수 하나 줄어듬
						tot++;//남은 갯수 하나 추가
					}
				}//if
				
				front = current;// 앞글자에 옮겨놓고
			}
			System.out.println("#" + tc + " " + tot);
		}

	}
}
