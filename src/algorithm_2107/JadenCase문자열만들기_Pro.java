package algorithm_2107;

public class JadenCase문자열만들기_Pro {
	public static void main(String[] args) {
		String s = "3people unFollowed me";
		String answer = "";

		String[] list = new String[s.length()];

		for (int i = 0; i < s.length(); i++) {
			list[i] = s.charAt(i) + "";
		}
		boolean chk = true;
		for (int i = 0; i < list.length; i++) {
			if (chk == true) {
				list[i] = list[i].toUpperCase();
			} else {
				list[i] = list[i].toLowerCase();
			}
			if (list[i].equals(" ")) {
				chk = true;
			} else {
				chk = false;
			}
		}

		for (int i = 0; i < list.length; i++) {

			answer += list[i];
		}
		
		System.out.println(answer);
	}
}
