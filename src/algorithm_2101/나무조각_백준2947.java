package algorithm_2101;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무조각_백준2947 {
	static int[] tree;
	static int[] sort;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
	
			
		tree = new int[5];
		sort = new int[5];
		
		st = new StringTokenizer(br.readLine()," ");
		for (int i = 0; i < 5; i++) {
			int num =  Integer.parseInt(st.nextToken());
			tree[i] = num;
		}


		
		for (int i = 4; i >= 0; i--) {
			
			for (int j = 0; j < i; j++) {
				int tmp=0;
				if(tree[j] > tree[j+1]) {
					tmp = tree[j];
					tree[j] = tree[j+1];
					tree[j+1] = tmp;
					System.out.print(tree[0] + " " + tree[1] + " " + tree[2] + " " + tree[3] + " " + tree[4]);
					System.out.println();
				}
				
			}
		
			
		}
	}

}