package algorithm_2110;

public class 로또의최고순위와최저순위_Pro {
	public static void main(String[] args) {
		int[] lottos = { 0, 0, 0, 0, 0, 0 };
		int[] win_nums = {38, 19, 20, 40, 15, 25 };
		int[] answer = new int[2];
		int chk = 0;
		int ze = 0;
		for (int i = 0; i < 6; i++) {
			if(lottos[i] == 0) {
				ze++;
			}
			for (int j = 0; j < 6; j++) {
				if(lottos[i] == win_nums[j]) {
					chk ++;
				}
				
			}
		}
		
	
		int sum = chk + ze;
	
		if(sum>=6) {
			answer[0] = 1;
		}else if(sum==5) {
			answer[0] = 2;
		}else if(sum==4) {
			answer[0] = 3;
		}else if(sum==3) {
			answer[0] = 4;
		}else if(sum==2) {
			answer[0] = 5;
		}else if(sum==1 || sum ==0) {
			answer[0] = 6;
		}
		
		if(chk>=6) {
			answer[1] = 1;
		}else if(chk==5) {
			answer[1] = 2;
		}else if(chk==4) {
			answer[1] = 3;
		}else if(chk==3) {
			answer[1] = 4;
		}else if(chk==2) {
			answer[1] = 5;
		}else if(chk==1 || chk ==0) {
			answer[1] = 6;
		}
		

		System.out.println(answer[0]+" "+answer[1]);
	
	}
}
