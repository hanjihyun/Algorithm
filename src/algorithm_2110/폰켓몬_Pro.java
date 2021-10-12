package algorithm_2110;

import java.util.HashSet;

public class 폰켓몬_Pro {
	public static void main(String[] args) {
		int[] nums = { 3, 1, 2, 3 };
		int answer = 0;
		
		int total = nums.length;
		int sel = nums.length / 2;
		int cnt = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			set.add(nums[i]);
		}
		cnt = set.size();

		if (cnt >= sel) {
			answer = sel;
		} else {
			answer = cnt;
		}
		
		System.out.println(answer);
	}
}
