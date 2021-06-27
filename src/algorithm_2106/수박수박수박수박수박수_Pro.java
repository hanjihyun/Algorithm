package algorithm_2106;

public class 수박수박수박수박수박수_Pro {
	public static void main(String[] args) {
		int n = 3;
		String answer = "";
		int cnt = 0;
		while(cnt<n) {
			if(cnt % 2 == 0) {
				answer += "수";
				cnt++;
			}else {
				answer += "박";
				cnt++;
			}
		}
		System.out.println(answer);
	}
}
