package algorithm_HW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 탑_백준2493 {

	static Stack<Integer> stack = new Stack<Integer>();
	static Stack<Integer> index = new Stack<Integer>();

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(bf.readLine());
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int[] shoot = new int[N];

		int idx = Integer.parseInt(st.nextToken());
		
		stack.push(idx);
		index.push(1);
		shoot[0] = 0;

		for (int i = 1; i < N; i++) {
			idx = Integer.parseInt(st.nextToken());
			
			while (!stack.isEmpty()) {
				if (idx < stack.peek()) {
					shoot[i] = index.peek();
					break;
				}
					stack.pop();
					index.pop();
				
			}
			if(stack.isEmpty()) {
				shoot[i] = 0;
			}
			stack.push(idx);
			index.push(i+1);
		}
		for (int i = 0; i < N; i++) {
			System.out.print(shoot[i] + " ");
		}
		  bf.close();
	}

}
