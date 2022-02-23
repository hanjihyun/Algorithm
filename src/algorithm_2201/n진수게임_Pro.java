package algorithm_2201;

public class n진수게임_Pro {
	public static void main(String[] args) {
		int n = 2;
		int t = 4;
		int m = 2;
		int p = 1;

		String answer = "";
		int len = m*(t-1)+p;
		int idx = 0;
		String str = "";
		while(str.length() <len) {
			str+=(Integer.toString(idx,n).toUpperCase());
			idx++;
		}
		
		String tmp = "";
		
		for (int i = 0; i < t; i++) {
			tmp+=(str.toString().charAt(i*m+p-1));
		}
		answer = tmp.toString();
		
		System.out.println(answer);
	}
}
