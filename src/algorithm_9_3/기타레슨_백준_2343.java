package algorithm_9_3;
import java.util.Scanner;

public class 기타레슨_백준_2343 {
	static int N,M;
	static int[] blueRay;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		blueRay = new int[N];
		
		int left=0,right=0;
		int sum=0;
		
		for (int i = 0; i < N; i++) {
			blueRay[i] = sc.nextInt();
			sum += blueRay[i]; //다 더한 값
			left = Math.max(left, blueRay[i]); //그중 가장 큰 값(그래야 다 넣을 수 있다)
		}
		right = sum;
		
		int count,temp, mid;
		
		while(left<=right) {
			count = 0;
			temp = 0;
			mid = (left+right) / 2;	
			
			for (int i = 0; i < N; i++) {
				if(temp + blueRay[i] > mid) {
					temp = 0;
					count += 1;
				}
				temp += blueRay[i];
			}
			if(temp != 0) {
				count += 1; //mid보다 작아서 1을 증가시키지 못했을 경우
			}
			
			//개수가 M이하이면 right값 감소
			if(count <= M ) {
				right = mid - 1;
			}else {
				left = mid + 1;
			}
		}
		System.out.println(left);
	}
}
