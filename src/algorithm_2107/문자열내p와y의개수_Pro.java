package algorithm_2107;

public class 문자열내p와y의개수_Pro {
	public static void main(String[] args) {
		String s = "Pyy";
		boolean answer = true;
		
		String str = s.toLowerCase();
		
		int cntP = 0;
		int cntY = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == 'y') {
				cntY++;
			}else if(str.charAt(i) == 'p') {
				cntP++;
			}
		}
		if(cntP != cntY) {
			answer = false;
		}
		
		System.out.println(answer);
	}
}
