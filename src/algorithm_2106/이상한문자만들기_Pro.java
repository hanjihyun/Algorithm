package algorithm_2106;

public class 이상한문자만들기_Pro {
	public static void main(String[] args) {
		String s = "tolower  rtert";
		String answer = "";
		String[] str = new String[s.length()];
		
		for (int i = 0; i < s.length(); i++) {
			str[i] = s.charAt(i) + "";
		}
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			if(num % 2 == 0 && !str[i].equals(" ")) {
				str[i] = str[i].toUpperCase();
				num++;
			}else if(num % 2 != 0 && !str[i].equals(" ")) {
				str[i] = str[i].toLowerCase();
				num++;
			}
			if(str[i].equals(" ")) {
				str[i] = " ";
				num = 0;
			}
		}
		for (int i = 0; i < s.length(); i++) {
//			System.out.print(str[i]);
			answer += str[i];
		}
		System.out.println(answer);
	}
}
