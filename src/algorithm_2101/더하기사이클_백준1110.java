package algorithm_2101;

import java.util.Scanner;

public class 더하기사이클_백준1110 {
	static int N,res,cnt,emp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		res = N;
		cnt = 0;
		emp = 100;
		
		
		while(N != emp) {
			
			emp = res/10 + res-((res/10)*10); // 26 = 2 + 6 = 8, 
//			System.out.println(emp);
			
			emp = (res-((res/10)*10))*10 + (emp%10); // 60 + 8 == 68
			res = emp;
			cnt++;

		}
	System.out.println(cnt);	
	}

}
