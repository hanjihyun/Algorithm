package algorithm_2111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class 베스트셀러_백준1302 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		String maxBook = "";
		int max = 0;
		for (int i = 0; i < N; i++) {
			String book = br.readLine();
			if (!map.containsKey(book)) {
				map.put(book, 1);
			} else {
				map.put(book, map.get(book) + 1);
			}
		}

		for (String key : map.keySet()) {
			int value = map.get(key);

			if (max == value && maxBook.compareTo(key) > 0) {
				maxBook = key;
				max = value;
			} else if (max < value) {
				maxBook = key;
				max = value;
			}
		}
		System.out.println(maxBook);
	}
}
