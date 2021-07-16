package algorithm_2107;

public class 주식가격_Pro {
	public static void main(String[] args) {
		int[] prices = { 1, 2, 3, 2, 3 };
		int[] answer = new int[prices.length];
		
		 for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[i] <= prices[j]) {
					answer[i]++;
				}else if(prices[i] > prices[j]) {
					answer[i]++;
					break;
				}
			}
		}
		 for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
