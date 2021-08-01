package algorithm_2108;

public class 키패드누르기_Pro {
	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";
		int locL = 10;
		int locR = 12;
		String answer = "";

		for (int i = 0; i < numbers.length; i++) {
			if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
				answer += "L";
				locL = numbers[i];
			} else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
				answer += "R";
				locR = numbers[i];
			} else {
				int leftLength = getLength(locL, numbers[i]);
				int rightLength = getLength(locR, numbers[i]);

				if(leftLength > rightLength) {
					answer += "R";
					locR = numbers[i];
				} else if(leftLength < rightLength) {
					answer += "L";
					locL = numbers[i];
				} else {
					if(hand.equals("right")) {
						answer += "R";
						locR = numbers[i];
					} else {
						answer += "L";
						locL = numbers[i];
					}
				}
			}
		}

		System.out.println(answer);
	}


	private static int getLength(int index, int number) {
		// 숫자 0의 경우 11로 치환
				index = (index == 0) ? 11 : index;	
				number = (number == 0) ? 11 : number;

				int x = (index - 1) / 3;
				int y = (index - 1) % 3;
				int numberX = number / 3;
				int numberY = 1;

				return Math.abs(x-numberX) + Math.abs(y-numberY);
	}
}
