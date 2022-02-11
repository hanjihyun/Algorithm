package algorithm_2202;

import java.util.Arrays;
import java.util.HashSet;

public class 튜플_Pro {
public static void main(String[] args) {
	String s= "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] answer = {};
        HashSet<Integer> hash = new HashSet<>();
        s = s.substring(2  ,s.length()-2).replace("},{","-");
       
        String[] str = s.split("-");
        answer = new int[str.length];
       
        Arrays.sort(str, (a,b)->(a.length()-b.length()));
        int i=0;
       for (String strs1 : str) {
		for (String strs2 : strs1.split(",")) {
			int u = Integer.parseInt(strs2.trim());
			if(hash.contains(u))continue;
			hash.add(u);
			answer[i++] = u;
		}
       }
		for (int j = 0; j < answer.length; j++) {
			System.out.println(answer[j]);
		}
	
}
}