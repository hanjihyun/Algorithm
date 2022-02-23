package algorithm_2202;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 메뉴리뉴얼_Pro {
	public static void main(String[] args) {
		String[] orders = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		int[] course = { 2, 3, 4 };
		
		 List<String> answer = new ArrayList<>();
		 
		 for (int i = 0; i < course.length; i++) {
			Map<String, Integer> map = new HashMap<>();
			
			for (int j = 0; j < orders.length; j++) {
				map = dfs(orders[j],"",course[i],0,0,map);
			}
			int max = -1;
			for (String k : map.keySet()) {
				max = Math.max(max, map.get(k));
			}
			for (String k : map.keySet()) {
				if(map.get(k)>=2) {
					if(max == map.get(k)) answer.add(k);
				}
			}
		 }
		 answer.sort(Comparator.naturalOrder());
		 answer.toArray(new String[answer.size()]);
		 
		 for (int i = 0; i < answer.size(); i++) {
			System.out.println(answer.get(i));
		}
	}

	private static Map<String, Integer> dfs(String order, String tmp, int max, int lev, int start,
			Map<String, Integer> map) {
		if (lev == max) {
            char[] carr = tmp.toCharArray();
            Arrays.sort(carr);
            tmp = String.valueOf(carr);
            map.put(tmp, map.getOrDefault(tmp,Integer.valueOf(0))+1);
        } else {
            for (int i=start; i<order.length(); i++) {
                dfs(order, tmp+String.valueOf(order.charAt(i)), max, lev+1, i+1, map);
            }
        }
        return map;
	}
}
