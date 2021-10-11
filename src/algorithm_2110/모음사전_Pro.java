package algorithm_2110;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 모음사전_Pro {
	static char[] arr = { 'A', 'E', 'I', 'O', 'U' };
	static List<String> ans;

	public static void main(String[] args) {
		String word = "AAAAE";
		int answer = 0;

		ans=new ArrayList<>();
		
        for(int i=1; i<=5; i++) {
            dfs(0,new String(), i);
        }
        
        Collections.sort(ans);
        int index=1;
        for(String tmp: ans){
            if(word.equals(tmp)){
                answer=index;
                break;
            }
            index++;
        }
		System.out.println(answer);
    }
    static void dfs(int dep, String s, int len){
        if(len == dep){
            ans.add(s);
            return;
        }
        for(int i=0; i<5; i++){
            dfs(dep+1, s+arr[i], len);            
        }
    }
}
