package algorithm_2203;

public class 입국심사_PRo {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		long answer = 0;

		long left = 0;
		long right = (long) n * times[times.length - 1];

		while (left <= right) {
			long mid = (left + right) / 2;
			long sum = 0;
			for (int i = 0; i < times.length; i++) {
				sum += mid / times[i];
			}
			if (sum < n) {
				left = mid + 1;
			}else { 
                right = mid - 1;
                answer = mid;
            }

		}
		System.out.println(answer);
	}
}
