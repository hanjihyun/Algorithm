class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int temp = x;
        int Ans = 0;
        while(temp >= 10){
            Ans += temp % 10;
            temp = temp/10;
        }
         Ans = Ans + temp;
        
        if(x % Ans == 0){
            answer = true;
        }else{
             answer = false;
        }
        return answer;
    }
}