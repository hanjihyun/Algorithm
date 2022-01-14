package algorithm_2201;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class 신고결과받기_Pro {
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;
		int[] answer = new int[id_list.length];
		int[] cnt = new int[id_list.length];
		
		HashSet<String> hash = new HashSet<String>();
		List<String>[] memory = new ArrayList[id_list.length];
		
		for (int i = 0; i < id_list.length; ++i) {
			memory[i] = new ArrayList<String>();
		}
		
		//중복 신고 처리
		for (int i = 0; i < report.length; i++) {
			hash.add(report[i]);
		}
		Iterator<String> it = hash.iterator();
		
		while(it.hasNext()) {
			String[] s = new String[2];
			s = it.next().split(" ");
			for (int i = 0; i < id_list.length; i++) {
				if(id_list[i].equals(s[1])) {
					cnt[i]++;
				}
			}
			for (int j = 0; j < id_list.length; j++) {
				if(id_list[j].equals(s[0])){
					memory[j].add(s[1]);
				}
			}
		}
		
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < cnt.length; i++) {
			if(cnt[i] >=k) {
				list.add(id_list[i]);
			}
		}
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[i].size(); j++) {
				for (int h = 0; h < list.size(); h++) {
					if(memory[i].get(j).equals(list.get(h))){
						answer[i]++;
					}
				}
				
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
