package algorithm_2106;

public class 서울에서김서방찾기_Pro {
	public static void main(String[] args) {
		String[] seoul = { "Jane", "Kim" };
		String answer = "김서방은 ";
		for (int i = 0; i < seoul.length; i++) {
			if(seoul[i].equals("Kim")) {
				answer += i+"에 있다";
				break;
			}
		}
		System.out.println(answer);
		
	}
}
