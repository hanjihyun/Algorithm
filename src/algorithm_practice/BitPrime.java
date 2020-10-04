package algorithm_practice;

import java.util.Arrays;

public class BitPrime {
	public static int LAST_NUM = 265 * 4 -1;
	public static char sieve[] = new char[(LAST_NUM + 7)/8+1];
	
	public static void main(String[] args) {
		eratosthenes();
		
		for (int i = 2; i < LAST_NUM; i++) {
			if(isPrime(i)) {
				System.out.print(i+" ");
			}
		}
	}

	private static void eratosthenes() {
		Arrays.fill(sieve, (char)255);
		setNotPrime(0);
		setNotPrime(1);
		for (int i = 2; i <= (int)Math.sqrt(LAST_NUM); i++) {
			if (isPrime(i)) {
				for (int j = i*i; j <= LAST_NUM; j+=i) {
					setNotPrime(j);
				}
			}
		}
	}

	private static void setNotPrime(int k) {
		sieve[k>>>3] &= ~(1 << (k&7));
	}

	private static boolean isPrime(int k) {
		return (sieve[k >>> 3] & (1 << (k&7))) == 0? false : true;
	}

	
}