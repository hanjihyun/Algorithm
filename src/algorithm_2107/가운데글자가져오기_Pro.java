package algorithm_2107;

public class 가운데글자가져오기_Pro {
	public static void main(String[] args) {
		String s = "qwer";
		String answer = "";
		int size = s.length();
		if(size%2 == 0) {
			answer += s.charAt(size/2-1);
			answer += s.charAt(size/2);
			
		}else {
			answer += s.charAt(size/2);
		}
		
		System.out.println(answer);
	}
}
