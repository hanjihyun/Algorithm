package algorithm_2105;

public class 타겟넘버_Pro {
	static int answer = 0;
	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;
		
		dfs(numbers,target,0,0);
		System.out.println(answer);
	}
	private static void dfs(int[] numbers, int target, int idx, int sum) {
		
		if(idx==numbers.length) {
			if(sum == target) {
				answer++;
			}
		}else if(idx<numbers.length) {
			dfs(numbers,target, idx+1,sum+numbers[idx]);
			dfs(numbers,target,idx+1,sum-numbers[idx]);
		}
	}

	
}
