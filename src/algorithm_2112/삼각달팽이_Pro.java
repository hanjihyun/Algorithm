package algorithm_2112;

import java.util.ArrayList;
import java.util.List;

public class 삼각달팽이_Pro {
	public static void main(String[] args) {
		int n = 4;
		int[] answer = {};
		int[][] snail = new int[n][n];
		int row=-1,col=0;
		int d = 0;
		int num = 1;
		
		while(n!=0) {
			for (int i = 0; i < n; i++) {
				if(d==0) {
					snail[row+1][col] = num;
					row++;
				}
				if(d==1) {
					snail[row][col+1] = num;
					col++;
				}if(d==2) {
					snail[row-1][col-1] = num;
					row--;
					col--;
				}
				num++;
			}
			n--;
			d = (d+1)%3;
		}
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < snail.length; i++) {
			for (int j = 0; j < snail.length; j++) {
				if(snail[i][j]==0){
					break;
				}
				list.add(snail[i][j]);
			}
		}
	}
}
