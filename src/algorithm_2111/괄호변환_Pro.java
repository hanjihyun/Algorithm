package algorithm_2111;

import java.util.Stack;

public class 괄호변환_Pro {
	public static void main(String[] args) {
		String p = "()))((()";
		String answer = "";
		
		if(chk(p)) {
			System.out.println(p);
		}else {
			System.out.println(dfs(p));
		}
		
	}

	private static String dfs(String p) {
		if(p.length()==0) return "";
		
		String u="";
		String v="";
		
		int cnt1=0,cnt2=0;
		for (int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(c=='(')cnt1++;
			else cnt2++;
			
			if((cnt1 != 0 && cnt2 != 0) &&cnt1==cnt2){
				u = p.substring(0,i+1);
				if(i!=p.length()-1) {
					v = p.substring(i+1,p.length());
				}
				break;
			}
		}
		if(!chk(u)) {
		
			String tmp = "(" + dfs(v);
			tmp+=")";
			u = u.substring(1,u.length()-1);
			u=u.replace("(", ".");
			u=u.replace(")", "(");
			u=u.replace(".", ")");
			tmp+=u;
			
			return tmp;
		}else {
			return u+dfs(v);
		}
		
	}

	private static boolean chk(String p) {
	
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < p.length(); i++) {
			if(p.charAt(i)=='(') {
				stack.add(p.charAt(i));
			}else {
				if(stack.isEmpty()) {
					return false;
				}else {
					stack.pop();
				}
			}
		}
		if(!stack.isEmpty()) {
			return false;
		}
		
		return true;
	}
}
