package algorithm_7_4;

import java.util.Scanner;

public class 농작물수확하기_SWEA2805 {
	static int T,N;
	static int[][] crop;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			N = sc.nextInt();

			crop = new int[N][N];
			
			for(int i=0; i<N; i++) {
				String cropp = sc.next();
				String croppp[] = cropp.split("");
				for(int j=0; j<N; j++) {
					crop[i][j] = Integer.parseInt(croppp[j]);
				}
			}
			
			int top, mid, bottom;  
		    int start = 0, len = N;  
		    int total = 0;  
		  
		    top = bottom = mid = (N == 1 ? 0 : N / 2);  
		  
		    while (len > 0)  
		    {  
		        if (top == bottom)  
		        {  
		            for (int i = start; i < start + len; i++)  
		            	total += crop[top][i];  
		        }  
		        else  
		        {  
		            for (int i = start; i < start + len; i++)  
		            	total += (crop[top][i] + crop[bottom][i]);  
		        }  
		  
		        top++;  
		        bottom--;  
		        start++;  
		        len -= 2;  
		    }  
			
			System.out.println("#"+test_case + " " + total);
		}

	}

}
