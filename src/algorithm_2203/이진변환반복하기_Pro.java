package algorithm_2203;

public class 이진변환반복하기_Pro {
	public static void main(String[] args) {
		String s = "110010101001";
		int[] answer = new int[2];
		
		int cnt = 0;
		int cnt_z = 0;
		
		while(!s.equals("1")) {
			int cnt_o = 0;
			for (int i = 0; i < s.length(); i++) {
				if(s.charAt(i)=='1') {
					cnt_o++;
				}else {
					cnt_z++;
				}
			}
			s = Integer.toBinaryString(cnt_o);
			cnt++;
		}
		answer[0] = cnt;
		answer[1] = cnt_z;
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]+" ");
		}
	}
}
