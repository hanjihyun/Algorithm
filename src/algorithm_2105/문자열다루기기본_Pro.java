package algorithm_2105;

public class 문자열다루기기본_Pro {
	
	public static void main(String[] args) {
		String s = "1234";
		boolean answer = true;

		if(s.length() == 4 || s.length() == 6) {
			answer = true;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					answer = true;
				}else {
					answer = false;
					break;
				}
				
			}
		}else {
			answer = false;
		}
		System.out.println(answer);
	}
}
