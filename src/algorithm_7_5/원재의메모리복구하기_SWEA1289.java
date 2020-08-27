package algorithm_7_5;

import java.util.Scanner;

public class 원재의메모리복구하기_SWEA1289 {

	public static void main(String[] args)  throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++)
		{
			
			String bit = sc.next();
			String[] arr = (bit.split(""));
			int[] memory = new int[arr.length];
			for (int i = 0; i < arr.length; i++) {
				memory[i] = Integer.parseInt(arr[i]);
			}
//			for (int i = 0; i < memory.length; i++) {
//				System.out.print(memory[i]);
//			}
			int count = 0;
			int start = 0;
			
			for(int i=0; i<memory.length; i++) {
				if(memory[i] == 1) {
					start = i;
					count++;
					break;
				}
			}
//			System.out.println(start + "//");
//			System.out.println(memory.length+".,");
			for(int i=start; i<memory.length; i++) {
				if(i==memory.length-1) {break;}
				if(memory[i] != memory[i+1]) {
					count++;
					
				}
			}
			System.out.println("#"+test_case+" "+count);
		}
		
	}

}
