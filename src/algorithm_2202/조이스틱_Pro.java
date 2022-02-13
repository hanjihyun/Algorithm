package algorithm_2202;

public class 조이스틱_Pro {
	public static void main(String[] args) {
		String name = "JEROEN";
		int answer = 0;
		int len = name.length();
		int min = len - 1;
		for (int i = 0; i < len; i++) {
			char c = name.charAt(i);

			answer += Math.min(c - 'A', 'Z' - c + 1);

			int next_idx = i + 1;
			
			while (next_idx < len && name.charAt(next_idx) == 'A')
				next_idx++;
			
			min = Math.min(min, 2 * i + (len - next_idx));
		}
		answer += min;

		System.out.println(answer);
	}
}
