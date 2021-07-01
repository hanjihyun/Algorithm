package algorithm_2107;

public class 내적_Pro {
	public static void main(String[] args) {
		int[] a = { -1,0,1};
		int[] b = { 1,0,-1 };
		int answer = 0;

		for (int i = 0; i < a.length; i++) {
			answer += a[i] * b[i];
		}
		
		System.out.println(answer);
	}
}
