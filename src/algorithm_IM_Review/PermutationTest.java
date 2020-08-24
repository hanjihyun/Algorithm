package algorithm_IM_Review;

import java.util.Arrays;

public class PermutationTest {
	
	// 1,2,3
	// 3자리수 순열
	// 3P3 = 3!= 6
	
	static int N=3,R=3;//nPr
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		numbers = new int[R];
		isSelected = new boolean[N+1];//1,2,3
		permutation(0);//0: 0번째 위치에 넣을 숫자 뽑으러. 뽑은 숫자 갯수
	}
	

	public static void permutation(int cnt) {
		if(cnt == R) {
			System.out.println(Arrays.toString(numbers));
			return;
		}//basis. 종료파트
		
		for(int i=1; i<=N; ++i) {
			if(isSelected[i]) //이미 뽑혔다면
				continue;
			
			isSelected[i] = true;
			numbers[cnt] = i;//cnt 위치에 i값 저장
			permutation(cnt+1);//다음 위치에 넣을 값 뽑으러 보냄
			isSelected[i] = false;
		}
	}
}

