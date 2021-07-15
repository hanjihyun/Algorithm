package algorithm_2107;

public class N개의최소공배수_Pro {
	public static void main(String[] args) {
		int[] arr = { 2, 6, 8, 14 };
		int answer = 1;
		
		for (int i = 0; i < arr.length; i++) {
			answer = lcm(answer,arr[i]);
			System.out.println(answer);
		}
		System.out.println(answer);
	}
	static int gcd(int a, int b){ // 최대공약수
		while(b!=0){
			int r = a%b;
			a= b;
			b= r;
		}
		return a;
	}
	static int lcm(int a, int b){ // 최소 공배수
		// 0이 아닌 두 수의 곱 / 두 수의 최대공약수
	    return a * b / gcd(a,b);
	}
}