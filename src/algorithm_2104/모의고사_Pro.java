package algorithm_2104;

import java.util.ArrayList;
import java.util.List;

public class 모의고사_Pro {
    public static void main(String[] args) {
        int[] answers = { 1, 2, 3, 4, 5 };
        int[] answer = new int[5];
        List<Integer> temp = new ArrayList<Integer>();
        int n = answers.length;
        System.out.println(n);

        int[] num1 = { 1, 2, 3, 4, 5 };
        int[] num2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
        int[] num3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };
        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;
        for (int i = 0; i < n; i++) {
            if (num1[i % 5] == answers[i]) {
                cnt1++;
            }
            if (num2[i % 8] == answers[i]) {
                cnt2++;
            }
            if (num3[i % 10] == answers[i]) {
                cnt3++;
            }
        }
        int max = cnt1;
        temp.add(1);
        if (max < cnt2) {
            temp.clear();
            temp.add(2);
            max = cnt2;
        } else if (max == cnt2) {
            temp.add(2);
        }
        if (max < cnt3) {
            temp.clear();
            temp.add(3);
            max = cnt3;
        } else if (max == cnt3) {
            temp.add(3);
        }
        answer = new int[temp.size()];
        for (int i = 0; i < temp.size(); i++) {
            answer[i] = temp.get(i);
        }
        System.out.println(answer);

    }
}
