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
			sort[i] = num;
		}
		Arrays.sort(sort);

		
		while(true) {
			int tmp=0;
			for (int i = 0; i < 4; i++) {
				if(tree[i] > tree[i+1]) {
					tmp = tree[i];
					tree[i] = tree[i+1];
					tree[i+1] = tmp;
					print();
					if(compare()) {
						break;
					}
				}
			}
			
			
		}
	}

	private static boolean compare() {
		for (int i = 0; i < 5; i++) {
			if(tree[i] != sort[i]) {
				return false;
			}
		}
		return true;
	}

	private static void print() {
		for (int i = 0; i < 5; i++) {
			System.out.print(tree[i]+" ");
		}
		System.out.println();
	}
}