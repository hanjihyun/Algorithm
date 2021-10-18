package algorithm_2110;

public class 셀프넘버_백준4673 {
	public static void main(String[] args) {
		boolean[] check = new boolean[10001];

		for (int i = 1; i < 10001; i++) {
			int num = selfnumber(i);
			if (num <= 10000)
				check[num] = true;
		}
		for(int i=1;i<10001;i++) {
			if(!check[i]) {
				System.out.println(i);
			}
		}
	}

	private static int selfnumber(int num) {
		int sum = num;
		while(num != 0) {
			sum += num %10;
			num = num / 10;
		}
		return sum;
	}

}
