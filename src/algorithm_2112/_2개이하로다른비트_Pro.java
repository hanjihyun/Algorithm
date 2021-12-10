package algorithm_2112;

public class _2개이하로다른비트_Pro {
	public static void main(String[] args) {
		long[] numbers = { 2, 7 };
		long[] answer = new long[numbers.length];

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] % 2 == 0) {
				answer[i] = numbers[i] + 1;
			} else {
				String binary = Long.toString(numbers[i], 2);
				int last = binary.lastIndexOf("0");
				int first = binary.indexOf("1", last);
				if (last == -1) {
					binary = "10" + binary.substring(1, binary.length());	answer[i] = Long.parseLong(binary, 2);
				} else {
					binary = binary.substring(0, last) + "10" + binary.substring(last + 2, binary.length());
					answer[i] = Long.parseLong(binary, 2);
				}
			}
		
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
