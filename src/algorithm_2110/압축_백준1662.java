package algorithm_2110;

import java.util.Scanner;
import java.util.Stack;

public class 압축_백준1662 {
	static String str;
	static Stack<String> s = new Stack<String>();
public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);
	str = sc.next();
	
	for (int i = 0; i < str.length(); i++) {
		String cur = str.charAt(i)+"";
		if(!cur.equals(")")) {
			s.add(cur);
		}else {
			int cnt =0;
			while(!s.peek().equals("(")) {
				String po = s.pop();
				if(po.equals("*")) {
					cnt+= Integer.parseInt(s.pop());
				}else {
					++cnt;
				}
			}
			s.pop();
			int k = Integer.parseInt(s.pop());
			cnt *= k;
			s.add(String.valueOf(cnt));
			s.add("*");
		}
	}
	
	int len = 0;
	while(!s.isEmpty()) {
		String st = s.pop();
		if(st.equals("*")) {
			len+=Integer.parseInt(s.pop());
		}else {
			len+=1;
		}
	}
	System.out.println(len);
}
}
