package algorithm_2111;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class 위장_Pro {
	public static void main(String[] args) {
		String[][] clothes = { { "yellowhat", "headgear" }, { "bluesunglasses", "eyewear" },
				{ "green_turban", "headgear" } };
		
		int answer = 1;
		HashMap<String, Integer> combi = new HashMap<String, Integer>();
		
		for (int i = 0; i < clothes.length; i++) {
			combi.put(clothes[i][1], combi.getOrDefault(clothes[i][1],0)+1);
		}
		Set<String> key = combi.keySet();
		
		for (String k : key) {
			answer *= combi.get(k)+1;
		}
		
		System.out.println(answer-1);
	}
}
