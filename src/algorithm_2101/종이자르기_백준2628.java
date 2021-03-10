package algorithm_2101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 종이자르기_백준2628 {
	static int R,C,N;
	static List<Integer> row,row1,col,col1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		N = sc.nextInt();
		
		row = new ArrayList<>();
		col = new ArrayList<>();
		row1 = new ArrayList<>();
		col1 = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			int m = sc.nextInt();
			int y = sc.nextInt();
			
			if(m == 0) {
				row.add(y);
			}else {
				col.add(y);
			}
		}
		row.add(C);
		col.add(R);
		
		Collections.sort(row);
		Collections.sort(col);
		
		for (int i = 0; i < row.size(); i++) {
			if(i==0) {
				row1.add(row.get(0));
			}else {
				row1.add(row.get(i)-row.get(i-1));
			}
		}
		for (int i = 0; i < col.size(); i++) {
			if(i==0) {
				col1.add(col.get(0));
			}else {
				col1.add(col.get(i)-col.get(i-1));
			}
		}
		int max = 0;
		for (int i = 0; i < row1.size(); i++) {
			for (int j = 0; j < col1.size(); j++) {
				int area = row1.get(i) * col1.get(j);
				if(max < area) {
					max = area;
				}
			}
		}
		System.out.println(max);
	}
}
