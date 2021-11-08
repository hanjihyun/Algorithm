package algorithm_2111;

public class 멀쩡한사각형_Pro {
	public static void main(String[] args) {
		int w = 8;
		int h = 12;
		long wei = w;
		long hei = h;
		long answer = wei * hei;
		long g = gcd(wei, hei);
		wei /= g;
		hei /= g;
		answer = answer - g * (wei + hei - 1);
		System.out.println(answer);
	}

	static long gcd(long a, long b) { // 최대공약수

		long x = Math.max(a, b);
		long y = Math.min(a, b);
		while (y != 0) {
			long r = x % y;
			x = y;
			y = r;
		}
		return x;
	}
}
