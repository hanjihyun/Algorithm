package algorithm_2106;

public class 시저암호_Pro {
	public static void main(String[] args) {
		String s = "a B Z";
		int n = 20;
		String answer = "";
 
		for (int j = 0; j < s.length(); j++) {
			//대문자
			if (((int) s.charAt(j) >= 65 && (int) s.charAt(j) <= 90)) {
				if((int) s.charAt(j) + n > 90) {
					answer += (char) (64 + (((int) s.charAt(j) + n)-90));
				} else {
					answer += (char) ((int) s.charAt(j) + n);
				}
			}else if(( (int) s.charAt(j) >= 97 && (int) s.charAt(j) <= 122)){
				//소문자 일 때
				if((int) s.charAt(j) + n > 122) {
					answer += (char) (96 + (((int) s.charAt(j) + n)-122));
				} else {
					answer += (char) ((int) s.charAt(j) + n);
				}
			}
			else {
				answer += s.charAt(j);
			}
		}
		System.out.println(answer);

	}
}
