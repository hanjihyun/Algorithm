package algorithm_2107;

public class 숫자문자열과영단어_Pro {
	public static void main(String[] args) {
		String s = "one4seveneight";
		int answer = 0;
		String word[] = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		String number[] = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
		
		for (int i=0; i<10; i++) {
			s = s.replaceAll(word[i], number[i]);
		}
		answer = Integer.parseInt(s);
		System.out.println(answer);
	}
}
