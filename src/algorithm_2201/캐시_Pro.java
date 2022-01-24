package algorithm_2201;

import java.util.LinkedList;

public class 캐시_Pro {
	public static void main(String[] args) {
		int cacheSize = 3;
		String[] cities = { "Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA" };

		int answer = 0;
		
		if(cacheSize==0) {
			System.out.println(5*cities.length);
		}
		
		LinkedList<String> cache = new LinkedList<String>();
		
		for (int i = 0; i < cities.length; i++) {
			String city = cities[i].toUpperCase();
			
			if(cache.remove(city)) {
				cache.addFirst(city);
				answer+=1;
			}else {
				int cur = cache.size();
				if(cur == cacheSize) {
					cache.pollLast();
				}
				cache.addFirst(city);
				answer += 5;
			}
		}
		System.out.println(answer);
	}
}
