package algorithm_2111;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class 오픈채팅방_Pro {

	static List<String> list = new ArrayList<>();
	static Map<String, String> map = new HashMap();

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		for (int i = 0; i < record.length; i++) {
			String[] s = record[i].split(" ");

			if (s[0].equals("Enter")) {
				list.add(s[1] + "님이 들어왔습니다.");
				map.put(s[1], s[2]);
			} else if (s[0].equals("Change")) {
				map.put(s[1], s[2]);
			} else {
				list.add(s[1] + "님이 나갔습니다.");
			}

		}
		String[] answer = new String[list.size()];

		for (int i = 0; i < list.size(); i++) {
			int idx = list.get(i).indexOf("님");
			String id = list.get(i).substring(0, idx);
			String[] tmp = list.get(i).split(" ");
			answer[i] = map.get(id) + "님이 " + tmp[1];
		}
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}
	}
}
