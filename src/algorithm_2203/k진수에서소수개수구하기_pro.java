package algorithm_2203;

public class k진수에서소수개수구하기_pro {
	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		int answer = 0;
		
		String num = "";
		while (n > 0) {
			num = n % k + num;
			n = n / k;
		}

		System.out.println(num);
		int i, j;
		for (i = 0; i < num.length(); i = j) {
			for (j = i + 1; j < num.length() && num.charAt(j) != '0'; j++)
				;
			if (isPrime(Long.parseLong(num.substring(i, j))))
				answer++;

		}
		System.out.println(answer);
	}

	private static boolean isPrime(long n) {
		if (n <= 1)
			return false;
		else if (n == 2)
			return true;
		for (int i = 2; i <= Math.sqrt(n); i++)
			if (n % i == 0)
				return false;
		return true;
	}
}
