package algorithm_2106;

public class 최대공약수와최소공배수_Pro {
	public static void main(String[] args) {
		int n = 3;
		int m = 12;
		int[] answer = new int[2];
		
		int g = gcd(n,m);
		int l = lcm(n,m);
		answer[0] = g;
		answer[1] = l;
		System.out.println(g);
		System.out.println(l);
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
