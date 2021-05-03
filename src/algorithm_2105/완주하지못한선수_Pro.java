package algorithm_2105;

import java.util.Arrays;

public class 완주하지못한선수_Pro {
    public static void main(String[] args) {
        String[] participant = { "mislav", "stanko", "mislav", "ana" };
        String[] completion = { "stanko", "ana", "mislav" };
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                answer = participant[i];
                break;
            }
        }
        if (answer.equals("")) {
            answer = participant[participant.length - 1];
        }
        System.out.println(answer);
    }
}
