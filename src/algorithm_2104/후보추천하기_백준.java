package algorithm_2104;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 후보추천하기_백준 {
	static int N, Re;
	static int[] photo, score;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		Re = sc.nextInt();
		photo = new int[Re];
		score = new int[101];
		for (int i = 0; i < Re; i++) {
			photo[i] = sc.nextInt();
		}

		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < Re; i++) {
			if (score[photo[i]] == 0) {
				if (list.size() < N) {

					list.add(photo[i]);
					score[photo[i]]++;
				}
				else {
					int min = 0;
					int min_st = Integer.MAX_VALUE;
					int min_st_idx = 0;
					for (int j = 0; j < list.size(); j++) {
						int student_number = list.get(j);

						if (min_st > score[student_number]) {
							min_st = score[student_number];
							min = student_number;
							min_st_idx = j;
						}
					}
					score[min] = 0;
					list.remove(min_st_idx);
					list.add(photo[i]);
					score[photo[i]]++;
				}
			} else {
				score[photo[i]]++;
			}
		}
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}
}
