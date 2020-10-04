package algorithm_practice;

public class Prime {
	
	public static void main(String[] args) {
		primeDivide(22);
		printPrime();
		printPerfect(6,12);
	}
	public static void printDivide(int n){
		if(n==1){
			System.out.println("[1]");
		}else{
			System.out.printf("[1,");
			for (int i = 2; i <n; i++) {
				if(n%i==0){
					System.out.printf("%d,",i);
				}
			}
			System.out.println(n+"]");
		}
	}
	//소인수 분해
	public static void primeDivide(int n) {
		int a = 2;
		while(n!=1) {
			if(n%a==0) { //나눠 떨어지면
				if(n/a == 1) {
					System.out.println(a);
				}else {
					System.out.print(a+"x");
				}
				n/=a;
			}else { //나눠 떨어지지 않으면 pass
				a++;
			}
		}
	}
	//소수 구하기
	public static boolean isPrime(int n) {
		boolean isS = true;
		for (int i = 2; i <= (int)Math.sqrt(n); i++) {
			if(n%i == 0) {
				isS = false;
				break;
			}
		}
		return isS;
	}
	public static void printPrime() {
		for (int i = 2; i < 100; i++) {
			if(isPrime(i)) {
				System.out.println(i);
			}
		}
	}
	//완전수
	public static void printPerfect(int t1,int t2) {
		for (int i = t1; i < t2; i++) {
			if(i == divide(i)) {
				System.out.printf("완전 수 : %d", i);
				printDivide(i);
			}
		}
	}
	private static int divide(int n) {
		int tot = 1;
		for (int i = 2; i < n; i++) {
			if(n % i == 0) {
				tot+=i;
			}
		}
		return tot;
	}
}
