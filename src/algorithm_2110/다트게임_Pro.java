package algorithm_2110;

public class 다트게임_Pro {
	public static void main(String[] args) {
		String dartResult = "1S2D*3T";
		int answer = 0;
		int idx = -1;
		int[] nums = new int[3];

		for (int i = 0; i < dartResult.length(); i++) {

			int tmp = dartResult.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				idx++;
				if (tmp == '1' && dartResult.charAt(i + 1) == '0') {
					nums[idx] = 10;
					i++;
				} else {
					nums[idx] = tmp - '0';
				}
			}

			if (dartResult.charAt(i) == '*') {
				if (idx > 0) {
					nums[idx - 1] *= 2;
				}
				nums[idx] *= 2;
			} else if (dartResult.charAt(i) == '#') {

				nums[idx] *= -1;

			} else if (dartResult.charAt(i) == 'D') {
				nums[idx] = (int) Math.pow(nums[idx], 2);
			} else if (dartResult.charAt(i) == 'T') {
				nums[idx] = (int) Math.pow(nums[idx], 3);
			}

		}

		answer = nums[0] + nums[1] + nums[2];
		System.out.println(answer);
	}
}
