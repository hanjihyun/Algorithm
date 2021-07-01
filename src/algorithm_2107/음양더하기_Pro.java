package algorithm_2107;

public class 음양더하기_Pro {
	public static void main(String[] args) {
		int[] absolutes = { 4, 7, 12 };
		boolean[] signs = { true, false, true };
		
		int answer = 0;
		
		for (int i = 0; i < absolutes.length; i++) {
			if(signs[i] == true) {
				answer+=absolutes[i];
			}else if(signs[i] == false) {
				answer-=absolutes[i];
			}
		}
		
		System.out.println(answer);
	}
}
