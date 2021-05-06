package algorithm_2105;

public class _124나라의숫자 {
    public String solution(int n) {
        String answer = "";
        String[] num = { "4", "1", "2" };
        while (n > 0) {
            answer = num[n % 3] + answer;
            n = (n - 1) / 3;
        }
        // int r = 0;
        // while(n>0){
        // r = n %3;
        // n /= 3;
        // if(r==0){
        // n--;
        // r=4;
        // }

        // answer = r + answer;

        // }
        return answer;
    }
}
